public class Main {
    static Junction junction;
    static Redlight redlight;
    static EventCreator eventCreator;
    static Lamp lamp;
    static LampController controller;

    public static void main(String[] args) {
        JunctionMonitor junctionMonitor = new JunctionMonitor();
        redlight = new Redlight();
        junction = new Junction(eventCreator);
        eventCreator = new EventCreator(junction, redlight, junctionMonitor);
        lamp = new Lamp(controller, junctionMonitor);
        controller = new LampController(lamp, junctionMonitor);

        junction.getTrafficLamp().setAppear();

        junction.getCar().setAppear();
        junction.getCar().setSpeed(51);
        junction.getCar().setColor("red");

        junction.getBycicle().setAppear();
        junction.getBycicle().setLocation("in_front_of_the_car");

        junction.getDistance().setMeter(13);

        junction.getRightOfWay().setRightofway("bycicle");

        controller.lamp.turnYellow();
        junctionMonitor.update("controller.turnYellow().lamp");
        lamp.controller.updateStatus();
        junctionMonitor.update("lamp.updateStatus().controller");
    }
}