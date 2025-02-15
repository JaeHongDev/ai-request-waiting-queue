package artisan;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Main2 {

    public static void main(String...args){
        var props = new Properties();

        props.put("bootstrap.servers", "192.168.129.119:9092,192.168.129.119:9093,192.168.129.119:9094");
        props.put("acks", "1");
        props.put("compression.type", "gzip");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        try(Producer<String, String> producer = new KafkaProducer<>(props)) {

            for (int i = 1; i < 11; i++) {
                producer.send(new ProducerRecord<>(
                        "peter-topic",
                        i + "request")
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
