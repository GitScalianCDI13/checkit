package com.scalian.checkit.service.mapping;

import com.scalian.checkit.model.QuestionEntity;
import com.scalian.checkit.service.model.QuestionBO;

public class QuestionMapping {

    public static QuestionBO mapQuestionEntityToBO(QuestionEntity questionEntity){
        QuestionBO questionBO = new QuestionBO();

        return questionBO;
    }

    public static QuestionEntity mapQuestionBOToEntity(QuestionBO questionBO){
        QuestionEntity questionEntity = new QuestionEntity();


        return questionEntity;
    }

}
