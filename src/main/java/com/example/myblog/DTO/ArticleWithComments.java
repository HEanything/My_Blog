package com.example.myblog.DTO;

import java.util.List;

public class ArticleWithComments {
    private DetailedArticle article;  // 文章详情
    private List<DetailedComment> comments;  // 文章的评论列表

    // Getter and Setter
    public DetailedArticle getArticle() {
        return article;
    }

    public void setArticle(DetailedArticle article) {
        this.article = article;
    }

    public List<DetailedComment> getComments() {
        return comments;
    }

    public void setComments(List<DetailedComment> comments) {
        this.comments = comments;
    }
}
