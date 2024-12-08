package com.example.myblog.service.Impl;

import com.example.myblog.pojo2.BlogLabel;
import com.example.myblog.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.myblog.mapper.LabelMapper;

import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelMapper labelMapper;

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
}
