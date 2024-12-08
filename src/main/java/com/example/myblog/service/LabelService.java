package com.example.myblog.service;

import com.example.myblog.pojo2.BlogLabel;

import java.util.List;

public interface LabelService {
    List<BlogLabel> getAllLabels();

    boolean addLabel(String labelName, String labelDesc);
}
