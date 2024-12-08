package com.example.myblog.service.Impl;


import com.example.myblog.pojo.Post;
import com.example.myblog.pojo2.BlogArticle;
import com.example.myblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.myblog.mapper.ArticleMapper;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper ArticleMapper;

    @Override
    public List<BlogArticle> getArticles() {
        return ArticleMapper.getArticles();
    }

    @Override
    public BlogArticle getArticleById(int articleId) {
        return ArticleMapper.getArticleById(articleId);
    }

    @Override
    public void writeArticle(String title, String content, String userId) {
        ArticleMapper.writeArticle(title,content,userId);
    }

    @Override
    public void deleteArticle(int articleId) {
        ArticleMapper.deleteArticle(articleId);
    }

    @Override
    public void updateArticle(int articleId, String title, String content) {
        ArticleMapper.updateArticle(articleId,title,content);
    }

    @Override
    public List<BlogArticle> getArticlesByUserId(String userId) {
        return ArticleMapper.getArticlesByUserId(userId);
    }

//    @Override
//    public BlogArticle getArticleById(int postId) {
//        return null;
//    }
//
//    @Override
//    public void writeArticle(String title, String content, String userId) {
//
//    }
//
//    @Override
//    public void deleteArticle(int postId) {
//
//    }
//
//    @Override
//    public void updateArticle(BlogArticle article) {
//
//    }
//
//    @Override
//    public List<BlogArticle> getArticleByAuthor(String userId) {
//        return List.of();
//    }


//    @Override
//    public List<Post> getPosts() {
//        return postMapper.getPosts();
//    }
//
//    @Override
//    public Post getPostById(int postId) {
//        return postMapper.getPostById(postId);
//    }
//    @Override
//    public void writePost(String title, String content, String userId) {
//        postMapper.writePost(title,content,userId);
//    }
//
//    @Override
//    public void deletePost(int postId) {
//        postMapper.deletePost(postId);
//    }
//
//    @Override
//    public void updatePost(Post post) {
//        postMapper.updatePost(post);
//    }
//
//    @Override
//    public List<Post> getPostsByAuthor(String userId) {
//        return postMapper.getPostByAuthor(userId);
//
//    }
}