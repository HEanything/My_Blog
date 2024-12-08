package com.example.myblog.mapper;

import com.example.myblog.pojo2.BlogLabel;
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
}
