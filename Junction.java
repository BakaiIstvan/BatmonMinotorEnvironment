public class Junction {
	private TrafficLamp trafficLamp;
	private Car car;
	private Pieton pieton;
	private Bycicle bycicle;
	private Distance distance;
	private RightOfWay rightOfWay;
	
	public Junction() {
		trafficLamp = new TrafficLamp();
		car = new Car();
		pieton = new Pieton();
		bycicle = new Bycicle();
		distance = new Distance(car, trafficLamp);
		rightOfWay = new RightOfWay(car, bycicle);
	}
	
	public Junction(EventCreator eventCreator) {
		trafficLamp = new TrafficLamp(eventCreator);
		car = new Car(eventCreator);
		pieton = new Pieton(eventCreator);
		bycicle = new Bycicle(eventCreator);
		distance = new Distance(car, trafficLamp, eventCreator);
		rightOfWay = new RightOfWay(car, bycicle, eventCreator);
	}
	
	public TrafficLamp getTrafficLamp() {
		return trafficLamp;
	}
	public Car getCar() {
		return car;
	}
	public Pieton getPieton() {
		return pieton;
	}
	public Bycicle getBycicle() {
		return bycicle;
	}
	public Distance getDistance() {
		return distance;
	}
	public RightOfWay getRightOfWay() {
		return rightOfWay;
	}
}
