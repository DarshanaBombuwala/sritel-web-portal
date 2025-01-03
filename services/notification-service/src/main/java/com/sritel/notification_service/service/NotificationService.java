package com.sritel.notification_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {


    private JavaMailSender mailSender;

    // Inject Twilio, Firebase, etc. if required

    public void processNotification(String email, String notificationMessage) {
        // Parse message and determine type of notification (email, SMS, push)
        // Example: Send email notification
        sendEmailNotification(email, "Notification", notificationMessage);
    }

    private void sendEmailNotification(String to, String subject, String body) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(body);
        mailSender.send(mailMessage);
    }
}
