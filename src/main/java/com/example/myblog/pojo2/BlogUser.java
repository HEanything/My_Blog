package com.example.myblog.pojo2;
public class BlogUser {

    private String userId; // 用户ID
    private String userPassword; // 用户密码
    private String userEmail; // 用户邮箱
    private String userProfilePhoto; // 用户头像
    private String userRegistrationTime; // 注册时间
    private String userBirthday; // 用户生日
    private Integer userAge; // 用户年龄
    private Integer userTelephoneNumber; // 用户手机号
    private String userSex; // 用户性别
    private String userDescription; // 用户简介
    private Boolean userAllowArticle; // 是否允许发布文章
    private Boolean userIsBanned; // 是否被封禁

    // Getters and Setters
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserProfilePhoto() {
        return userProfilePhoto;
    }
    public void setUserProfilePhoto(String userProfilePhoto) {
        this.userProfilePhoto = userProfilePhoto;
    }
    public String getUserRegistrationTime() {
        return userRegistrationTime;
    }
    public void setUserRegistrationTime(String userRegistrationTime) {
        this.userRegistrationTime = userRegistrationTime;
    }
    public String getUserBirthday() {
        return userBirthday;
    }
    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }
    public Integer getUserAge() {
        return userAge;
    }
    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
    public Integer getUserTelephoneNumber() {
        return userTelephoneNumber;
    }
    public void setUserTelephoneNumber(Integer userTelephoneNumber) {
        this.userTelephoneNumber = userTelephoneNumber;
    }
    public String getUserSex() {
        return userSex;
    }
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }
    public String getUserDescription() {
        return userDescription;
    }
    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }
    public Boolean getUserAllowArticle() {
        return userAllowArticle;
    }
    public void setUserAllowArticle(Boolean userAllowArticle) {
        this.userAllowArticle = userAllowArticle;
    }
    public Boolean getUserIsBanned() {
        return userIsBanned;
    }
    public void setUserIsBanned(Boolean userIsBanned) {
        this.userIsBanned = userIsBanned;
    }
}
