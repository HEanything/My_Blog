package com.example.myblog.service.Impl;


import com.example.myblog.DTO.ArticleAndLabel;
import com.example.myblog.mapper.*;
import com.example.myblog.pojo.Post;
import com.example.myblog.pojo2.BlogArticle;
import com.example.myblog.service.ArticleLabelService;
import com.example.myblog.service.ArticleService;
import com.example.myblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper ArticleMapper;
    @Autowired
    private ArticleLabelMapper articleLabelMapper;
    @Autowired
    private ArticleCollectionMapper articleCollectionMapper;
    @Autowired
    private CommentService commentService;
    @Autowired
    private LikeMapper likeMapper;

    //获取所有文章
    @Override
    public List<BlogArticle> getArticles() {
        return ArticleMapper.getArticles();
    }

    //获取具体的文章
    @Override
    public BlogArticle getArticleById(int articleId) {
        return ArticleMapper.getArticleById(articleId);
    }

    //发表文章
    @Override
    public void writeArticle(String title, String content, String userId) {
        ArticleMapper.writeArticle(title,content,userId);
    }

    //删除文章
    @Override
    public void deleteArticle(int articleId) {
        //删除文章的标签关系
        articleLabelMapper.deleteLabels(articleId);
        //删除文章的收藏关系
        articleCollectionMapper.deleteArticleFromAllCollection(articleId);
        //删除文章的点赞关系
        likeMapper.deleteAllArticleLike(articleId);
        //删除文章的评论关系
        commentService.deleteCommentsByArticleId(articleId);
        //删除文章
        ArticleMapper.deleteArticle(articleId);
    }

    //修改文章
    @Override
    public void updateArticle(int articleId, String title, String content) {
        ArticleMapper.updateArticle(articleId,title,content);
    }

    //根据用户id获取文章
    @Override
    public List<BlogArticle> getArticlesByUserId(String userId) {
        return ArticleMapper.getArticlesByUserId(userId);
    }

    //获取文章和标签
    @Override
    public List<ArticleAndLabel> getArticleAndLabel() {
        return ArticleMapper.getArticleAndLabel();
    }

    //根据文章id获取文章和标签
    @Override
    public ArticleAndLabel getArticleAndLabelById(int articleId) {
        return ArticleMapper.getArticleAndLabelById(articleId);
    }
}
