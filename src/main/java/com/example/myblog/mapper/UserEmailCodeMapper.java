package com.example.myblog.mapper;

import com.example.myblog.DTO.UserEmailCode;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserEmailCodeMapper {

    // 保存验证码
    @Insert("INSERT INTO blog_user_email_code (user_id, email, code, expire_time) " +
            "VALUES (#{userId}, #{email}, #{code}, #{expireTime})")
    void save(UserEmailCode userEmailCode);

    // 根据用户ID和邮箱查找验证码
    @Select("SELECT * FROM blog_user_email_code WHERE user_id = #{userId} AND email = #{email}")
    UserEmailCode findByUserIdAndEmail(String userId, String email);

    // 更新验证码
    @Insert("UPDATE blog_user_email_code SET code = #{code}, expire_time = #{expireTime} " +
            "WHERE user_id = #{userId} AND email = #{email}")
    void update(UserEmailCode userEmailCode);
}
