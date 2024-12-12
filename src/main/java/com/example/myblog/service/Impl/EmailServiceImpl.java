package com.example.myblog.service.Impl;

import com.example.myblog.DTO.UserEmailCode;
import com.example.myblog.mapper.UserEmailCodeMapper;
import com.example.myblog.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private UserEmailCodeMapper userEmailCodeMapper;

    @Autowired
    private JavaMailSender mailSender;  // 用于发送邮件的服务

    // 发送验证码到用户邮箱
    public void sendEmailWithCode(String email, String code) throws MessagingException {
        // 创建邮件信息
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("heanything@163.com");
        message.setTo(email);
        message.setSubject("找回密码验证码");
        message.setText("您的验证码是: " + code + "，请在10分钟内使用。");

        // 发送邮件
        mailSender.send(message);
    }

    // 保存验证码到数据库
    public void saveVerificationCode(String userId, String email, String code) {
        LocalDateTime expireTime = LocalDateTime.now().plusMinutes(10); // 验证码有效期10分钟
        UserEmailCode userEmailCode = new UserEmailCode();
        userEmailCode.setUserId(userId);
        userEmailCode.setEmail(email);
        userEmailCode.setCode(code);
        userEmailCode.setExpireTime(Timestamp.valueOf(expireTime));

        userEmailCodeMapper.save(userEmailCode);
    }

    // 根据用户ID和邮箱查找验证码
    public UserEmailCode findByUserIdAndEmail(String userId, String email) {
        return userEmailCodeMapper.findByUserIdAndEmail(userId, email);
    }

    @Override
    // 保存验证码到数据库，如果验证码已经存在，则更新
    public void saveOrUpdateVerificationCode(String userId, String email, String code) {
        LocalDateTime expireTime = LocalDateTime.now().plusMinutes(10); // 验证码有效期10分钟
        UserEmailCode userEmailCode = new UserEmailCode();
        userEmailCode.setUserId(userId);
        userEmailCode.setEmail(email);
        userEmailCode.setCode(code);
        userEmailCode.setExpireTime(Timestamp.valueOf(expireTime));

        // 判断是否存在相同的验证码记录
        UserEmailCode existingCode = userEmailCodeMapper.findByUserIdAndEmail(userId, email);
        if (existingCode == null) {
            userEmailCodeMapper.save(userEmailCode); // 如果不存在，则插入新记录
        } else {
            userEmailCodeMapper.update(userEmailCode); // 如果已经存在，则更新
        }
    }
}
