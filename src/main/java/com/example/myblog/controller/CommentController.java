package com.example.myblog.controller;


import com.example.myblog.DTO.DetailedComment;
import com.example.myblog.pojo.Comment;
import com.example.myblog.pojo.Result;
import com.example.myblog.pojo2.BlogComment;
import com.example.myblog.service.CommentService;
import com.example.myblog.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    // 获取博客的详细评论包括是否点赞
    @GetMapping("/api/Articles/{ArticleId}/detailedcomments")
    public Result getDetailedComments(@PathVariable int ArticleId) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        String userId = (String) claims.get("userId");
        try {
            List<DetailedComment> detailedComments = commentService.getDetailedCommentsByArticleId(ArticleId,userId);
            if (detailedComments.isEmpty()) {
                return Result.success("评论为空");
            }else {
                return Result.success(detailedComments);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("没有找到评论");  // 如果没有评论，返回错误信息
        }
    }
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
    //发表评论
    @PostMapping("/api/comments/addcomments")
    public Result addComment(@RequestBody Map<String, Object> params) {
        String commentcontent = (String) params.get("commentcontent");
        int ArticleId = (int) params.get("ArticleId");
        if (commentcontent == null || commentcontent.trim().isEmpty()) {
            return Result.error("评论内容不能为空");
        }
        Map<String, Object> claims = ThreadLocalUtil.get();
        String userId = (String) claims.get("userId");
        try{
            commentService.addComment(commentcontent,ArticleId,userId);
            return Result.success("评论成功");
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("评论失败");
        }
    }


    // 回复评论
    @PostMapping("/api/comments/replycomments")
    public Result replyComment(@RequestBody Map<String, Object> params) {
        int ParentCommentId = (int) params.get("ParentCommentId");
        String content = (String) params.get("content");
        int ArticleId = (int) params.get("ArticleId");
        BlogComment parentComment = commentService.getCommentById(ParentCommentId);
        if (parentComment==null) {
            return Result.error("没有该评论");
        }
        Map<String, Object> claims = ThreadLocalUtil.get();
        String userId = (String) claims.get("userId");
        if (content==null||content.equals("")) {
            return Result.error("回复内容不能为空");
        }
        try{
            commentService.replyComment(ParentCommentId,content,ArticleId,userId);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("回复评论失败");
        }
    }
    //修改评论
    @PostMapping("/api/comments/updatecomments")
    public Result updateComment(@RequestBody Map<String, Object> params) {
        int commentId = (int) params.get("commentId");
        String content = (String) params.get("content");
        BlogComment comment = commentService.getCommentById(commentId);
        if (comment==null) {
            return Result.error("评论不存在");
        }
        if (content==null||content.equals("")) {
            return Result.error("评论内容不能为空");
        }
        try{
            commentService.updateComment(commentId,content);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("修改评论失败");
        }
    }

    //删除评论
    @PostMapping("/api/comments/deletecomments")
    public Result deleteComment(@RequestBody Map<String, Integer> params) {
        int commentId = params.get("commentId");
        BlogComment comment = commentService.getCommentById(commentId);
        if (comment==null) {
            return Result.error("评论不存在");
        }
        try{
            commentService.deleteComment(commentId);
            return Result.success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("删除评论失败");
        }
    }

    //置顶评论
    @PostMapping("/api/comments/pincomments")
    public Result pinComment(@RequestBody Map<String, Integer> params) {
        int commentId = params.get("commentId");
        BlogComment comment = commentService.getCommentById(commentId);
        if (comment==null) {
            return Result.error("评论不存在");
        }
        try{
            commentService.pinComment(commentId);
            return Result.success("置顶成功");
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("置顶评论失败");
        }
    }
    //取消置顶
    @PostMapping("/api/comments/unpincomments")
    public Result unpinComment(@RequestBody Map<String, Integer> params) {
        int commentId = params.get("commentId");
        BlogComment comment = commentService.getCommentById(commentId);
        if (comment==null) {
            return Result.error("评论不存在");
        }
        try{
            commentService.unpinComment(commentId);
            return Result.success("取消置顶成功");
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("取消置顶评论失败");
        }
    }
}
