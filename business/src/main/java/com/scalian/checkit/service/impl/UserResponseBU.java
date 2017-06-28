package com.scalian.checkit.service.impl;


import com.scalian.checkit.model.*;
import com.scalian.checkit.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserResponseBU {

    @Autowired
    public UserResponseRepository userResponseRepository;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public TestResultRepository testResultRepository;
    @Autowired
    public QuestionRepository questionRepository;
    @Autowired
    public PossibleResponseRepository possibleResponseRepository;

    public UserResponseEntity findOne(Integer id){
        return userResponseRepository.findOne(id);
    }

    public UserResponseEntity addNewUserResponse(Integer userId, Integer testResultId, Integer questionId, Integer possibleResponseId){

        // Récupération du candidat
        UserEntity userEntity = userRepository.findOne(userId);

        // Récupération du TestResult
        TestResultEntity testResult = testResultRepository.findOne(testResultId);

        // Récupération de la question
        QuestionEntity question = questionRepository.findOne(questionId);

        // Récupération de la réponse possible
        PossibleResponseEntity possibleResponse = possibleResponseRepository.findOne(possibleResponseId);

        // Création de la réponse
        UserResponseEntity userResponseEntity = new UserResponseEntity();
        userResponseEntity.setUser(userEntity);
        userResponseEntity.setTestResult(testResult);
        userResponseEntity.setQuestion(question);
        userResponseEntity.setPossibleResponse(possibleResponse);

        return userResponseRepository.save(userResponseEntity);
    }

    public List<UserResponseEntity> findByTestResultByQuestion(TestResultEntity testResultEntity, QuestionEntity questionEntity){
        return userResponseRepository.findByTestResultAndQuestion(testResultEntity, questionEntity);
    }

    public void delete(UserResponseEntity userResponseEntity){
        userResponseRepository.delete(userResponseEntity);
    }
}
