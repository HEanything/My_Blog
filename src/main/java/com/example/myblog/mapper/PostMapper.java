package com.example.myblog.mapper;

import com.example.myblog.pojo.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper {

    @Select("select * from posts")
    List<Post> getPosts();

    @Select("select * from posts where post_id = #{postId}")
    Post getPostById(int postId);
}
