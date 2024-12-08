package com.example.myblog.mapper;


import com.example.myblog.pojo.User;
import com.example.myblog.pojo2.BlogUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from blog_users where user_id=#{userId}")
    BlogUser findUserById(String userId);

    @Insert("INSERT INTO blog_users(user_id, user_password, user_email, " +
            "user_profile_photo, user_registration_time, user_birthday, user_age, " +
            "user_telephone_number, user_sex, user_description, user_allowArticle, user_isBanned) " +
            "VALUES(#{userId}, #{password}, #{email}, 'default_photo.jpg', NOW(), NULL, NULL, NULL, '未公开', NULL, 1, 0)")
    void register(String userId, String password, String email);

    @Update("update blog_users set user_password = #{newPWD} where user_id = #{userId}")
    void updatePWD(String newPWD, String userId);

    @Update("update blog_users set user_sex = #{gender}, user_email = #{email}, user_telephone_number = #{phoneNumber} where user_id = #{userId}")
    void updateMyselfInfo(String gender, String email, String phoneNumber, String userId);
    @Update("update blog_users set user_password = #{password}, user_sex = #{gender}, user_email = #{email}, user_telephone_number = #{phoneNumber} where user_id = #{userId}")
    void updateUserInfo(String password, String gender, String email, String phoneNumber, String userId);

    @Select("select * from blog_users")
    List<BlogUser> getUsersInfo();

    @Update("delete from blog_users where user_id = #{userId}")
    void deleteUser(String userId);

    @Update("update blog_users set user_isBanned = 1 where user_id = #{userId}")
    void banUser(String userId);
    @Update("update blog_users set user_isBanned = 0 where user_id = #{userId}")
    void unbanUser(String userId);


//    @Select("select * from users where user_id = #{userId}")
//    User findUserById(String userId);
//
//    @Insert("insert into users(user_id, password,email) values(#{userId}, #{password},#{email})")
//    void register(String userId, String password,String email);
//
//    @Select("select * from users")
//    List<User> getUsersInfo();
//    //更新用户信息
//    @Update("update users set password = #{password}, email = #{email}, gender = #{gender}, phone_number = #{phoneNumber} where user_id = #{userId}")
//    void updateUserInfo(String password, String gender, String email, String phoneNumber, String userId);
//    //更新密码
//    @Update("update users set password = #{newPWD} where user_id = #{userId}")
//    void updatePWD(String newPWD,String userId);
}
