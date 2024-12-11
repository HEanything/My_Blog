package com.example.myblog.service.Impl;

import com.example.myblog.mapper.LikeMapper;
import com.example.myblog.pojo2.BlogLikeArticle;
import com.example.myblog.pojo2.BlogLikeComment;
import com.example.myblog.pojo2.BlogLikeMessage;
import com.example.myblog.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeMapper likeMapper;


    //////////////////////////////////留言/////////////////////////////////////////////
    // 添加留言点赞
    @Override
    public void addMessageLike(String userId, int messageId) {
        likeMapper.addMessageLike(userId, messageId);
        likeMapper.AddMessageLikeCount(messageId);

    }

    // 找到留言点赞记录
    @Override
    public BlogLikeMessage findLikeMessage(String userId, int messageId) {
        return likeMapper.findLikeMessage(userId, messageId);
    }

    // 删除留言点赞记录
    @Override
    public void deleteLikeMessage(Long likeId, int messageId) {
        likeMapper.deleteLikeMessage(likeId);
        likeMapper.SubMessageLikeCount(messageId);
    }

    // 将点踩改为点赞
    @Override
    public void ChangeToLikeMessage(Long likeId,int messageId) {
        likeMapper.ChangeToLikeMessage(likeId);
        likeMapper.AddTwoMessageLikeCount(messageId);//代数和加2
    }

    // 添加留言点踩
    @Override
    public void addMessageDislike(String userId, int messageId) {
        likeMapper.addMessageDislike(userId, messageId);
        likeMapper.SubMessageLikeCount(messageId);
    }

    // 删除留言点踩记录
    @Override
    public void deleteDisLikeMessage(Long likeId, int messageId) {
        likeMapper.deleteDisLikeMessage(likeId);
        likeMapper.AddMessageLikeCount(messageId);
    }

    // 将点赞改为点踩
    @Override
    public void ChangeToDislikeMessage(Long likeId, int messageId) {
        likeMapper.ChangeToDislikeMessage(likeId);
        likeMapper.SubTwoMessageLikeCount(messageId);

    }

    //////////////////////////////////评论/////////////////////////////////////////////
    // 找到评论点赞记录
    @Override
    public BlogLikeComment findLikeComment(String userId, int commentId) {
        return likeMapper.findLikeComment(userId, commentId);
    }

    // 添加评论点赞
    @Override
    public void addCommentLike(String userId, int commentId) {
        likeMapper.addCommentLike(userId, commentId);
        likeMapper.AddCommentLikeCount(commentId);
    }

    // 删除评论点赞记录
    @Override
    public void deleteLikeComment(Long likeId, int commentId) {
        likeMapper.deleteLikeComment(likeId);
        likeMapper.SubCommentLikeCount(commentId);

    }

    // 将点踩改为点赞
    @Override
    public void ChangeToLikeComment(Long likeId, int commentId) {
        likeMapper.ChangeToLikeComment(likeId);
        likeMapper.AddTwoCommentLikeCount(commentId);

    }

    // 添加评论点踩
    @Override
    public void addCommentDislike(String userId, int commentId) {
         likeMapper.addCommentDislike(userId, commentId);
         likeMapper.SubCommentLikeCount(commentId);
    }

    // 删除评论点踩记录
    @Override
    public void deleteDisLikeComment(Long likeId, int commentId) {
        likeMapper.deleteDisLikeComment(likeId);
        likeMapper.AddCommentLikeCount(commentId);

    }

    // 将点赞改为点踩
    @Override
    public void ChangeToDislikeComment(Long likeId, int commentId) {
        likeMapper.ChangeToDislikeComment(likeId);
        likeMapper.SubTwoCommentLikeCount(commentId);

    }

    /////////////////////////////////文章/////////////////////////////////////////////
    // 找到文章点赞记录
    @Override
    public BlogLikeArticle findLikeArticle(String userId, int articleId) {
        return likeMapper.findLikeArticle(userId, articleId);
    }

    // 添加文章点赞
    @Override
    public void addArticleLike(String userId, int articleId) {
        likeMapper.addArticleLike(userId, articleId);
        likeMapper.AddArticleLikeCount(articleId);

    }

    // 删除文章点赞记录
    @Override
    public void deleteLikeArticle(Long likeId, int articleId) {
        likeMapper.deleteLikeArticle(likeId);
        likeMapper.SubArticleLikeCount(articleId);
    }

    // 将点踩改为点赞
    @Override
    public void ChangeToLikeArticle(Long likeId, int articleId) {
        likeMapper.ChangeToLikeArticle(likeId);
        likeMapper.AddTwoArticleLikeCount(articleId);

    }

    // 添加文章点踩
    @Override
    public void addArticleDislike(String userId, int articleId) {
        likeMapper.addArticleDislike(userId, articleId);
        likeMapper.SubArticleLikeCount(articleId);

    }

    // 删除文章点踩记录
    @Override
    public void deleteDisLikeArticle(Long likeId, int articleId) {
        likeMapper.deleteDisLikeArticle(likeId);
        likeMapper.AddArticleLikeCount(articleId);

    }

    // 将点赞改为点踩
    @Override
    public void ChangeToDislikeArticle(Long likeId, int articleId) {
        likeMapper.ChangeToDislikeArticle(likeId);
        likeMapper.SubTwoArticleLikeCount(articleId);

    }

    // 清空用户的所有点赞记录
    @Override
    public void clearUserLike(String userId) {
        likeMapper.deleteAllArticleLikeByUserId(userId);
        likeMapper.deleteAllCommentLikeByUserId(userId);
        likeMapper.deleteAllMessageLikeByUserId(userId);
    }
}
