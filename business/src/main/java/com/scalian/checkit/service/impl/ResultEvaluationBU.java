package com.scalian.checkit.service.impl;

import com.scalian.checkit.model.ResultEvaluationEntity;
import com.scalian.checkit.repository.ResultEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultEvaluationBU {

    @Autowired
    public ResultEvaluationRepository resultEvaluationRepository;

    public ResultEvaluationEntity addNewResultEvaluation(Integer userId, Integer evaluationId){
        return resultEvaluationRepository.save(new ResultEvaluationEntity(userId, evaluationId));
    }
}
