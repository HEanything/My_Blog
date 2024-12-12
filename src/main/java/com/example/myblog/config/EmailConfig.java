package com.example.myblog.config;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.163.com");
        mailSender.setPort(465);
        mailSender.setUsername("heanything@163.com");
        mailSender.setPassword("WCNzAQjnFuY4abhP");

        // 配置TLS（传输加密）和SSL
        mailSender.getJavaMailProperties().put("mail.smtp.starttls.enable", "true");
        mailSender.getJavaMailProperties().put("mail.smtp.auth", "true");
        mailSender.getJavaMailProperties().put("mail.smtp.ssl.trust", "smtp.163.com");
        mailSender.getJavaMailProperties().put("mail.smtp.ssl.enable", "true");

        return mailSender;
    }
}

