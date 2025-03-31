package com.reringuy.kafkatest.controllers;

import com.reringuy.kafkatest.services.KafkaProducerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/notifications")
public class NotificationsController {
    @Autowired
    private KafkaProducerImpl kafkaService;

    @PostMapping
    public String sendNotification(@RequestParam("message") String message) {
        return kafkaService.create(message);
    }
}
