public class Junction {
	private TrafficLamp trafficLamp;
	private Car car;
	private Pedestrian pedestrian;
	private Bycicle bycicle;
	private Distance distance;
	private RightOfWay rightOfWay;
	
	public Junction() {
		trafficLamp = new TrafficLamp();
		car = new Car();
		pedestrian = new Pedestrian();
		bycicle = new Bycicle();
		distance = new Distance(car, trafficLamp);
		rightOfWay = new RightOfWay(car, pedestrian);
	}
	
	public Junction(EventCreator eventCreator) {
		trafficLamp = new TrafficLamp(eventCreator);
		car = new Car(eventCreator);
		pedestrian = new Pedestrian(eventCreator);
		bycicle = new Bycicle(eventCreator);
		distance = new Distance(car, trafficLamp, eventCreator);
		rightOfWay = new RightOfWay(car, pedestrian, eventCreator);
	}
	
	public TrafficLamp getTrafficLamp() {
		return trafficLamp;
	}
	public Car getCar() {
		return car;
	}
	public Pedestrian getPedestrian() {
		return pedestrian;
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
