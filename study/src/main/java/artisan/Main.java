package artisan;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws IOException, TimeoutException {
        var factory = new ConnectionFactory();
        factory.setHost("192.168.129.119");
        var connection = factory.newConnection();
            var channel = connection.createChannel();

            channel.queueDeclare("sample", false, false, false, null);
            channel.queueDeclare("sample", false, false, false, null);
            channel.basicPublish("", "sample", null, "publish".getBytes());
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + message + "'");
            };
            channel.basicConsume("sample", true, deliverCallback, consumerTag -> {
            });
    }
}