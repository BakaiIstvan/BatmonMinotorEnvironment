public class Pieton {
	private float speed;
	private int mass;
	private String color;
	private String location;
	private boolean exists;
	private EventCreator eventCreator;
	
	public Pieton() {
		speed = 0;
		mass = 0;
		color = "blue";
		location = "default";
		exists = false;
	}
	
	public Pieton(EventCreator eventCreator) {
		speed = 0;
		mass = 0;
		color = "blue";
		location = "default";
		exists = false;
		this.eventCreator = eventCreator;
	}
		
	public boolean getExists() { return exists; }
	
	public void setAppear() { 
		exists = true;
		eventCreator.appear("Pieton");
	}
	
	public void setDisappear() { 
		exists = false;
		eventCreator.disappear("Pieton");
	}
	
	public float getSpeed() { return speed; }
							
	public void setSpeed(float speed) { 
		this.speed = speed;
		eventCreator.changeTo("Pieton.speed, " + speed);
	}
	public int getMass() { return mass; }
	
	public void setMass(int mass) { 
		this.mass = mass;
		eventCreator.changeTo("Pieton.mass, " + mass);
	}
	public String getColor() { return color; }
							
	public void setColor(String color) { 
		this.color = color;
		eventCreator.changeTo("Pieton.color, " + color);
	}
	public String getLocation() { return location; }
							
	public void setLocation(String location) { 
		this.location = location;
		eventCreator.changeTo("Pieton.location, " + location);
	}
}
