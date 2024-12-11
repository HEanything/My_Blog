package com.example.myblog.service;

import com.example.myblog.pojo2.BlogLikeArticle;
import com.example.myblog.pojo2.BlogLikeComment;
import com.example.myblog.pojo2.BlogLikeMessage;

public interface LikeService {
    ///////////////////////////////留言////////////////////////////////////////////
    //给留言点赞
    void addMessageLike(String userId, int messageId);

    //找到对应的留言点赞记录
    BlogLikeMessage findLikeMessage(String userId, int messageId);

    //删除留言点赞记录
    void deleteLikeMessage(Long likeId,int messageId);

    //将点踩改为点赞
    void ChangeToLikeMessage(Long likeId,int messageId);

    //给留言点踩
    void addMessageDislike(String userId, int messageId);

    //删除留言点踩记录
    void deleteDisLikeMessage(Long likeId,int messageId);

    //将点赞改为点踩
    void ChangeToDislikeMessage(Long likeId,int messageId);

    ///////////////////////////////评论////////////////////////////////////////////
    //找到评论点赞记录
    BlogLikeComment findLikeComment(String userId, int commentId);

    //给评论点赞
    void addCommentLike(String userId, int commentId);

    //删除评论点赞记录
    void deleteLikeComment(Long likeId,int commentId);

    //将点踩改为点赞
    void ChangeToLikeComment(Long likeId,int commentId);

    //给评论点踩
    void addCommentDislike(String userId, int commentId);

    //删除评论点踩记录
    void deleteDisLikeComment(Long likeId,int commentId);

    //将点赞改为点踩
    void ChangeToDislikeComment(Long likeId,int commentId);

    /////////////////////////////////文章////////////////////////////////////////////
    //找到文章点赞记录
    BlogLikeArticle findLikeArticle(String userId, int articleId);

    //给文章点赞
    void addArticleLike(String userId, int articleId);

    //删除文章点赞记录
    void deleteLikeArticle(Long likeId,int articleId);

    //将点踩改为点赞
    void ChangeToLikeArticle(Long likeId,int articleId);

    //给文章点踩
    void addArticleDislike(String userId, int articleId);

    //删除文章点踩记录
    void deleteDisLikeArticle(Long likeId,int articleId);

    //将点赞改为点踩
    void ChangeToDislikeArticle(Long likeId,int articleId);
    //////////////////////////////////其他////////////////////////////////////////////
    //清空一个人的点赞关系
    void clearUserLike(String userId);

}
