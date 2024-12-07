package com.example.myblog.controller;

import com.example.myblog.pojo.Comment;
import com.example.myblog.pojo.Post;
import com.example.myblog.pojo.Result;
import com.example.myblog.service.CommentService;
import com.example.myblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class PostController {
    @Autowired
    private PostService postService;



    // 获取博文详情
    @GetMapping("/api/posts/{postId}")
    public Result<Post> getPostById(@PathVariable int postId) {
        Post post = postService.getPostById(postId);
        if (post != null) {
            return Result.success(post); // 成功时返回博文数据
        } else {
            return Result.error("博文不存在"); // 博文不存在时返回错误信息
        }
    }

    // 获取所有博文
    @GetMapping("/api/posts")
    public Result<List<Post>> getPosts() {
        List<Post> posts = postService.getPosts();
        return Result.success(posts); // 返回所有博文数据
    }


}
