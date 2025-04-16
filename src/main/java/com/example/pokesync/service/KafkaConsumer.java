package com.example.pokesync.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "pokesync-test", groupId = "pokesync-group")
    public void listen(String message) {
        log.info("📩 Mensaje recibido en Kafka: {}", message);
    }
}

