package com.genius.springProducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    public NewTopic geniusCodeTopic() {
        return TopicBuilder.name("geniusCode").build();
    }
}
