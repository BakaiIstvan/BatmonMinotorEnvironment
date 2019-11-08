public class Bycicle {
	private float speed;
	private String color;
	private String location;
	private boolean exists;
	private EventCreator eventCreator;
	
	public Bycicle() {
		speed = 0;
		color = "yellow";
		location = "default";
		exists = false;
	}
	
	public Bycicle(EventCreator eventCreator) {
		speed = 0;
		color = "yellow";
		location = "default";
		exists = false;
		this.eventCreator = eventCreator;
	}
		
	public boolean getExists() { return exists; }
	
	public void setAppear() { 
		exists = true;
		eventCreator.appear("Bycicle");
	}
	
	public void setDisappear() { 
		exists = false;
		eventCreator.disappear("Bycicle");
	}
	
	public float getSpeed() { return speed; }
							
	public void setSpeed(float speed) { 
		this.speed = speed;
		eventCreator.changeTo("Bycicle.speed(" + speed +")");
	}
	public String getColor() { return color; }
							
	public void setColor(String color) { 
		this.color = color;
		eventCreator.changeTo("Bycicle.color(" + color +")");
	}
	public String getLocation() { return location; }
							
	public void setLocation(String location) { 
		this.location = location;
		eventCreator.changeTo("Bycicle.location(" + location +")");
	}
}
