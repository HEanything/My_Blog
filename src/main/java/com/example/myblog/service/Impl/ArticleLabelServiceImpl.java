package com.example.myblog.service.Impl;

import com.example.myblog.mapper.ArticleLabelMapper;
import com.example.myblog.pojo2.BlogSetArticleLabel;
import com.example.myblog.service.ArticleLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleLabelServiceImpl implements ArticleLabelService {

    @Autowired
    private ArticleLabelMapper articleLabelMapper;
    @Override
    public void setLabels(int articleId, String labelId) {
        articleLabelMapper.setLabels(articleId, labelId);

    }

    @Override
    public void deleteLabels(int articleId) {
        articleLabelMapper.deleteLabels(articleId);
    }

    @Override
    public BlogSetArticleLabel getLabelByArticleId(int articleId) {
        return articleLabelMapper.getLabelsByArticleId(articleId);
    }

    @Override
    public void updateLabels(int articleId, String labelId) {
        articleLabelMapper.updateLabels(articleId,labelId);
    }
}
