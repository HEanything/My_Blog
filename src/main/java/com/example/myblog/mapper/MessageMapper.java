package com.example.myblog.mapper;

import com.example.myblog.DTO.DetailedMessage;
import com.example.myblog.pojo2.BlogMessage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MessageMapper {

    //获取所有的留言并按照置顶排序
    @Select("select * from blog_messages " +
            " ORDER BY message_isPinned DESC, message_date DESC ")
    List<BlogMessage> getMessages();

    //添加留言
    @Insert("insert into blog_messages(message_content,user_id,message_like_count,message_date,parent_message_id) values(#{content},#{userId},0,now(),NULL)")
    void addMessage(String content,String userId);

    //根据留言id获得留言
    @Select("select * from blog_messages where message_id = #{messageId}")
    BlogMessage getMessageById(int messageId);

    //根据id置顶留言
    @Update("update blog_messages set message_isPinned = 1 where message_id = #{messageId}")
    void pinMessage(int messageId);

    //根据id取消置顶留言
    @Update("update blog_messages set message_isPinned = 0 where message_id = #{messageId}")
    void unpinMessage(int messageId);

    //根据用户id获得留言
    @Select("select * from blog_messages where user_id = #{userId}")
    List<BlogMessage> getMessagesByUserId(String userId);

    //回复留言
    @Insert("insert into blog_messages(message_content,user_id,message_like_count,message_date,parent_message_id) values(#{content},#{userId},0,now(),#{ParentMessageId})")
    void replyMessage(int ParentMessageId, String content, String userId);

    // 删除指定留言的子留言（递归）
    @Delete("DELETE FROM blog_messages WHERE parent_message_id = #{messageId}")
    void deleteRepliesByMessageId(int messageId);

    // 删除指定留言
    @Delete("DELETE FROM blog_messages WHERE message_id = #{messageId}")
    void deleteMessageById(int messageId);

    // 获取留言的所有子留言
    @Select("SELECT * FROM blog_messages WHERE parent_message_id = #{messageId}")
    List<BlogMessage> getRepliesByMessageId(int messageId);

    // 更新留言
    @Update("UPDATE blog_messages SET message_content = #{content} WHERE message_id = #{messageId}")
    void updateMessage(int messageId, String content);

    //获得对于用户而言的详细信息
    // 获取用户的留言详细信息
    @Select("SELECT m.message_id, m.user_id, m.message_like_count, m.message_date, m.message_content, " +
            "m.parent_message_id, m.message_isPinned, " +
            "(SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END FROM blog_like_message l " +
            "WHERE l.message_id = m.message_id AND l.user_id = #{userId} AND l.like_type = 1) AS liked, " +
            "(SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END FROM blog_like_message l " +
            "WHERE l.message_id = m.message_id AND l.user_id = #{userId} AND l.like_type = 0) AS disliked " +
            "FROM blog_messages m")
    List<DetailedMessage> getDetailedMessages(String userId);
}
