package com.scalian.checkit.service.impl;

import com.scalian.checkit.model.ResultEvaluationEntity;
import com.scalian.checkit.model.TestEntity;
import com.scalian.checkit.model.TestResultEntity;
import com.scalian.checkit.repository.ResultEvaluationRepository;
import com.scalian.checkit.repository.TestRepository;
import com.scalian.checkit.repository.TestResultRepository;
import com.scalian.checkit.repository.UserRepository;
import com.scalian.checkit.service.model.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestResultBU {

    @Autowired
    public TestResultRepository testResultRepository;
    @Autowired
    public TestRepository testRepository;
    @Autowired
    public ResultEvaluationRepository resultEvaluationRepository;

    public TestResultEntity addNewTestResult(Integer resultEvaluationId, Integer testId){

        // Récupération du test
        TestEntity test = testRepository.findOne(testId);

        // Récupération du ResultEvaluation
        ResultEvaluationEntity resultEvaluation = resultEvaluationRepository.findOne(resultEvaluationId);

        // TestResult
        TestResultEntity testResultEntity = new TestResultEntity();
        testResultEntity.setResultEvaluation(resultEvaluation);
        testResultEntity.setTest(test);

        return testResultRepository.save(testResultEntity);
    }

    public TestResultEntity findOne(Integer id){
        return testResultRepository.findOne(id);
    }
}
