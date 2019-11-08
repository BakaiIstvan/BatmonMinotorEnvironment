public class LampController {
    Monitor junctionMonitor;
    Lamp lamp;

    public LampController(Lamp lamp, Monitor junctionMonitor) {
        this.junctionMonitor = junctionMonitor;
        this.lamp = lamp;
    }

    public void updateStatus() {}
}