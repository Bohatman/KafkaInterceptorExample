import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {
    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
//        props.put(
//                ProducerConfig.INTERCEPTOR_CLASSES_CONFIG,
//                "io.confluent.monitoring.clients.interceptor.MonitoringProducerInterceptor");
        KafkaProducer<String, String> producer = new KafkaProducer(props);
        long count = 0;
        try {
            while (true){
                Thread.sleep(1000);
                producer.send(new ProducerRecord<>("TOPIC_SINGLE_NODE","","" + count));
                count++;
            }
        }finally {
            producer.close();
        }
    }
}
