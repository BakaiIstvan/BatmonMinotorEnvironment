public class Main {
    static Junction junction;
    static Greenlight greenlight;
    static EventCreator eventCreator;
    static Lamp lamp;
    static LampController controller;

    public static void main(String args[]) {
    	JunctionMonitor junctionMonitor = new JunctionMonitor();
        greenlight = new Greenlight();
        eventCreator = new EventCreator(junction, greenlight, junctionMonitor);
        junction = new Junction(eventCreator);
        eventCreator.setJunction(junction);
        lamp = new Lamp(controller, junctionMonitor);
        controller = new LampController(lamp, junctionMonitor);
        lamp.setController(controller);

        junction.getTrafficLamp().setAppear();

        junction.getCar().setAppear();
        junction.getCar().setSpeed(51);
        junction.getCar().setColor("red");

        junction.getPedestrian().setAppear();
        junction.getPedestrian().setLocation("at_the_junction");

        junction.getDistance().setMeter(13);
        
        controller.lamp.turnYellow();
        junctionMonitor.update("controller.turnYellow().lamp");
        lamp.controller.updateStatus();
        junctionMonitor.update("lamp.updateStatus().controller");
        junction.getCar().setSpeed(20);
        junction.getDistance().setMeter(6);
        controller.lamp.turnRed();
        junctionMonitor.update("controller.turnRed().lamp");
        lamp.controller.updateStatus();
        junctionMonitor.update("lamp.updateStatus().controller");
        junction.getPedestrian().setDisappear();
        junction.getCar().setSpeed(0);
    }
}