public class TrafficLamp {
	private String status;
	private boolean exists;
	private EventCreator eventCreator;
	
	public TrafficLamp() {
		status = "default";
		exists = false;
	}
	
	public TrafficLamp(EventCreator eventCreator) {
		status = "default";
		exists = false;
		this.eventCreator = eventCreator;
	}
		
	public boolean getExists() { return exists; }
	
	public void setAppear() { 
		exists = true;
		eventCreator.appear("TrafficLamp");
	}
	
	public void setDisappear() { 
		exists = false;
		eventCreator.disappear("TrafficLamp");
	}
	
	public String getStatus() { return status; }
							
	public void setStatus(String status) { 
		this.status = status;
		eventCreator.changeTo("TrafficLamp.status(" + status +")");
	}
}
