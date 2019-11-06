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
		State_12,
		State_13,
		State_14
	}
	private State currentState;

	JunctionMonitor() { resetMonitor(); }

	@Override
	public int resetMonitor() {
		this.setRequirementSatisfied(0);
		this.setActivated(false);
		this.setName("JunctionMonitor");

		currentState = State.State_14;
		if(currentState.equals(State.State_4)) {
			return goodStateReached();
		}
		else if(currentState.equals(State.State_7)) {
			return goodStateReached();
		}
		else if(currentState.equals(State.State_10)) {
			return goodStateReached();
		}
		else if(currentState.equals(State.State_13)) {
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
		Collections.addAll(signals, signal_sequence.split(", "));

		boolean[] letters = new boolean[8];
		System.out.println(getMessagePrefix() + "Current state is: " + currentState);

		java.util.List<String> signals_used = new java.util.ArrayList<>();
		if(signals.contains("changeto(junction.distance.meter, 100)")) {
			letters[0] = true;
			signals_used.add("changeto(junction.distance.meter, 100)");
		}
		if(signals.contains("lamp.updatestatus(yellow).controller")) {
			letters[1] = true;
			signals_used.add("lamp.updatestatus(yellow).controller");
		}
		if(signals.contains("changeto(junction.car.speed, 50)")) {
			letters[2] = true;
			signals_used.add("changeto(junction.car.speed, 50)");
		}
		if(signals.contains("appear(junction.trafficlamp)")) {
			letters[3] = true;
			signals_used.add("appear(junction.trafficlamp)");
		}
		if(signals.contains("controller.turnyellow().lamp")) {
			letters[4] = true;
			signals_used.add("controller.turnyellow().lamp");
		}
		if(signals.contains("controller.turnoff().lamp")) {
			letters[5] = true;
			signals_used.add("controller.turnoff().lamp");
		}
		if(signals.contains("match(junction, redlight)")) {
			letters[6] = true;
			signals_used.add("match(junction, redlight)");
		}
		if(signals.contains("disappear(junction.car)")) {
			letters[7] = true;
			signals_used.add("disappear(junction.car)");
		}
		System.out.println(getMessagePrefix() + "Signal is: " + String.join(", ", signals_used));

		switch(currentState) {
			case State_0:
				if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				break;
			case State_1:
				if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_1;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_2;
				break;
			case State_2:
				if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				break;
			case State_3:
				if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				break;
			case State_5:
				if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				break;
			case State_6:
				if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				break;
			case State_8:
				if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_11;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_11;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_5;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_5;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_5;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_5;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_5;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_5;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_5;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_5;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_5;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_5;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_5;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_5;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_5;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_5;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_5;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_5;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_5;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_5;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_5;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_5;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_5;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_5;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_5;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_5;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_5;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_5;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_5;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_5;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_5;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_5;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_5;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_5;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				break;
			case State_9:
				if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				break;
			case State_11:
				if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_11;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_11;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_5;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_5;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_5;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_5;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_5;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_6;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_5;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_5;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_5;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_5;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_5;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_5;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_6;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_6;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_6;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_5;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_5;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_5;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_2;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_5;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_6;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_6;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_6;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_5;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_8;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_6;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_11;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				break;
			case State_12:
				if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_9;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_3;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_6;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_9;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_12;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					return goodStateReached();
				break;
			case State_14:
				if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (!(letters[7])))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (!(letters[7])))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (!(letters[6])) && (letters[7]))
					currentState = State.State_14;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (!(letters[5])) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (!(letters[4])) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (!(letters[3])) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (!(letters[2])) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (!(letters[1])) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((!(letters[0])) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				else if((letters[0]) && (letters[1]) && (letters[2]) && (letters[3]) && (letters[4]) && (letters[5]) && (letters[6]) && (letters[7]))
					currentState = State.State_0;
				break;
		}

		return 0;
	}
}