package com.example.myblog.controller;

import com.example.myblog.pojo.Result;
import com.example.myblog.pojo2.*;
import com.example.myblog.service.ArticleService;
import com.example.myblog.service.CommentService;
import com.example.myblog.service.LikeService;
import com.example.myblog.service.MessageService;
import com.example.myblog.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class LikeController {
    @Autowired
    private LikeService likeService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private ArticleService articleService;

    //给留言点赞
    @PostMapping("/api/likes/addMessageLike")
    public Result addMessageLike(int messageId){
        Map<String, Object> claims = ThreadLocalUtil.get();
        String userId = (String) claims.get("userId");
        BlogMessage message = messageService.getMessageById(messageId);
        if (message==null) {
            return Result.error("没有该留言");
        }
        try {
            likeService.addMessageLike(userId,messageId);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("点赞失败");
        }
    }


    ///////留言///////////////
    //点赞按钮，获取点赞信息并改变点赞状态(获取是否点赞，是否点踩)
    @PostMapping("/api/likes/MessageLike")
    public Result MessageLike(int messageId){
        Map<String, Object> claims = ThreadLocalUtil.get();
        String userId = (String) claims.get("userId");
        BlogMessage message = messageService.getMessageById(messageId);
        if (message==null) {
            return Result.error("没有该留言");
        }
        try {
            BlogLikeMessage likeMessage = likeService.findLikeMessage(userId, messageId);
            if (likeMessage==null){
                likeService.addMessageLike(userId,messageId);
                return Result.success("点赞成功");
            }else {
                if (likeMessage.getLikeType()){
                    likeService.deleteLikeMessage(likeMessage.getLikeId(),messageId);//如果是点赞的状态就取消点赞
                    return Result.success("取消点赞成功");
                }else {
                    likeService.ChangeToLikeMessage(likeMessage.getLikeId(),messageId);//如果是点踩的状态就改为点赞
                    return Result.success("点赞成功");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("点赞失败");
        }
    }

    //点踩按钮
    @PostMapping("/api/likes/MessageDislike")
    public Result MessageDislike(int messageId){
        Map<String, Object> claims = ThreadLocalUtil.get();
        String userId = (String) claims.get("userId");
        BlogMessage message = messageService.getMessageById(messageId);
        if (message==null) {
            return Result.error("没有该留言");
        }
        try {
            BlogLikeMessage likeMessage = likeService.findLikeMessage(userId, messageId);
            if (likeMessage==null){
                likeService.addMessageDislike(userId,messageId);
                return Result.success("点踩成功");
            }else {
                if (!likeMessage.getLikeType()){
                    likeService.deleteDisLikeMessage(likeMessage.getLikeId(),messageId);//如果是点踩的状态就取消点踩
                    return Result.success("取消点踩成功");
                }else {
                    likeService.ChangeToDislikeMessage(likeMessage.getLikeId(),messageId);//如果是点赞的状态就改为点踩
                    return Result.success("点踩成功");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("点踩失败");
        }
    }

    ///////评论///////////
    //点赞按钮，获取点赞信息并改变点赞状态(获取是否点赞，是否点踩)
    @PostMapping("/api/likes/CommentLike")
    public Result CommentLike(int CommentId){
        Map<String, Object> claims = ThreadLocalUtil.get();
        String userId = (String) claims.get("userId");
        BlogComment comment = commentService.getCommentById(CommentId);
        if (comment==null) {
            return Result.error("没有该评论");
        }
        try {
            BlogLikeComment likeComment = likeService.findLikeComment(userId, CommentId);
            if (likeComment==null){
                likeService.addCommentLike(userId,CommentId);
                return Result.success("点赞成功");
            }else {
                if (likeComment.getLikeType()){
                    likeService.deleteLikeComment(likeComment.getLikeId(),CommentId);//如果是点赞的状态就取消点赞
                    return Result.success("取消点赞成功");
                }else {
                    likeService.ChangeToLikeComment(likeComment.getLikeId(),CommentId);//如果是点踩的状态就改为点赞
                    return Result.success("点赞成功");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("点赞失败");
        }
    }

    //点踩按钮
    @PostMapping("/api/likes/CommentDislike")
    public Result CommentDislike(int CommentId){
        Map<String, Object> claims = ThreadLocalUtil.get();
        String userId = (String) claims.get("userId");
        BlogComment comment = commentService.getCommentById(CommentId);
        if (comment==null) {
            return Result.error("没有该评论");
        }
        try {
            BlogLikeComment likeComment = likeService.findLikeComment(userId, CommentId);
            if (likeComment==null){
                likeService.addCommentDislike(userId,CommentId);
                return Result.success("点踩成功");
            }else {
                if (!likeComment.getLikeType()){
                    likeService.deleteDisLikeComment(likeComment.getLikeId(),CommentId);//如果是点踩的状态就取消点踩
                    return Result.success("取消点踩成功");
                }else {
                    likeService.ChangeToDislikeComment(likeComment.getLikeId(),CommentId);//如果是点赞的状态就改为点踩
                    return Result.success("点踩成功");
               }
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("点踩失败");
        }
    }

    ////////////文章/////////////
    @PostMapping("/api/likes/ArticleLike")
    public Result ArticleLike(int articleId){
        Map<String, Object> claims = ThreadLocalUtil.get();
        String userId = (String) claims.get("userId");
        BlogArticle article = articleService.getArticleById(articleId);
        if (article==null) {
            return Result.error("没有该文章");
        }
        try {
            BlogLikeArticle likeArticle = likeService.findLikeArticle(userId, articleId);
            if (likeArticle==null){
               likeService.addArticleLike(userId,articleId);
                return Result.success("点赞成功");
            }else {
                if (likeArticle.getLikeType()){
                    likeService.deleteLikeArticle(likeArticle.getLikeId(),articleId);//如果是点赞的状态就取消点赞
                    return Result.success("取消点赞成功");
                }else {
                    likeService.ChangeToLikeArticle(likeArticle.getLikeId(),articleId);//如果是点踩的状态就改为点赞
                    return Result.success("点赞成功");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            return Result.error("点赞失败");
        }
    }

    @PostMapping("/api/likes/ArticleDislike")
    public Result ArticleDislike(int articleId){
        Map<String, Object> claims = ThreadLocalUtil.get();
        String userId = (String) claims.get("userId");
        BlogArticle article = articleService.getArticleById(articleId);
        if (article==null) {
            return Result.error("没有该文章");
        }
        try {
            BlogLikeArticle likeArticle = likeService.findLikeArticle(userId, articleId);
            if (likeArticle==null){
                likeService.addArticleDislike(userId,articleId);
                return Result.success("点踩成功");
            }else {
                if (!likeArticle.getLikeType()){
                    likeService.deleteDisLikeArticle(likeArticle.getLikeId(),articleId);//如果是点踩的状态就取消点踩
                    return Result.success("取消点踩成功");
                }else {
                    likeService.ChangeToDislikeArticle(likeArticle.getLikeId(),articleId);//如果是点赞的状态就改为点踩
                    return Result.success("点踩成功");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("点踩失败");
        }
    }

}
