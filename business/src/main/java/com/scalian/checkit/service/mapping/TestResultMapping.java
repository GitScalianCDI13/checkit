package com.scalian.checkit.service.mapping;

import com.scalian.checkit.model.ResultEvaluationEntity;
import com.scalian.checkit.model.TestEntity;
import com.scalian.checkit.model.TestResultEntity;
import com.scalian.checkit.model.UserResponseEntity;
import com.scalian.checkit.service.model.ResultEvaluationBO;
import com.scalian.checkit.service.model.TestBO;
import com.scalian.checkit.service.model.TestResultBO;
import com.scalian.checkit.service.model.UserResponseBO;

import java.util.ArrayList;
import java.util.List;

public class TestResultMapping {

    public static TestResultBO mapTestResultEntityToBO(TestResultEntity testResultEntity) {
        TestResultBO testResultBO = new TestResultBO();
        testResultBO.setTestResultId(testResultEntity.getTestResultId());
        testResultBO.setTestResultScore(testResultEntity.getTestResultScore());
        testResultBO.setTestResultTime(testResultEntity.getTestResultTime());

        // Map des UserResponseToBO
        List<UserResponseBO> userResponseBOList = new ArrayList<>();
        List<UserResponseEntity> userResponseEntityList = testResultEntity.getUserResponses();
        if (userResponseEntityList != null) {
            for (UserResponseEntity userResponseEntity : userResponseEntityList) {
                UserResponseBO userResponseBO = UserResponseMapping.mapUserResponseEntityToBO(userResponseEntity);
                userResponseBOList.add(userResponseBO);
            }
        }
        testResultBO.setUserResponses(userResponseBOList);

        // Map des TestTToBO
        TestBO testBO = TestMapping.mapTestEntityToBO(testResultEntity.getTest());
        testResultBO.setTest(testBO);


        // Map des ResultEvaluationToBO
        testResultBO.setResultEvaluationId(testResultEntity.getResultEvaluation().getResultEvaluationId());

        return testResultBO;
    }


    public static TestResultEntity mapTestResultBOToEntity(TestResultBO testResultBO){
        TestResultEntity testResultEntity = new TestResultEntity();
        testResultEntity.setTestResultId(testResultEntity.getTestResultId());
        testResultEntity.setTestResultScore(testResultEntity.getTestResultScore());
        testResultEntity.setTestResultTime(testResultEntity.getTestResultTime());

        // Map des TestResultBOToEntity
        List<UserResponseEntity> userResponseEntityList = new ArrayList<>();
        List<UserResponseBO> userResponseBOList = testResultBO.getUserResponses();
        if (userResponseBOList != null) {
            for (UserResponseBO userResponseBO : userResponseBOList) {
                UserResponseEntity userResponseEntity = UserResponseMapping.mapUserResponseBOToEntity(userResponseBO);
                userResponseEntityList.add(userResponseEntity);
            }
        }
        testResultEntity.setUserResponses(userResponseEntityList);

        // Map des TestTBOToEntity
        TestEntity testEntity = TestMapping.mapTestBOToEntity(testResultBO.getTest());
        testResultEntity.setTest(testEntity);

        // Map des ResultEvaluationBOToEntity
        ResultEvaluationEntity resultEvaluationEntity = new ResultEvaluationEntity();
        resultEvaluationEntity.setResultEvaluationId(testResultBO.getResultEvaluationId());
        testResultEntity.setResultEvaluation(resultEvaluationEntity);

        return testResultEntity;
    }

}
