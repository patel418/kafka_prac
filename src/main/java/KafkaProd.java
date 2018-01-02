import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;

public class KafkaProd {
    public static void main(String[] args)
    {
        Properties properties = new Properties();

        //kafka bootstrap server
        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());

        //producer acks
        properties.setProperty("acks", "1"); //1 for just the leader
        properties.setProperty("retries", "3"); //3 retires till failure
        properties.setProperty("linger.ms", "1"); //every 1 millisecond it will makesure to send message. kind of like flush()

        //possibly look at batch number... otherwise everything else should be default

        Producer <String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(properties); //the object that sends the producer records
        int i = 0;
        while(i < 20) {
            String message = "message" + i;
            ProducerRecord<String, String> producerR = new ProducerRecord<String, String>("topic1", "3", message); //this is actually what is being sent. the topic
            //producer record is (topic, key, value); If key is the same, it will go to the same partition.

            producer.send(producerR);
        }
        producer.close(); //need to close connection

    }
}
