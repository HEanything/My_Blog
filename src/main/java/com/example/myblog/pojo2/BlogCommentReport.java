package com.example.myblog.pojo2;


public class BlogCommentReport {

    private Long commentReportId; // 举报信息ID
    private Long commentId; // 举报评论ID
    private String commentDescription; // 举报描述

    // Getters and Setters
    public Long getCommentReportId() {
        return commentReportId;
    }

    public void setCommentReportId(Long commentReportId) {
        this.commentReportId = commentReportId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getCommentDescription() {
        return commentDescription;
    }

    public void setCommentDescription(String commentDescription) {
        this.commentDescription = commentDescription;
    }
}

