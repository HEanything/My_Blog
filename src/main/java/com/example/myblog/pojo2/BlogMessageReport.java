package com.example.myblog.pojo2;

public class BlogMessageReport {

    private Long messageReportId; // 举报信息ID
    private Long messageId; // 举报留言ID
    private String messageDescription; // 举报描述

    // Getters and Setters
    public Long getMessageReportId() {
        return messageReportId;
    }

    public void setMessageReportId(Long messageReportId) {
        this.messageReportId = messageReportId;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getMessageDescription() {
        return messageDescription;
    }

    public void setMessageDescription(String messageDescription) {
        this.messageDescription = messageDescription;
    }
}

