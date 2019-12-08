import java.util.Collections;

public class armsMonitor extends Monitor {
	enum State {
		State_0,
		State_1,
		State_2,
		State_3
	}
	private State currentState;

	armsMonitor() { resetMonitor(); }

	@Override
	public int resetMonitor() {
		this.setRequirementSatisfied(0);
		this.setActivated(false);
		this.setName("armsMonitor");

		currentState = State.State_3;
		if(currentState.equals(State.State_0)) {
			return badStateReached(currentState.toString(), "");
		}
		else if(currentState.equals(State.State_1)) {
			return goodStateReached();
		}
		return 0;
	}

	@Override
	protected int goodStateReached() {
		System.out.println(getMessagePrefix() + "Good state reached!");
		setRequirementSatisfied(1);
		return 1;
	}

	@Override
	protected int badStateReached(String lastState, String lastEvent) {
		System.out.println(getMessagePrefix() + "Bad state reached!");
		setRequirementSatisfied(-1);
		return -1;
	}

	@Override
	public int update(String signal_sequence) {
		java.util.List<String> signals = new java.util.ArrayList<>();
		Collections.addAll(signals, signal_sequence.toLowerCase().split("\\s*;\\s*"));

		boolean[] letters = new boolean[2];
		System.out.println(getMessagePrefix() + "State before update: " + currentState);

		java.util.List<String> signals_used = new java.util.ArrayList<>();
		if(signals.contains("controller.disabled().segment")) {
			letters[0] = true;
			signals_used.add("controller.disabled().segment");
		}
		if(signals.contains("controller.enabled().segment")) {
			letters[1] = true;
			signals_used.add("controller.enabled().segment");
		}
		System.out.println(getMessagePrefix() + "Signals sent: " + String.join("; ", signals));
		System.out.println(getMessagePrefix() + "Signals used: " + String.join("; ", signals_used));

		int result = 0;
		switch(currentState) {
			case State_0:
				result = State_0(letters, signal_sequence);
				break;
			case State_1:
				result = State_1(letters, signal_sequence);
				break;
			case State_2:
				result = State_2(letters, signal_sequence);
				break;
			case State_3:
				result = State_3(letters, signal_sequence);
				break;
		}
		System.out.println(getMessagePrefix() + "State after update: " + currentState + "\n");

		return result;
	}

	private int State_0(boolean[] letters, String signal_sequence) {
			return badStateReached(currentState.toString(), signal_sequence);
	}

	private int State_1(boolean[] letters, String signal_sequence) {
			return goodStateReached();
	}

	private int State_2(boolean[] letters, String signal_sequence) {
		if((!(letters[0])) && (!(letters[1]))) {
			currentState = State.State_0;
			return badStateReached(currentState.toString(), signal_sequence);
		}
		else if((letters[0]) && (!(letters[1]))) {
			currentState = State.State_1;
			return goodStateReached();
		}
		else if((!(letters[0])) && (letters[1])) {
			currentState = State.State_0;
			return badStateReached(currentState.toString(), signal_sequence);
		}
		else if((letters[0]) && (letters[1])) {
			currentState = State.State_1;
			return goodStateReached();
		}

		return 0;
	}

	private int State_3(boolean[] letters, String signal_sequence) {
		if((!(letters[0])) && (!(letters[1]))) {
			currentState = State.State_0;
			return badStateReached(currentState.toString(), signal_sequence);
		}
		else if((letters[0]) && (!(letters[1]))) {
			currentState = State.State_0;
			return badStateReached(currentState.toString(), signal_sequence);
		}
		else if((!(letters[0])) && (letters[1]))
			currentState = State.State_2;
		else if((letters[0]) && (letters[1]))
			currentState = State.State_2;

		return 0;
	}

}