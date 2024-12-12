package com.example.myblog.service;

import com.example.myblog.DTO.UserEmailCode;
import jakarta.mail.MessagingException;

public interface EmailService {

    void sendEmailWithCode(String email, String code)throws MessagingException;


    ////////找到code
    UserEmailCode findByUserIdAndEmail(String userId, String email);

    void saveOrUpdateVerificationCode(String userId, String email, String code);
}
