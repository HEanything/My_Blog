package com.example.myblog.service.Impl;

import com.example.myblog.mapper.PostMapper;
import com.example.myblog.pojo.Post;
import com.example.myblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;
    @Override
    public List<Post> getPosts() {
        return postMapper.getPosts();
    }

    @Override
    public Post getPostById(int postId) {
        return postMapper.getPostById(postId);
    }
}
