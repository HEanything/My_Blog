package com.example.myblog.mapper;

import com.example.myblog.pojo2.BlogCommentReport;
import com.example.myblog.pojo2.BlogMessageReport;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReportMapper {
    //评论举报

    @Insert("INSERT INTO blog_comment_report(comment_id, comment_description) VALUES (#{commentId}, #{commentDescription})")
    void reportComment(int commentId,String commentDesciption);

    //留言举报
    @Insert("INSERT INTO blog_message_report(message_id, message_description) VALUES (#{messageId}, #{messageDesciption})")
    void reportMessage(int messageId, String messageDesciption);

    //获取所有评论举报
    @Select("select * from blog_comment_report")
    List<BlogCommentReport> getAllCommentReport();

    //获取所有留言举报
    @Select("select * from blog_message_report")
    List<BlogMessageReport> getAllMessageReport();

    //根据举报id获取评论举报
    @Select("select * from blog_comment_report where comment_report_id = #{commentReportId}")
    BlogCommentReport getCommentReportById(int commentReportId);

    //根据举报id获取留言举报
    @Select("select * from blog_message_report where message_report_id = #{messageReportId}")
    BlogMessageReport getMessageReportById(int messageReportId);

    //根据举报id删除评论举报
    @Delete("delete from blog_comment_report where comment_report_id = #{commentReportId}")
    void deleteCommentReport(int commentReportId);

    //根据评论id删除评论举报
    @Delete("delete from blog_comment_report where comment_id = #{commentId}")
    void deleteCommentReportByCommentId(int commentId);

    //根据举报id删除留言举报
    @Delete("delete from blog_message_report where message_report_id = #{messageReportId}")
    void deleteMessageReport(int messageReportId);

    //根据留言id删除留言举报
    @Delete("delete from blog_message_report where message_id = #{messageId}")
    void deleteMessageReportByMessageId(int messageId);

    //根据评论id获取评论举报
    @Select("select * from blog_comment_report where comment_id = #{commentId}")
    List<BlogCommentReport> getAllCommentReportByCommentId(int commentId);

    //根据留言id获取留言举报
    @Select("select * from blog_message_report where message_id = #{messageId}")
    List<BlogMessageReport> getAllMessageReportByMessageId(int messageId);
}
