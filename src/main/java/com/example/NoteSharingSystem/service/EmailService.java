package com.example.NoteSharingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // Method to send OTP email including the unique access link
    public void sendOtpEmail(String recipientEmail, String otp, String accessLink) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo(recipientEmail);
        helper.setSubject("Your OTP for Note Access");

        // Create the email body with the OTP and access link
        String emailBody = String.format("Your OTP is: %s\nAccess your note using the following link: %s", otp, accessLink);
        helper.setText(emailBody);

        // Send the email
        mailSender.send(message);
    }
}
