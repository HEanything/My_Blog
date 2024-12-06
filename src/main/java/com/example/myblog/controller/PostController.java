package com.example.myblog.controller;

import com.example.myblog.pojo.Post;
import com.example.myblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5174")
@RestController
public class PostController {
    @Autowired
    private PostService postService;



    @GetMapping("/api/posts")//获得所有文章
    public List<Post> getPosts() {
        return postService.getPosts();
    }
}
