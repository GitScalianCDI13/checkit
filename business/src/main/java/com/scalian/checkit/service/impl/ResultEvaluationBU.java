package com.scalian.checkit.service.impl;

import com.scalian.checkit.model.EvaluationEntity;
import com.scalian.checkit.model.ResultEvaluationEntity;
import com.scalian.checkit.model.UserEntity;
import com.scalian.checkit.repository.ResultEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultEvaluationBU {

    @Autowired
    public ResultEvaluationRepository resultEvaluationRepository;

    public ResultEvaluationEntity addNewResultEvaluation(Integer userId, Integer evaluationId){

        ResultEvaluationEntity resultEvaluationEntity = new ResultEvaluationEntity();

        // Set user
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userId);
        resultEvaluationEntity.setUser(userEntity);

        // Set evaluation
        EvaluationEntity evaluationEntity = new EvaluationEntity();
        evaluationEntity.setEvaluationId(evaluationId);
        resultEvaluationEntity.setEvaluation(evaluationEntity);

        return resultEvaluationRepository.save(resultEvaluationEntity);
    }
}
