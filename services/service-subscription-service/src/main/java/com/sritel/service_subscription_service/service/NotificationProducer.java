package com.sritel.service_subscription_service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sritel.service_subscription_service.model.SubscriptionNotification;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {

//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//
//    @Autowired
//    private ObjectMapper objectMapper; // For converting to JSON
//
//    public void sendSubscriptionNotification(String email, String message) {
//        SubscriptionNotification notification = new SubscriptionNotification(email, message);
//        try {
//            String notificationJson = objectMapper.writeValueAsString(notification);
//            kafkaTemplate.send("service-subscription", email, notificationJson); // Keying by userId
//        } catch (JsonProcessingException e) {
//            e.printStackTrace(); // Handle exception
//        }
//    }

}

