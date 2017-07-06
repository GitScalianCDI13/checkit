package com.scalian.checkit.service.mapping;

import com.scalian.checkit.model.*;
import com.scalian.checkit.service.model.*;

public class UserResponseMapping {

    public static UserResponseBO mapUserResponseEntityToBO(UserResponseEntity userResponseEntity){
        UserResponseBO userResponseBO = new UserResponseBO();

        userResponseBO.setUserResponseId(userResponseEntity.getUserResponseId());

        // Map PossibleResponse
        PossibleResponseBO possibleResponseBO = PossibleResponseMapping.mapPossibleResponseEntityToBO(userResponseEntity.getPossibleResponse());
        userResponseBO.setPossibleResponse(possibleResponseBO);

        // Map Question
        QuestionBO questionBO = QuestionMapping.mapQuestionEntityToBO(userResponseEntity.getQuestion());
        userResponseBO.setQuestion(questionBO);

        // Map TestResult
        TestResultBO testResultBO = TestResultMapping.mapTestResultEntityToBO(userResponseEntity.getTestResult());
        userResponseBO.setTestResult(testResultBO);

        // Map User
        UserBO userBO = UserMapping.mapUserEntityToBO(userResponseEntity.getUser());
        userResponseBO.setUser(userBO);

        return userResponseBO;

    }
    public static UserResponseEntity mapUserResponseBOToEntity(UserResponseBO userResponseBO){
        UserResponseEntity userResponseEntity = new UserResponseEntity();

        userResponseEntity.setUserResponseId(userResponseBO.getUserResponseId());

        // Map PossibleResponse
        PossibleResponseEntity possibleResponseEntity = PossibleResponseMapping.mapPossibleResponseBOToEntity(userResponseBO.getPossibleResponse());
        userResponseEntity.setPossibleResponse(possibleResponseEntity);

        // Map Question
        QuestionEntity questionEntity = QuestionMapping.mapQuestionBOToEntity(userResponseBO.getQuestion());
        userResponseEntity.setQuestion(questionEntity);

        // Map TestResult
        TestResultEntity testResultEntity = TestResultMapping.mapTestResultBOToEntity(userResponseBO.getTestResult());
        userResponseEntity.setTestResult(testResultEntity);

        // Map User
        UserEntity userEntity = UserMapping.mapUserBOToEntity(userResponseBO.getUser());
        userResponseEntity.setUser(userEntity);


        return userResponseEntity;
    }
}
