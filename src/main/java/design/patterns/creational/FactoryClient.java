package design.patterns.creational;

interface Publisher {
    void publish();
}

class SNSFactory implements Publisher {
    public void publish() {
        System.out.println("publishing message via SNS");
    }
}

class KafkaFactory implements Publisher {
    public void publish() {
        System.out.println("publishing message via Kafka");
    }
}

class PublisherFactory {
    public static Publisher getPublisher(String publisherName) throws Exception {
        switch (publisherName) {
            case "KAFKA":
                return new KafkaFactory();
            case "SNS":
                return new SNSFactory();
            default:
                throw new Exception("No default publisher available.");
        }
    }
}

public class FactoryClient {
    public static void main(String[] args) throws Exception {
        Publisher kafkaPublisher = PublisherFactory.getPublisher("KAFKA");
        Publisher snsPublisher = PublisherFactory.getPublisher("SNS");
    }
}