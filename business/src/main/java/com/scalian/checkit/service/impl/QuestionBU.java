package com.scalian.checkit.service.impl;

import com.scalian.checkit.model.QuestionEntity;
import com.scalian.checkit.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionBU {

    @Autowired
    public QuestionRepository questionRepository;

    public QuestionEntity findOne(Integer id){
        return questionRepository.findOne(id);
    }


}
