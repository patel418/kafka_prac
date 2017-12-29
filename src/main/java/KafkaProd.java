import org.apache.kafka.common.serialization.StringSerializer;

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

        //possibly look at batch number... otherwise everything else should be default

        Producer<String, String> producer = new org.apache.kafka.clients.producer.

    }
}