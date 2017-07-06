package com.scalian.checkit.service.mapping;

import com.scalian.checkit.model.ResultEvaluationEntity;
import com.scalian.checkit.service.model.ResultEvaluationBO;

public class ResultEvaluationMapping {

    public static ResultEvaluationBO mapResultEvaluationEntityToBO(ResultEvaluationEntity resultEvaluationEntity){
        ResultEvaluationBO resultEvaluationBO = new ResultEvaluationBO();

        return resultEvaluationBO;
    }

    public static ResultEvaluationEntity mapEvaluationBOToEntity(ResultEvaluationBO resultEvaluationBO){
        ResultEvaluationEntity resultEvaluationEntity = new ResultEvaluationEntity();


        return resultEvaluationEntity;
    }

}
