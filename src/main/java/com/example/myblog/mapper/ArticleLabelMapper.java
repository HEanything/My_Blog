package com.example.myblog.mapper;

import com.example.myblog.pojo2.BlogSetArticleLabel;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ArticleLabelMapper {
    @Insert("insert into blog_set_article_label(article_id,label_id) values(#{articleId},#{labelId})")
    void setLabels(int articleId, String labelId);

    //根据文章的id删除标签
    @Delete("delete from blog_set_article_label where article_id = #{articleId}")
    void deleteLabels(int articleId);

    //根据文章获取标签
    @Select("select * from blog_set_article_label where article_id = #{articleId}")
    BlogSetArticleLabel getLabelsByArticleId(int articleId);


    @Update("update blog_set_article_label set label_id = #{labelId} where article_id = #{articleId}")
    void updateLabels(int articleId, String labelId);
    //根据标签id删除文章标签关系
    @Delete("delete from blog_set_article_label where label_id = #{labelId}")
    void deleteArticleLabels(int labelId);
}
