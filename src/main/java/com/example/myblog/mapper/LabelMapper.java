package com.example.myblog.mapper;

import com.example.myblog.pojo2.BlogLabel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LabelMapper {

    @Select("select * from blog_labels")
    List<BlogLabel> getAllLabels();
    @Insert("insert into blog_labels(label_name,label_description) values(#{labelName},#{labelDesc})")
    void addLabel(String labelName, String labelDesc);

    //根据标签id找标签
    @Select("select * from blog_labels where label_id = #{labelId}")
    BlogLabel getLabelById(int labelId);

    //删除标签
    @Delete("delete from blog_labels where label_id = #{labelId}")
    void deleteLabel(int labelId);
/////根据标签名找标签
    @Select("select * from blog_labels where label_name = #{labelname}")
    BlogLabel getLabelByName(String labelname);
}
