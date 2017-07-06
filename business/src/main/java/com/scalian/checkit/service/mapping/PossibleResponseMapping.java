package com.scalian.checkit.service.mapping;

import com.scalian.checkit.model.PossibleResponseEntity;
import com.scalian.checkit.model.QuestionEntity;
import com.scalian.checkit.model.UserResponseEntity;
import com.scalian.checkit.service.model.PossibleResponseBO;
import com.scalian.checkit.service.model.QuestionBO;
import com.scalian.checkit.service.model.UserResponseBO;

import java.util.ArrayList;
import java.util.List;

public class PossibleResponseMapping {


    public static PossibleResponseBO mapPossibleResponseEntityToBO(PossibleResponseEntity possibleResponseEntity){
        PossibleResponseBO possibleResponseBO = new PossibleResponseBO();
        possibleResponseBO.setPossibleResponseId(possibleResponseEntity.getPossibleResponseId());
        possibleResponseBO.setPossibleResponseChecked(possibleResponseEntity.getPossibleResponseChecked());
        possibleResponseBO.setPossibleResponseLabel(possibleResponseEntity.getPossibleResponseLabel());

        // Map de la question
        QuestionBO questionBO = QuestionMapping.mapQuestionEntityToBO(possibleResponseEntity.getQuestion());
        possibleResponseBO.setQuestion(questionBO);

        // Map UserResponse
        List<UserResponseBO> userResponseBOList = new ArrayList<>();
        List<UserResponseEntity> userResponseEntities = possibleResponseEntity.getUserResponses();
        if(userResponseEntities != null) {
            for (UserResponseEntity userResponseEntity : userResponseEntities) {
                UserResponseBO userResponseBO = UserResponseMapping.mapUserResponseEntityToBO(userResponseEntity);
                userResponseBOList.add(userResponseBO);
            }
        }
        possibleResponseBO.setUserResponses(userResponseBOList);

        return possibleResponseBO;
    }

    public static PossibleResponseEntity mapPossibleResponseBOToEntity(PossibleResponseBO possibleResponseBO){
        PossibleResponseEntity possibleResponseEntity = new PossibleResponseEntity();
        possibleResponseEntity.setPossibleResponseId(possibleResponseBO.getPossibleResponseId());
        possibleResponseEntity.setPossibleResponseChecked(possibleResponseBO.getPossibleResponseChecked());
        possibleResponseEntity.setPossibleResponseLabel(possibleResponseBO.getPossibleResponseLabel());

        // Map de la question
        QuestionEntity questionEntity = QuestionMapping.mapQuestionBOToEntity(possibleResponseBO.getQuestion());
        possibleResponseEntity.setQuestion(questionEntity);

        // Map des UserResponse
        List<UserResponseEntity> userResponseEntities = new ArrayList<>();
        List<UserResponseBO> userResponseBOList = possibleResponseBO.getUserResponses();
        if(userResponseBOList != null) {
            for (UserResponseBO userResponseBO : userResponseBOList) {
                UserResponseEntity userResponseEntity = UserResponseMapping.mapUserResponseBOToEntity(userResponseBO);
                userResponseEntities.add(userResponseEntity);
            }
        }
        possibleResponseEntity.setUserResponses(userResponseEntities);


        return possibleResponseEntity;
    }

}
