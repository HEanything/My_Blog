package com.example.myblog.mapper;

import com.example.myblog.pojo.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper {

    @Select("select * from posts")
    List<Post> getPosts();

}
