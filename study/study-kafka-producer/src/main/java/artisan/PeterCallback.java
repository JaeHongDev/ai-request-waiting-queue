package artisan;


import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class PeterCallback implements Callback {


    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {

        if(recordMetadata == null){
            e.printStackTrace();
            return ;
        }

        System.out.println(">>>>>>>>>>>>>>>async partition: " + recordMetadata.partition() + "Offset: " + recordMetadata.offset());

    }
}
