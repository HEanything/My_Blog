package com.example.myblog.service;

import com.example.myblog.DTO.ArticleAndLabel;
import com.example.myblog.DTO.DetailedArticle;
import com.example.myblog.pojo.Post;
import com.example.myblog.pojo2.BlogArticle;

import java.util.List;

public interface ArticleService {

    List<BlogArticle> getArticles();

    BlogArticle getArticleById(int articleId);

    void writeArticle(String title, String content, String userId);


    void deleteArticle(int articleId);

    void updateArticle(int articleId, String title, String content);

    List<BlogArticle> getArticlesByUserId(String userId);

    List<ArticleAndLabel> getArticleAndLabel();

    ArticleAndLabel getArticleAndLabelById(int articleId);

    ////////////获取详细的文章详细
    DetailedArticle getDetailedArticle(int articleId, String userId);

    ///////////////搜索文章
    List<ArticleAndLabel> searchArticles(String keyword);


//    BlogArticle getArticleById(int postId);
//
//    void writeArticle(String title, String content, String userId);
//
//    void deleteArticle(int postId);
//
//    void updateArticle(BlogArticle article);
//
//    List<BlogArticle> getArticleByAuthor(String userId);
}
