import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class KafkaCon {
    public static void main(String[] args)
    {
        Properties properties = new Properties();

        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
        properties.setProperty("key.deserializer", StringDeserializer.class.getName());
        properties.setProperty("value.deserializer", StringDeserializer.class.getName());

        properties.setProperty("group.id", "test");
        properties.setProperty("enable.auto.commit", "true");
        properties.setProperty("auto.commit.interval.ms", "1000");
        properties.setProperty("auto.offset.reset", "earliest");

        KafkaConsumer<String, String> kafkaCons = new KafkaConsumer<String, String>(properties);
        kafkaCons.subscribe(Arrays.asList("topic1"));

        while(true)
        {
            ConsumerRecords<String,String> consumerRecords = kafkaCons.poll(100);
            for (ConsumerRecord<String,String> cRecord : consumerRecords)
            {
                cRecord.value();
                cRecord.key();
                cRecord.offset();
                cRecord.partition();
                cRecord.timestamp();
                cRecord.topic();

                System.out.println("Partition: " + cRecord.partition()+
                ", Offset " + cRecord.offset()+
                ", Key: " + cRecord.key()+
                ", Value: " + cRecord.value());


            }
        }


    }
}
