package com.scalian.checkit.service.impl;

import com.scalian.checkit.model.EvaluationEntity;
import com.scalian.checkit.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluationBU {

    @Autowired
    public EvaluationRepository evaluationRepository;

    public EvaluationEntity findOne(Integer evaluationId){
        return evaluationRepository.findOne(evaluationId);
    }
}
