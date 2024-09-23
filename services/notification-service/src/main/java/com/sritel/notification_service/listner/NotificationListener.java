package com.sritel.notification_service.listner;

import com.sritel.notification_service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationListener {

    private final NotificationService notificationService;


    @KafkaListener(topics = "notification-topic", groupId = "notification-group")
    public void consumeMessage(String message) {
        // Process message and trigger notification
        notificationService.processNotification(message);
    }
}

