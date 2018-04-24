package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailTriggerController {
    
    @Autowired
    MailSender mailSender;

    @RequestMapping(path = "/email/trigger", method = RequestMethod.GET)
    public String triggerEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText("Hello from Prasad");
        message.setTo("prasad.suseela@smtptest.com");
        message.setFrom("prasad.suseela@smtptest.com");
        try {
            mailSender.send(message);
            return "{\"message\": \"OK\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"message\": \"Error\"}";
        }
    }

}
