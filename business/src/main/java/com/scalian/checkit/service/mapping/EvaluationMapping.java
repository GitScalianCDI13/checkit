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
        for (ResultEvaluationEntity resultEvaluationEntity : evaluationEntity.getResultEvaluations()){
            ResultEvaluationBO resultEvaluationBO = ResultEvaluationMapping.mapResultEvaluationEntityToBO(resultEvaluationEntity);
            resultEvaluationBOList.add(resultEvaluationBO);
        }
        evaluationBO.setResultEvaluations(resultEvaluationBOList);

        // Map des TestEntity
        List<TestBO> testBOList = new ArrayList<>();
        for (TestEntity testEntity : evaluationEntity.getTests()) {
            TestBO testBO = TestMapping.mapTestEntityToBO(testEntity);
            testBOList.add(testBO);
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
        for (ResultEvaluationBO resultEvaluationBO : evaluationBO.getResultEvaluations()){
            ResultEvaluationEntity resultEvaluationEntity = ResultEvaluationMapping.mapEvaluationBOToEntity(resultEvaluationBO);
            resultEvaluationEntities.add(resultEvaluationEntity);
        }
        evaluationEntity.setResultEvaluations(resultEvaluationEntities);

        // Map des TestEntity
        List<TestEntity> testEntities = new ArrayList<>();
        for(TestBO testBO : evaluationBO.getTests()) {
            TestEntity testEntity = TestMapping.mapTestBOToEntity(testBO);
            testEntities.add(testEntity);
        }
        evaluationEntity.setTests(testEntities);

        return evaluationEntity;
    }

}
