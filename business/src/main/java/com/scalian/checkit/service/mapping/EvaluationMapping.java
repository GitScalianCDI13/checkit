package com.scalian.checkit.service.mapping;

import com.scalian.checkit.model.EvaluationEntity;
import com.scalian.checkit.model.ResultEvaluationEntity;
import com.scalian.checkit.service.model.EvaluationBO;
import com.scalian.checkit.service.model.ResultEvaluationBO;

import java.util.ArrayList;
import java.util.List;

public class EvaluationMapping {

    public static EvaluationBO mapEvaluationEntityToBO(EvaluationEntity evaluationEntity){
        EvaluationBO evaluationBO = new EvaluationBO();
        evaluationBO.setEvaluationId(evaluationEntity.getEvaluationId());
        evaluationBO.setEvaluationJob(evaluationEntity.getEvaluationJob());
        evaluationBO.setEvaluationLabel(evaluationEntity.getEvaluationLabel());

        // Map des ResultEvaluationEntityToBO
        List<ResultEvaluationBO> resultEvaluationBOList = new ArrayList<>();
        for (ResultEvaluationEntity resultEvaluationEntity : evaluationEntity.getResultEvaluations()){
            ResultEvaluationBO resultEvaluationBO = ResultEvaluationMapping.mapResultEvaluationEntityToBO(resultEvaluationEntity);
            resultEvaluationBOList.add(resultEvaluationBO);
        }
        evaluationBO.setResultEvaluations(resultEvaluationBOList);

        return evaluationBO;
    }

    public static EvaluationEntity mapEvaluationBOToEntity(EvaluationBO evaluationBO){
        EvaluationEntity evaluationEntity = new EvaluationEntity();


        return evaluationEntity;
    }

}
