public class RightOfWay {
	private Car sender;
	private Bycicle receiver;
	private EventCreator eventCreator;
	private String rightofway;
	
	public RightOfWay(Car sender, Bycicle receiver) {
		this.sender = sender;
		this.receiver = receiver;
		rightofway = "bycicle";
	}
	
	public RightOfWay(Car sender, Bycicle receiver, EventCreator eventCreator) {
		this.sender = sender;
		this.receiver = receiver;
		this.eventCreator = eventCreator;
		rightofway = "bycicle";
	}
		
	public String getRightofway() { return rightofway; }
							
	public void setRightofway(String rightofway) { 
		this.rightofway = rightofway;
		eventCreator.changeTo("RightOfWay.rightofway, " + rightofway);
	}
	
	public Car getSender() { return sender; }
	
	public Bycicle getReceiver() { return receiver; }
}
