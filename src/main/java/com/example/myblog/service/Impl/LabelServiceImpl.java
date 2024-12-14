package com.example.myblog.service.Impl;

import com.example.myblog.mapper.ArticleLabelMapper;
import com.example.myblog.pojo2.BlogLabel;
import com.example.myblog.service.ArticleLabelService;
import com.example.myblog.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.myblog.mapper.LabelMapper;

import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelMapper labelMapper;
    @Autowired
    private ArticleLabelMapper articleLabelMapper;

    @Override
    public List<BlogLabel> getAllLabels() {
        return labelMapper.getAllLabels();
    }

    @Override
    public boolean addLabel(String labelName, String labelDesc) {
        try{
            labelMapper.addLabel(labelName,labelDesc);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public void deleteLabel(int labelId) {
        //删除文章标签关系
        articleLabelMapper.deleteArticleLabels(labelId);
        labelMapper.deleteLabel(labelId);

    }

    //根据标签id找标签
    @Override
    public BlogLabel getLabelById(int labelId) {
        return labelMapper.getLabelById(labelId);
    }

    @Override
    public BlogLabel getLabelByName(String labelname) {
        return labelMapper.getLabelByName(labelname);
    }
}
