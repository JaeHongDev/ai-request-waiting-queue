package artisan;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        var props = new Properties();

        props.put("bootstrap.servers", "192.168.129.119:9092,192.168.129.119:9093,192.168.129.119:9094");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");


        // 동기식 호출
        synchronousCall(props);
        asyncCall(props);


    }

    private static void synchronousCall(Properties props){
        try(Producer<String, String> producer = new KafkaProducer<>(props)){
            RecordMetadata metadata = producer.send(
                    new ProducerRecord<>("peter-topic", "syncMessage: Apache kafka is a distributed streaming platform")
            ).get();

            System.out.printf("partition: %d, offser: %d \n", metadata.partition(), metadata.offset());
        }catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static void asyncCall(Properties props){
        try(Producer<String, String> producer = new KafkaProducer<>(props)){
            producer.send(
                    new ProducerRecord<>("peter-topic", "asyncMessage:Apache kafka is a distributed streaming platform"),
                    new PeterCallback()
            );
        }catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}