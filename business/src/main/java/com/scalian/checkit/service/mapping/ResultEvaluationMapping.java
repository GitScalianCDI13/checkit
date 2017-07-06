package com.scalian.checkit.service.mapping;

import com.scalian.checkit.model.EvaluationEntity;
import com.scalian.checkit.model.ResultEvaluationEntity;
import com.scalian.checkit.model.TestResultEntity;
import com.scalian.checkit.model.UserEntity;
import com.scalian.checkit.service.model.EvaluationBO;
import com.scalian.checkit.service.model.ResultEvaluationBO;
import com.scalian.checkit.service.model.TestResultBO;
import com.scalian.checkit.service.model.UserBO;

import java.util.ArrayList;
import java.util.List;

public class ResultEvaluationMapping {

    public static ResultEvaluationBO mapResultEvaluationEntityToBO(ResultEvaluationEntity resultEvaluationEntity){
        ResultEvaluationBO resultEvaluationBO = new ResultEvaluationBO();
        resultEvaluationBO.setResultEvaluationId(resultEvaluationEntity.getResultEvaluationId());
        resultEvaluationBO.setResultEvaluationTime(resultEvaluationEntity.getResultEvaluationTime());
        resultEvaluationBO.setResultEvaluationScore(resultEvaluationEntity.getResultEvaluationScore());

        // Map User
        UserBO userBO = UserMapping.mapUserEntityToBO(resultEvaluationEntity.getUser());
        resultEvaluationBO.setUser(userBO);

        // Map Evaluation
        EvaluationBO evaluationBO = EvaluationMapping.mapEvaluationEntityToBO(resultEvaluationEntity.getEvaluation());
        resultEvaluationBO.setEvaluation(evaluationBO);

        // Map TestResult
        List<TestResultBO> testResultBOList = new ArrayList<>();
        List<TestResultEntity> testResultEntities = resultEvaluationEntity.getTestResults();
        if(testResultEntities != null) {
            for (TestResultEntity testResultEntity : testResultEntities) {
                TestResultBO testResultBO = TestResultMapping.mapTestResultEntityToBO(testResultEntity);
                testResultBOList.add(testResultBO);
            }
        }
        resultEvaluationBO.setTestResults(testResultBOList);

        return resultEvaluationBO;
    }

    public static ResultEvaluationEntity mapEvaluationBOToEntity(ResultEvaluationBO resultEvaluationBO){
        ResultEvaluationEntity resultEvaluationEntity = new ResultEvaluationEntity();
        resultEvaluationEntity.setResultEvaluationId(resultEvaluationBO.getResultEvaluationId());
        resultEvaluationEntity.setResultEvaluationTime(resultEvaluationBO.getResultEvaluationTime());
        resultEvaluationEntity.setResultEvaluationScore(resultEvaluationBO.getResultEvaluationScore());

        // Map User
        UserEntity userEntity = UserMapping.mapUserBOToEntity(resultEvaluationBO.getUser());
        resultEvaluationEntity.setUser(userEntity);

        // Map Evaluation
        EvaluationEntity evaluationEntity = EvaluationMapping.mapEvaluationBOToEntity(resultEvaluationBO.getEvaluation());
        resultEvaluationEntity.setEvaluation(evaluationEntity);

        // Map TestResults
        List<TestResultEntity> testResultEntities = new ArrayList<>();
        List<TestResultBO> testResultBOList = resultEvaluationBO.getTestResults();
        if(testResultBOList != null){
            for(TestResultBO testResultBO : testResultBOList){
                TestResultEntity testResultEntity = TestResultMapping.mapTestResultBOToEntity(testResultBO);
                testResultEntities.add(testResultEntity);
            }
        }
        resultEvaluationEntity.setTestResults(testResultEntities);

        return resultEvaluationEntity;
    }

}
