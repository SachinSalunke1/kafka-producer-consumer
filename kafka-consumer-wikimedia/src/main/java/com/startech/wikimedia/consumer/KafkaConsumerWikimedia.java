package com.startech.wikimedia.consumer;

import com.startech.wikimedia.entity.WikimediaData;
import com.startech.wikimedia.repository.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerWikimedia {

    private WikimediaRepository wikimediaRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerWikimedia.class);

    public KafkaConsumerWikimedia(WikimediaRepository wikimediaRepository) {
        this.wikimediaRepository = wikimediaRepository;
    }

    @KafkaListener(topics = "wikimedia_recentchange",groupId = "myGroup")
    public void consume(String eventMessage){
        LOGGER.info(String.format("Event message recieved -> %s ",eventMessage));

        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setEventData(eventMessage);

        wikimediaRepository.save(wikimediaData);
    }
}
