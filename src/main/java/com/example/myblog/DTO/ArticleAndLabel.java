package com.example.myblog.DTO;

public class ArticleAndLabel {

    private Long articleId; // 博文ID
    private String userId; // 发表用户ID
    private String articleTitle; // 博文标题
    private String articleContent; // 博文内容
    private Long articleViews; // 浏览量
    private Long articleCommentCount; // 评论总数
    private Long articleLikeCount; // 点赞/踩数量
    private String articleDate; // 发表时间
    private Boolean articleIsPinned; // 是否置顶
    private String labelName; // 标签名称

    // Getter and Setter for articleId
    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    // Getter and Setter for userId
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    // Getter and Setter for articleTitle
    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    // Getter and Setter for articleContent
    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    // Getter and Setter for articleViews
    public Long getArticleViews() {
        return articleViews;
    }

    public void setArticleViews(Long articleViews) {
        this.articleViews = articleViews;
    }

    // Getter and Setter for articleCommentCount
    public Long getArticleCommentCount() {
        return articleCommentCount;
    }

    public void setArticleCommentCount(Long articleCommentCount) {
        this.articleCommentCount = articleCommentCount;
    }

    // Getter and Setter for articleLikeCount
    public Long getArticleLikeCount() {
        return articleLikeCount;
    }

    public void setArticleLikeCount(Long articleLikeCount) {
        this.articleLikeCount = articleLikeCount;
    }

    // Getter and Setter for articleDate
    public String getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(String articleDate) {
        this.articleDate = articleDate;
    }

    // Getter and Setter for articleIsPinned
    public Boolean getArticleIsPinned() {
        return articleIsPinned;
    }

    public void setArticleIsPinned(Boolean articleIsPinned) {
        this.articleIsPinned = articleIsPinned;
    }

    // Getter and Setter for labelName
    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }
}
