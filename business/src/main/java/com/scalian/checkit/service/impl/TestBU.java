package com.scalian.checkit.service.impl;

import com.scalian.checkit.model.EvaluationEntity;
import com.scalian.checkit.model.TestEntity;
import com.scalian.checkit.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestBU {

    @Autowired
    public TestRepository testRepository;

    public TestEntity findOne(Integer id){
        return testRepository.findOne(id);
    }

    public Iterable<TestEntity> findAll(){
        return testRepository.findAll();
    }

    public List<TestEntity> findAllByEvaluationsEqualsOrderByTestId(EvaluationEntity evaluationEntity){
        return testRepository.findAllByEvaluationsEqualsOrderByTestId(evaluationEntity);
    }
}
