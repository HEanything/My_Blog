package com.example.myblog.DTO;

import java.sql.Timestamp;

public class UserEmailCode {

    private Long id;               // 主键ID
    private String userId;         // 用户ID
    private String email;          // 用户邮箱
    private String code;           // 验证码
    private Timestamp createTime;  // 验证码生成时间
    private Timestamp expireTime;  // 验证码过期时间

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Timestamp expireTime) {
        this.expireTime = expireTime;
    }
}
