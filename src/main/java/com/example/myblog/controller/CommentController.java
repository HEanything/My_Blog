package com.example.myblog.controller;


import com.example.myblog.pojo.Comment;
import com.example.myblog.pojo.Result;
import com.example.myblog.pojo2.BlogComment;
import com.example.myblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    // 获取博文的评论
    @GetMapping("/api/Articles/{ArticleId}/comments")
    public Result<List<BlogComment>> getCommentsByPostId(@PathVariable int ArticleId) {
        List<BlogComment> comments = commentService.getCommentsByArticleId(ArticleId);

        if (comments != null && !comments.isEmpty()) {
            return Result.success(comments);  // 返回成功的评论数据
        } else {
            return Result.error("没有找到评论");  // 如果没有评论，返回错误信息
        }
    }
}
