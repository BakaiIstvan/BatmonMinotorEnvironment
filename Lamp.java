public class Lamp {
    Monitor junctionMonitor;
    LampController controller;

    public Lamp(LampController controller, Monitor junctionMonitor) {
        this.controller = controller;
        this.junctionMonitor = junctionMonitor;
    }

    public void turnYellow() {}
    public void turnOff() {}
}