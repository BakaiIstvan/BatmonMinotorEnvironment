public class EventCreator {
	private Junction junction;
	private Greenlight greenlight;
	private Monitor monitorInterface;
	
	public EventCreator(
		Junction junction,
		Greenlight greenlight,
		Monitor monitorInterface
	) {
		this.junction = junction;
		this.greenlight = greenlight;
		this.monitorInterface = monitorInterface;
	}
	
	public void setJunction(Junction junction) {
		this.junction = junction;
	}
	
	public void appear(String name) {
		monitorInterface.update("appear(Junction." + name + ")");
		if (greenlight.match(
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
			monitorInterface.update("match(Junction, Greenlight)");
		}
	}
	
	public void disappear(String name) {
		monitorInterface.update("disappear(Junction." + name + ")"); 
		if (greenlight.match(
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
			monitorInterface.update("match(Junction, Greenlight)");
		}
	}
	
	public void changeTo(String event) {
		monitorInterface.update("changeTo(Junction." + event + ")"); 
		if (greenlight.match(
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
			monitorInterface.update("match(Junction, Greenlight)");
		}
	}
}
