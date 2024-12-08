package com.example.myblog.pojo2;

public class BlogAdmin {

    private Long adminId; // 管理员编号
    private String userId; // 管理员对应用户ID

    // Getters and Setters
    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
