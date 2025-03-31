package com.reringuy.kafkatest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerImpl {
    @Value("${kafka.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public String create(String message) {
        try {
            return sendNotification(message);
        } catch (Exception e) {
            return "Ocorreu um erro" + e.getMessage();
        }
    }

    private String sendNotification(String message) {
        kafkaTemplate.send(topic, message);
        return "OK";
    }
}
