import java.util.Collections;

public class JunctionMonitor extends Monitor {
	enum State {
		State_0,
		State_1,
		State_2,
		State_3,
		State_4,
		State_5,
		State_6,
		State_7,
		State_8,
		State_9,
		State_10,
		State_11,
		State_12
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
		else if(currentState.equals(State.State_6)) {
			return goodStateReached();
		}
		else if(currentState.equals(State.State_9)) {
			return goodStateReached();
		}
		else if(currentState.equals(State.State_12)) {
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

		boolean[] letters = new boolean[6];
		System.out.println(getMessagePrefix() + "State before update: " + currentState);

		java.util.List<String> signals_used = new java.util.ArrayList<>();
		if(signals.contains("changeto(junction.distance.meter, 2)")) {
			letters[0] = true;
			signals_used.add("changeto(junction.distance.meter, 2)");
		}
		if(signals.contains("changeto(junction.car.speed, 0)")) {
			letters[1] = true;
			signals_used.add("changeto(junction.car.speed, 0)");
		}
		if(signals.contains("lamp.updatestatus().controller")) {
			letters[2] = true;
			signals_used.add("lamp.updatestatus().controller");
		}
		if(signals.contains("controller.turnoff().lamp")) {
			letters[3] = true;
			signals_used.add("controller.turnoff().lamp");
		}
		if(signals.contains("controller.turnred().lamp")) {
			letters[4] = true;
			signals_used.add("controller.turnred().lamp");
		}
		if(signals.contains("match(junction, redlight)")) {
			letters[5] = true;
			signals_used.add("match(junction, redlight)");
		}
		System.out.println(getMessagePrefix() + "Signals sent: " + String.join("; ", signals));
		System.out.println(getMessagePrefix() + "Signals used: " + String.join("; ", signals_used));

		int result = 0;
		switch(currentState) {
			case State_0:
				result = State_0(letters);
				break;
			case State_1:
				result = State_1(letters);
				break;
			case State_2:
				result = State_2(letters);
				break;
			case State_3:
				result = State_3(letters);
				break;
			case State_4:
				result = State_4(letters);
				break;
			case State_5:
				result = State_5(letters);
				break;
			case State_6:
				result = State_6(letters);
				break;
			case State_7:
				result = State_7(letters);
				break;
			case State_8:
				result = State_8(letters);
				break;
			case State_9:
				result = State_9(letters);
				break;
			case State_10:
				result = State_10(letters);
				break;
			case State_11:
				result = State_11(letters);
				break;
			case State_12:
				result = State_12(letters);
				break;
		}
		System.out.println(getMessagePrefix() + "State after update: " + currentState + "\n");

		return result;
	}

	private int State_0(boolean[] letters) {
		if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_0;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_0;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_0;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_0;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_0;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_0;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_0;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_0;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_0;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_0;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_0;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_0;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_0;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_0;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_0;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_0;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_0;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_0;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_0;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_0;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_0;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_0;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_0;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_0;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_0;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_0;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_0;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_0;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_0;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_0;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_0;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_0;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_1;

		return 0;
	}

	private int State_1(boolean[] letters) {
		if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_7;

		return 0;
	}

	private int State_2(boolean[] letters) {
		if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}

		return 0;
	}

	private int State_3(boolean[] letters) {
			return goodStateReached();
	}

	private int State_4(boolean[] letters) {
		if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_8;

		return 0;
	}

	private int State_5(boolean[] letters) {
		if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}

		return 0;
	}

	private int State_6(boolean[] letters) {
			return goodStateReached();
	}

	private int State_7(boolean[] letters) {
		if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_7;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_7;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_7;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_10;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_7;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_7;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_10;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_7;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_10;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_7;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_4;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_10;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_10;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_10;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_7;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_4;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_10;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_10;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_4;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_10;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_10;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_10;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_4;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_10;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_4;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_10;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_10;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_10;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_4;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_10;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_10;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_4;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_10;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_10;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_10;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_4;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_10;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_10;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_10;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_10;

		return 0;
	}

	private int State_8(boolean[] letters) {
		if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_8;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_11;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_8;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_12;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_11;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_5;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_11;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_11;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_12;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_6;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_12;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_12;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_5;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_11;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_11;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_11;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_5;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_11;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_6;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_12;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_12;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_12;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_6;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5])) {
			currentState = State.State_12;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_11;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_5;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_11;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_11;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_12;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_6;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5])) {
			currentState = State.State_12;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5])) {
			currentState = State.State_12;
			return goodStateReached();
		}
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_11;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5])) {
			currentState = State.State_12;
			return goodStateReached();
		}

		return 0;
	}

	private int State_9(boolean[] letters) {
			return goodStateReached();
	}

	private int State_10(boolean[] letters) {
		if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_7;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_7;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_10;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_7;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_8;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_10;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_7;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_11;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_4;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_10;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_10;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_11;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_8;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_4;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_10;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_10;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_7;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_1;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_5;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_11;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_11;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_10;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_4;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_10;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_5;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_11;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_11;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_10;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_4;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_10;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_7;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_11;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_5;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_11;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_10;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_11;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_5;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_11;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_10;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_11;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_11;

		return 0;
	}

	private int State_11(boolean[] letters) {
		if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_8;
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_11;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_8;
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_12;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_11;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_2;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_5;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_11;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_11;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_12;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_6;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_12;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_12;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])))
			currentState = State.State_5;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])))
			currentState = State.State_11;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]))
			currentState = State.State_11;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_8;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_2;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_11;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_5;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_11;
		else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5]))) {
			currentState = State.State_6;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_12;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_12;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_3;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_12;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_6;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5])) {
			currentState = State.State_12;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])))
			currentState = State.State_11;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]))
			currentState = State.State_5;
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]))
			currentState = State.State_11;
		else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_8;
		else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_11;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5]))) {
			currentState = State.State_12;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5])) {
			currentState = State.State_6;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5])) {
			currentState = State.State_12;
			return goodStateReached();
		}
		else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5])) {
			currentState = State.State_9;
			return goodStateReached();
		}
		else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5])) {
			currentState = State.State_12;
			return goodStateReached();
		}
		else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]))
			currentState = State.State_11;
		else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5])) {
			currentState = State.State_12;
			return goodStateReached();
		}

		return 0;
	}

	private int State_12(boolean[] letters) {
			return goodStateReached();
	}

}