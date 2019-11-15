public class Car {
	private float speed;
	private String color;
	private boolean exists;
	private EventCreator eventCreator;
	
	public Car() {
		speed = 0;
		color = "default";
		exists = false;
	}
	
	public Car(EventCreator eventCreator) {
		speed = 0;
		color = "default";
		exists = false;
		this.eventCreator = eventCreator;
	}
		
	public boolean getExists() { return exists; }
	
	public void setAppear() { 
		exists = true;
		eventCreator.appear("Car");
	}
	
	public void setDisappear() { 
		exists = false;
		eventCreator.disappear("Car");
	}
	
	public float getSpeed() { return speed; }
							
	public void setSpeed(float speed) { 
		this.speed = speed;
		eventCreator.changeTo("Car.speed, " + speed);
	}
	public String getColor() { return color; }
							
	public void setColor(String color) { 
		this.color = color;
		eventCreator.changeTo("Car.color, " + color);
	}
}
