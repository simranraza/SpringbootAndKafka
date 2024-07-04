package com.genius.springProducer;

import com.genius.springConsumer.KafkaMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication(scanBasePackages = { "com.genius" })
public class SpringKafkaProducerApplication {

	@Autowired
	KafkaMessageListener kafkaMessageListener;

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaProducerApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate, KafkaMessageListener kafkaMessageListener) {
		return args -> {
			System.out.println("input: " +  args[0]);
			for(int i=0;i<10;i++) {
				kafkaTemplate.send("geniusCode", "Test message " + Math.random());
			}
		};
	}
}
