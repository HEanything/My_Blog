package com.example.myblog.pojo2;

public class BlogLabel {

    private Long labelId; // 标签ID
    private String labelName; // 标签名称
    private String labelDescription; // 标签描述

    // Getters and Setters
    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getLabelDescription() {
        return labelDescription;
    }

    public void setLabelDescription(String labelDescription) {
        this.labelDescription = labelDescription;
    }
}
