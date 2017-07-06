package com.scalian.checkit.service.mapping;

import com.scalian.checkit.model.EvaluationEntity;
import com.scalian.checkit.model.ResultEvaluationEntity;
import com.scalian.checkit.model.TestEntity;
import com.scalian.checkit.service.model.EvaluationBO;
import com.scalian.checkit.service.model.ResultEvaluationBO;
import com.scalian.checkit.service.model.TestBO;

import java.util.ArrayList;
import java.util.List;

public class EvaluationMapping {

    public static EvaluationBO mapEvaluationEntityToBO(EvaluationEntity evaluationEntity){
        EvaluationBO evaluationBO = new EvaluationBO();
        evaluationBO.setEvaluationId(evaluationEntity.getEvaluationId());
        evaluationBO.setEvaluationJob(evaluationEntity.getEvaluationJob());
        evaluationBO.setEvaluationLabel(evaluationEntity.getEvaluationLabel());

        // Map des ResultEvaluationEntity
        List<ResultEvaluationBO> resultEvaluationBOList = new ArrayList<>();
        List<ResultEvaluationEntity> resultEvaluationEntities = evaluationEntity.getResultEvaluations();
        if(resultEvaluationEntities != null) {
            for (ResultEvaluationEntity resultEvaluationEntity : resultEvaluationEntities) {
                ResultEvaluationBO resultEvaluationBO = ResultEvaluationMapping.mapResultEvaluationEntityToBO(resultEvaluationEntity);
                resultEvaluationBOList.add(resultEvaluationBO);
            }
        }
        evaluationBO.setResultEvaluations(resultEvaluationBOList);

        // Map des TestEntity
        List<TestBO> testBOList = new ArrayList<>();
        List<TestEntity> testEntities = evaluationEntity.getTests();
        if(testEntities != null) {
            for (TestEntity testEntity : testEntities) {
                TestBO testBO = TestMapping.mapTestEntityToBO(testEntity);
                testBOList.add(testBO);
            }
        }
        evaluationBO.setTests(testBOList);

        return evaluationBO;
    }

    public static EvaluationEntity mapEvaluationBOToEntity(EvaluationBO evaluationBO){
        EvaluationEntity evaluationEntity = new EvaluationEntity();
        evaluationEntity.setEvaluationId(evaluationBO.getEvaluationId());
        evaluationEntity.setEvaluationJob(evaluationBO.getEvaluationJob());
        evaluationEntity.setEvaluationLabel(evaluationBO.getEvaluationLabel());

        // Map des ResultEvaluationBO
        List<ResultEvaluationEntity> resultEvaluationEntities = new ArrayList<>();
        List<ResultEvaluationBO> resultEvaluationBOList = evaluationBO.getResultEvaluations();
        if(resultEvaluationBOList != null) {
            for (ResultEvaluationBO resultEvaluationBO : resultEvaluationBOList) {
                ResultEvaluationEntity resultEvaluationEntity = ResultEvaluationMapping.mapEvaluationBOToEntity(resultEvaluationBO);
                resultEvaluationEntities.add(resultEvaluationEntity);
            }
        }
        evaluationEntity.setResultEvaluations(resultEvaluationEntities);

        // Map des TestEntity
        List<TestEntity> testEntities = new ArrayList<>();
        List<TestBO> testBOList = evaluationBO.getTests();
        if(testBOList != null) {
            for (TestBO testBO : testBOList) {
                TestEntity testEntity = TestMapping.mapTestBOToEntity(testBO);
                testEntities.add(testEntity);
            }
        }
        evaluationEntity.setTests(testEntities);

        return evaluationEntity;
    }

}
