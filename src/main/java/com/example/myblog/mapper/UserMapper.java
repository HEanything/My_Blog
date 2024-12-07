package com.example.myblog.mapper;


import com.example.myblog.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from users where user_id = #{userId}")
    User findUserById(String userId);

    @Insert("insert into users(user_id, password,email) values(#{userId}, #{password},#{email})")
    void register(String userId, String password,String email);
}
