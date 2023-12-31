package com.michwierzch.ChatterBox.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender {
    private final static Logger logger = LoggerFactory.getLogger(EmailService.class);
    private final JavaMailSender javaMailSender;
    @Override
    @Async
    public void send(String to, String email){
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
            mimeMessageHelper.setText(email, true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject("Confirm your email");
            mimeMessageHelper.setFrom("hello@chatterbox.com");
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e ){
            logger.error("Email can't be sent!", e);
            throw new IllegalStateException("Email can't be sent");
        }
    }
}
