package com.project.womensafety.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendSosEmail(String toEmail, double latitude, double longitude) {
        String locationLink = "https://www.google.com/maps?q=" + latitude + "," + longitude;
        String message = "🚨 SOS Alert! \nPlease help. My location: " + locationLink;

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toEmail);
        mailMessage.setSubject("🚨 SOS Alert!");
        mailMessage.setText(message);

        mailSender.send(mailMessage);
    }
}
