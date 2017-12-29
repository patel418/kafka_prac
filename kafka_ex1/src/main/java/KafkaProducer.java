public class KafkaProducer {
    public static void main(String[] args)
    {
        Properties properties = new Properties();

        //need kafka bootstrap server
        //produer acks
        //topic name

        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
        properties.setProperty("key.serializer", "");
        properties.setProperty("value.serializer", "");
        properties.setProperty("acks", "1"); //acknowledgement of the leader
        properties.setProperty("retries", "3");

        //find these all in documentation in producer config


    }
}
