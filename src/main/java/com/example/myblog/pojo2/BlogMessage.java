package com.example.myblog.pojo2;

public class BlogMessage {

    private Long messageId; // 留言ID
    private String userId; // 发表用户ID
    private Long messageLikeCount; // 点赞/踩数量
    private String messageDate; // 留言日期
    private String messageContent; // 留言内容
    private Long parentMessageId; // 父留言ID
    private Boolean messageIsPinned; // 留言是否置顶

    // Getters and Setters
    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getMessageLikeCount() {
        return messageLikeCount;
    }

    public void setMessageLikeCount(Long messageLikeCount) {
        this.messageLikeCount = messageLikeCount;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Long getParentMessageId() {
        return parentMessageId;
    }

    public void setParentMessageId(Long parentMessageId) {
        this.parentMessageId = parentMessageId;
    }

    public Boolean getMessageIsPinned() {
        return messageIsPinned;
    }

    public void setMessageIsPinned(Boolean messageIsPinned) {
        this.messageIsPinned = messageIsPinned;
    }
}

