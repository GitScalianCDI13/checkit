package com.scalian.checkit.service.impl;

import com.scalian.checkit.model.PossibleResponseEntity;
import com.scalian.checkit.model.QuestionEntity;
import com.scalian.checkit.repository.PossibleResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PossibleResponseBU {

    @Autowired
    public PossibleResponseRepository possibleResponseRepository;

    public PossibleResponseEntity findOne(Integer id){
        return possibleResponseRepository.findOne(id);
    }

    public List<PossibleResponseEntity> findByQuestionAndPossibleResponseChecked(QuestionEntity questionEntity, Boolean data){
        return possibleResponseRepository.findByQuestionAndPossibleResponseChecked(questionEntity, data);
    }

    public List<PossibleResponseEntity> findAllByQuestionOrderByPossibleResponseId(QuestionEntity questionEntity){
        return possibleResponseRepository.findAllByQuestionOrderByPossibleResponseId(questionEntity);
    }
}
