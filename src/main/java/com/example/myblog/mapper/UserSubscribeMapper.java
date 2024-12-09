package com.example.myblog.mapper;

import com.example.myblog.pojo2.BlogUserSubscribe;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserSubscribeMapper {

    // 根据用户id和被订阅用户id查询订阅关系
    @Select("select * from blog_user_subscribe where user_id = #{myId} and user_subscribe_id = #{userId}")
    BlogUserSubscribe findSubscribe(String myId, String userId);

    // 添加订阅
    @Insert("insert into blog_user_subscribe(user_id,user_subscribe_id) values(#{myId},#{userId})")
    void subscribe(String myId, String userId);

    // 取消订阅
    @Delete("delete from blog_user_subscribe where user_id = #{myId} and user_subscribe_id = #{userId}")
    void unsubscribe(String myId, String userId);

    //我订阅的人
    @Select("select * from blog_user_subscribe where user_id = #{myId}")
    List<BlogUserSubscribe> getMySubscribes(String myId);

    //我的粉丝
    @Select("select * from blog_user_subscribe where user_subscribe_id = #{myId}")
    List<BlogUserSubscribe> getMyFans(String myId);

    //清空关注列表
    @Delete("delete from blog_user_subscribe where user_id = #{myId}")
    void clearSubscribes(String myId);

    //清空粉丝列表
    @Delete("delete from blog_user_subscribe where user_subscribe_id = #{myId}")
    void clearFans(String myId);
}
