package com.scalian.checkit.service.impl;

import com.scalian.checkit.model.EvaluationEntity;
import com.scalian.checkit.model.ResultEvaluationEntity;
import com.scalian.checkit.model.UserEntity;
import com.scalian.checkit.repository.EvaluationRepository;
import com.scalian.checkit.repository.ResultEvaluationRepository;
import com.scalian.checkit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultEvaluationBU {

    @Autowired
    public ResultEvaluationRepository resultEvaluationRepository;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public EvaluationRepository evaluationRepository;

    public ResultEvaluationEntity findOne(Integer id){ return resultEvaluationRepository.findOne(id); }

    public ResultEvaluationEntity addNewResultEvaluation(Integer userId, Integer evaluationId){

        // Set user
        UserEntity userEntity = userRepository.findOne(userId);

        // Set evaluation
        EvaluationEntity evaluationEntity = evaluationRepository.findOne(evaluationId);

        ResultEvaluationEntity resultEvaluationEntity = new ResultEvaluationEntity();
        resultEvaluationEntity.setUser(userEntity);
        resultEvaluationEntity.setEvaluation(evaluationEntity);

        return resultEvaluationRepository.save(resultEvaluationEntity);
    }
}
