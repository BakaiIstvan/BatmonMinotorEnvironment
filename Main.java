public class Main {
    static Junction junction;
    static Redlight redlight;
    static EventCreator eventCreator;
    static Lamp lamp;
    static LampController controller;

    public static void main(String args[]) {
    	JunctionMonitor junctionMonitor = new JunctionMonitor();
        redlight = new Redlight();
        eventCreator = new EventCreator(junction, redlight, junctionMonitor);
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