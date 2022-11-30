package com.startech.wikimedia;

import com.startech.wikimedia.producer.WikimediaKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerWikimediaApplication implements CommandLineRunner {

    @Autowired
    private WikimediaKafkaProducer wikimediaKafkaProducer;

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerWikimediaApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        wikimediaKafkaProducer.sendMessage();
    }
}
