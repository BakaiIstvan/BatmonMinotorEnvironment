public class EventCreator {
	private Junction junction;
	private Redlight redlight;
	private IMonitor monitorInterface;
	
	public EventCreator(
		Junction junction,
		Redlight redlight,
		IMonitor monitorInterface
	) {
		this.junction = junction;
		this.redlight = redlight;
		this.monitorInterface = monitorInterface;
	}
	
	public void appear(String name) {
		monitorInterface.update("appear(Junction." + name + ")");
		if (redlight.match(
			junction.getTrafficLamp()
			,
			junction.getCar()
			,
			junction.getBycicle()
			,
			junction.getDistance()
			,
			junction.getRightOfWay()
		)) {
			monitorInterface.update("match(Junction, Redlight)");
		}
	}
	
	public void disappear(String name) {
		monitorInterface.update("disappear(Junction." + name + ")"); 
		if (redlight.match(
			junction.getTrafficLamp()
			,
			junction.getCar()
			,
			junction.getBycicle()
			,
			junction.getDistance()
			,
			junction.getRightOfWay()
		)) {
			monitorInterface.update("match(Junction, Redlight)");
		}
	}
	
	public void changeTo(String event) {
		monitorInterface.update("changeTo(Junction." + event + ")"); 
		if (redlight.match(
			junction.getTrafficLamp()
			,
			junction.getCar()
			,
			junction.getBycicle()
			,
			junction.getDistance()
			,
			junction.getRightOfWay()
		)) {
			monitorInterface.update("match(Junction, Redlight)");
		}
	}
}
