package com.scalian.checkit.service.mapping;

import com.scalian.checkit.model.ResultEvaluationEntity;
import com.scalian.checkit.model.TestResultEntity;
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
        for(TestResultEntity testResultEntity : resultEvaluationEntity.getTestResults()){
            TestResultBO testResultBO = TestResultMapping.mapTestResultEntityToBO(testResultEntity);
            testResultBOList.add(testResultBO);
        }
        resultEvaluationBO.setTestResults(testResultBOList);

        return resultEvaluationBO;
    }

    public static ResultEvaluationEntity mapEvaluationBOToEntity(ResultEvaluationBO resultEvaluationBO){
        ResultEvaluationEntity resultEvaluationEntity = new ResultEvaluationEntity();


        return resultEvaluationEntity;
    }

}
