package com.scalian.checkit.service.impl;

import com.scalian.checkit.model.QuestionEntity;
import com.scalian.checkit.model.TestEntity;
import com.scalian.checkit.model.TestResultEntity;
import com.scalian.checkit.model.UserResponseEntity;
import com.scalian.checkit.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionBU {

    @Autowired
    public QuestionRepository questionRepository;

    public QuestionEntity findOne(Integer id){
        return questionRepository.findOne(id);
    }

    public List<QuestionEntity> findAllByTestsEqualsOrderByQuestionId(TestEntity testEntity){
        return questionRepository.findAllByTestsEqualsOrderByQuestionId(testEntity);
    }

}
