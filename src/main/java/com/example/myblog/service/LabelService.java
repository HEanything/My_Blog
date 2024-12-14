package com.example.myblog.service;

import com.example.myblog.pojo2.BlogLabel;

import java.util.List;

public interface LabelService {
    List<BlogLabel> getAllLabels();

    boolean addLabel(String labelName, String labelDesc);

    void deleteLabel(int labelId);

    BlogLabel getLabelById(int labelId);
//////////根据标签获取对应的标签
    BlogLabel getLabelByName(String labelname);
}
