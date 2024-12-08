package com.example.myblog.service;

import com.example.myblog.pojo.Comment;
import com.example.myblog.pojo2.BlogComment;

import java.util.List;

public interface CommentService {
    List<BlogComment> getCommentsByArticleId(int articleId);

//    List<Comment> getCommentsByPostId(int postId);
}
