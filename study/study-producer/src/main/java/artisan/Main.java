package artisan;

import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("192.168.129.119");

        try(var connection = connectionFactory.newConnection()) {
            var channel = connection.createChannel();

            channel.queueDeclare("sample", false, false, false,null);

            channel.basicPublish("", "sample", null , "hello".getBytes(StandardCharsets.UTF_8));
            channel.basicPublish("", "sample", null , "hello".getBytes(StandardCharsets.UTF_8));
            channel.basicPublish("", "sample", null , "hello".getBytes(StandardCharsets.UTF_8));
            channel.basicPublish("", "sample", null , "hello".getBytes(StandardCharsets.UTF_8));
            channel.basicPublish("", "sample", null , "hello".getBytes(StandardCharsets.UTF_8));
            System.out.println("[x] sent hello ");

        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}