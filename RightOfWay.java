public class RightOfWay {
	private Car sender;
	private Pedestrian receiver;
	private EventCreator eventCreator;
	private String rightofway;
	
	public RightOfWay(Car sender, Pedestrian receiver) {
		this.sender = sender;
		this.receiver = receiver;
		rightofway = "pedestrian";
	}
	
	public RightOfWay(Car sender, Pedestrian receiver, EventCreator eventCreator) {
		this.sender = sender;
		this.receiver = receiver;
		this.eventCreator = eventCreator;
		rightofway = "pedestrian";
	}
		
	public String getRightofway() { return rightofway; }
							
	public void setRightofway(String rightofway) { 
		this.rightofway = rightofway;
		eventCreator.changeTo("RightOfWay.rightofway, " + rightofway);
	}
	
	public Car getSender() { return sender; }
	
	public Pedestrian getReceiver() { return receiver; }
}
