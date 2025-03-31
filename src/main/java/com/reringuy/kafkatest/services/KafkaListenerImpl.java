package com.reringuy.kafkatest.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerImpl {
    @KafkaListener(topics = "${kafka.topic}", groupId = "notifications-group-1")
    public void receiveNotification(String message) {
        System.out.println("Received notification: " + message);
    }
}