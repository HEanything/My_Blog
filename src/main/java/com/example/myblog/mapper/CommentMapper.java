package com.example.myblog.mapper;

import com.example.myblog.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Select("select * from comments where post_id = #{postId}")
    List<Comment> getCommentsByPostId(int postId);
}
