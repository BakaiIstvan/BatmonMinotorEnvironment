public class Distance {
	private Car sender;
	private TrafficLamp receiver;
	private EventCreator eventCreator;
	private int meter;
	
	public Distance(Car sender, TrafficLamp receiver) {
		this.sender = sender;
		this.receiver = receiver;
		meter = 0;
	}
	
	public Distance(Car sender, TrafficLamp receiver, EventCreator eventCreator) {
		this.sender = sender;
		this.receiver = receiver;
		this.eventCreator = eventCreator;
		meter = 0;
	}
		
	public int getMeter() { return meter; }
	
	public void setMeter(int meter) { 
		this.meter = meter;
		eventCreator.changeTo("Distance.meter(" + meter +")");
	}
	
	public Car getSender() { return sender; }
	
	public TrafficLamp getReceiver() { return receiver; }
}
