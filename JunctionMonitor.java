import java.util.Collections;

public class JunctionMonitor extends Monitor {
	enum State {
		State_0,
		State_1,
		State_2,
		State_3
	}
	private State currentState;

	JunctionMonitor() { resetMonitor(); }

	@Override
	public int resetMonitor() {
		this.setRequirementSatisfied(0);
		this.setActivated(false);
		this.setName("JunctionMonitor");

		currentState = State.State_0;
		if(currentState.equals(State.State_3)) {
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

		boolean[] letters = new boolean[3];
		System.out.println(getMessagePrefix() + "State before update: " + currentState);

		java.util.List<String> signals_used = new java.util.ArrayList<>();
		if(signals.contains("lamp.updatestatus().controller")) {
			letters[0] = true;
			signals_used.add("lamp.updatestatus().controller");
		}
		if(signals.contains("appear(junction.trafficlamp)")) {
			letters[1] = true;
			signals_used.add("appear(junction.trafficlamp)");
		}
		if(signals.contains("controller.turnyellow().lamp")) {
			letters[2] = true;
			signals_used.add("controller.turnyellow().lamp");
		}
		System.out.println(getMessagePrefix() + "Signals sent: " + String.join("; ", signals));
		System.out.println(getMessagePrefix() + "Signals used: " + String.join("; ", signals_used));

		switch(currentState) {
			case State_0:
				if((!(letters[0])) && (!(letters[1])) && (!(letters[2]))) {
					currentState = State.State_0;
				}
				else if((letters[0]) && (!(letters[1])) && (!(letters[2]))) {
					currentState = State.State_0;
				}
				else if((!(letters[0])) && (letters[1]) && (!(letters[2]))) {
					currentState = State.State_0;
				}
				else if((!(letters[0])) && (!(letters[1])) && (letters[2])) {
					currentState = State.State_1;
				}
				else if((letters[0]) && (letters[1]) && (!(letters[2]))) {
					currentState = State.State_0;
				}
				else if((letters[0]) && (!(letters[1])) && (letters[2])) {
					currentState = State.State_1;
				}
				else if((!(letters[0])) && (letters[1]) && (letters[2])) {
					currentState = State.State_1;
				}
				else if((letters[0]) && (letters[1]) && (letters[2])) {
					currentState = State.State_1;
				}
				break;
			case State_1:
				if((!(letters[0])) && (!(letters[1])) && (!(letters[2]))) {
					currentState = State.State_1;
				}
				else if((letters[0]) && (!(letters[1])) && (!(letters[2]))) {
					currentState = State.State_1;
				}
				else if((!(letters[0])) && (letters[1]) && (!(letters[2]))) {
					currentState = State.State_2;
				}
				else if((!(letters[0])) && (!(letters[1])) && (letters[2])) {
					currentState = State.State_1;
				}
				else if((letters[0]) && (letters[1]) && (!(letters[2]))) {
					currentState = State.State_2;
				}
				else if((letters[0]) && (!(letters[1])) && (letters[2])) {
					currentState = State.State_1;
				}
				else if((!(letters[0])) && (letters[1]) && (letters[2])) {
					currentState = State.State_2;
				}
				else if((letters[0]) && (letters[1]) && (letters[2])) {
					currentState = State.State_2;
				}
				break;
			case State_2:
				if((!(letters[0])) && (!(letters[1])) && (!(letters[2]))) {
					currentState = State.State_2;
				}
				else if((letters[0]) && (!(letters[1])) && (!(letters[2]))) {
					currentState = State.State_3;
					return goodStateReached();
				}
				else if((!(letters[0])) && (letters[1]) && (!(letters[2]))) {
					currentState = State.State_2;
				}
				else if((!(letters[0])) && (!(letters[1])) && (letters[2])) {
					currentState = State.State_2;
				}
				else if((letters[0]) && (letters[1]) && (!(letters[2]))) {
					currentState = State.State_3;
					return goodStateReached();
				}
				else if((letters[0]) && (!(letters[1])) && (letters[2])) {
					currentState = State.State_3;
					return goodStateReached();
				}
				else if((!(letters[0])) && (letters[1]) && (letters[2])) {
					currentState = State.State_2;
				}
				else if((letters[0]) && (letters[1]) && (letters[2])) {
					currentState = State.State_3;
					return goodStateReached();
				}
				break;
			case State_3:
					return goodStateReached();
		}
		System.out.println(getMessagePrefix() + "State after update: " + currentState + "\n");

		return 0;
	}
}