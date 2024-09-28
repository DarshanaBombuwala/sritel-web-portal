package com.sritel.notification_service.listner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sritel.notification_service.model.SubscriptionNotification;
import com.sritel.notification_service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationListener {

    private final NotificationService notificationService;

    @Autowired
    private ObjectMapper objectMapper;


    @KafkaListener(topics = "service-subscription", groupId = "notification-group")
    public void consumeMessage(String message) throws JsonProcessingException {
        SubscriptionNotification notification = objectMapper.readValue(message, SubscriptionNotification.class);
        // Process message and trigger notification
        notificationService.processNotification(notification.getEmail(),notification.getMessage());
    }
}

