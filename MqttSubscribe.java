import com.google.protobuf.InvalidProtocolBufferException;
import hu.bme.mit.inf.modes3.messaging.proto.messages.SegmentState;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttSubscribe implements MqttCallback {
    private Modes3_MonitorManager monitormanager = new Modes3_MonitorManager();

    public static void main(String[] args) {
        String topic = "/modes3/segment/status/7";
        int qos = 2;
        String broker = "tcp://root.modes3.intra:1883";
        String clientId = "MonitorManager";
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            MqttAsyncClient sampleClient = new MqttAsyncClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            sampleClient.setCallback(new MqttSubscribe());
            System.out.println("Connecting to broker: " + broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            Thread.sleep(1000);
            sampleClient.subscribe(topic, qos);
            System.out.println("Subscribed");
        }
        catch (Exception me) {
            if (me instanceof MqttException) {
                System.out.println("reason " + ((MqttException) me).getReasonCode());
            }
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }

    public void connectionLost(Throwable arg0) {
        System.err.println("\nconnection lost: " + arg0.getMessage());
    }

    public void deliveryComplete(IMqttDeliveryToken arg0) {
        System.err.println("delivery complete");
    }

    public void messageArrived(String topic, MqttMessage mqttMessage) {
        try {
            System.out.println("(topic: " + topic + ")");

            SegmentState segmentState = SegmentState.parseFrom(mqttMessage.getPayload());
            boolean isEnabled = segmentState.getUnknownFields().toString().contains("2: 1");

            if(isEnabled)
                monitormanager.update("segment.enabled().controller");
            else
                monitormanager.update("disabled");
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}
