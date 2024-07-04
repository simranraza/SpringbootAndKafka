package com.genius.springConsumer;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@EnableKafka
public class KafkaMessageListener {

        @KafkaListener(topics="geniusCode", groupId = "groupId")
        public void kafkaListener(String message) {
            System.out.println("Message Received: " + message);

        }
}
