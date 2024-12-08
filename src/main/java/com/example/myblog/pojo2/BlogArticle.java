package com.example.myblog.pojo2;


public class BlogArticle {

    private Long articleId; // 博文ID
    private String userId; // 发表用户ID
    private String articleTitle; // 博文标题
    private String articleContent; // 博文内容
    private Long articleViews; // 浏览量
    private Long articleCommentCount; // 评论总数
    private Long articleLikeCount; // 点赞/踩数量
    private String articleDate; // 发表时间
    private Boolean articleIsPinned; // 是否置顶

    // Getters and Setters
    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Long getArticleViews() {
        return articleViews;
    }

    public void setArticleViews(Long articleViews) {
        this.articleViews = articleViews;
    }

    public Long getArticleCommentCount() {
        return articleCommentCount;
    }

    public void setArticleCommentCount(Long articleCommentCount) {
        this.articleCommentCount = articleCommentCount;
    }

    public Long getArticleLikeCount() {
        return articleLikeCount;
    }

    public void setArticleLikeCount(Long articleLikeCount) {
        this.articleLikeCount = articleLikeCount;
    }

    public String getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(String articleDate) {
        this.articleDate = articleDate;
    }

    public Boolean getArticleIsPinned() {
        return articleIsPinned;
    }

    public void setArticleIsPinned(Boolean articleIsPinned) {
        this.articleIsPinned = articleIsPinned;
    }
}
