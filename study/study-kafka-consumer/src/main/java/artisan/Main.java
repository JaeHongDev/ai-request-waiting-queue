package artisan;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Main {
    public static void main(String[] args) {

        var props = new Properties();
        props.put("bootstrap.servers", "192.168.129.119:9092,192.168.129.119:9093,192.168.129.119:9094");
        props.put("group.id", "peter-consumer");
        props.put("enable.autpo.commit", "true");
        props.put("auto.offset.reset" , "latest");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(List.of("peter-topic"));

        try {
            while(true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for(var record: records) {
                    var message = String.format(
                            "Topic %s, Partition: %s, Offset: %d, Key: %s, value: %s",
                            record.topic(),
                            record.partition(),
                            record.offset(),
                            record.key(),
                            record.value()
                    );

                    System.out.println(message);
                }
            }
        }finally {
            consumer.close();
        }

    }
}