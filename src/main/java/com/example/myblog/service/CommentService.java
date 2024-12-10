package com.example.myblog.service;

import com.example.myblog.pojo.Comment;
import com.example.myblog.pojo2.BlogComment;

import java.util.List;

public interface CommentService {
    List<BlogComment> getCommentsByArticleId(int articleId);

    void addComment(String commentcontent, int articleId, String userId);

    BlogComment getCommentById(int commentId);

    //删除某一条评论
    void deleteComment(int commentId);

    //回复评论
    void replyComment(int parentCommentId, String content, int articleId, String userId);


    //修改评论
    void updateComment(int commentId, String content);

    //删除一篇的所有评论
    void deleteCommentsByArticleId(int articleId);

    //置顶评论
    void pinComment(int commentId);

    //取消置顶评论
    void unpinComment(int commentId);
}
