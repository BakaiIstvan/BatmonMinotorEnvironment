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
        
        controller.lamp.turnRed();
        junctionMonitor.update("controller.turnRed().lamp");
        lamp.controller.updateStatus();
        junctionMonitor.update("lamp.updateStatus().controller");
        junction.getCar().setSpeed(50);
        junction.getDistance().setMeter(100);
    }
}