package com.example.myblog.service.Impl;

import com.example.myblog.mapper.CommentMapper;
import com.example.myblog.pojo.Comment;
import com.example.myblog.pojo2.BlogComment;
import com.example.myblog.service.CommentService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<BlogComment> getCommentsByArticleId(int articleId) {
        return commentMapper.getCommentsByArticleId(articleId);
    }


//    @Override
//    public List<Comment> getCommentsByPostId(int postId) {
//        return commentMapper.getCommentsByPostId(postId);
//    }
}
