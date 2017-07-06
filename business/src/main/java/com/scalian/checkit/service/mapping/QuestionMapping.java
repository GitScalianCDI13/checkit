package com.scalian.checkit.service.mapping;

import com.scalian.checkit.model.*;
import com.scalian.checkit.service.impl.UserResponseBU;
import com.scalian.checkit.service.model.*;

import java.util.ArrayList;
import java.util.List;

public class QuestionMapping {

    public static QuestionBO mapQuestionEntityToBO(QuestionEntity questionEntity){
        QuestionBO questionBO = new QuestionBO();
        questionBO.setQuestionId(questionEntity.getQuestionId());
        questionBO.setQuestionContent(questionEntity.getQuestionContent());
        questionBO.setQuestionLabel(questionEntity.getQuestionLabel());
        questionBO.setQuestionType(questionEntity.getQuestionType());

        // Map du Theme
        ThemeBO themeBO = ThemeMapping.mapThemeEntityToBO(questionEntity.getTheme());
        questionBO.setTheme(themeBO);

        // Map des Tests
        List<TestBO> testBOList = new ArrayList<>();
        for(TestEntity testEntity : questionEntity.getTests()){
            TestBO testBO = TestMapping.mapTestEntityToBO(testEntity);
            testBOList.add(testBO);
        }
        questionBO.setTests(testBOList);

        // Map des UserResponse
        List<UserResponseBO> userResponseBOList = new ArrayList<>();
        for(UserResponseEntity userResponseEntity : questionEntity.getUserResponses()){
            UserResponseBO userResponseBO = UserResponseMapping.mapUserResponseEntityToBO(userResponseEntity);
            userResponseBOList.add(userResponseBO);
        }
        questionBO.setUserResponses(userResponseBOList);

        // Map des PossibleResponse
        List<PossibleResponseBO> possibleResponseBOList = new ArrayList<>();
        for(PossibleResponseEntity possibleResponseEntity : questionEntity.getPossibleResponses()){
            PossibleResponseBO possibleResponseBO = PossibleResponseMapping.mapPossibleResponseEntityToBO(possibleResponseEntity);
            possibleResponseBOList.add(possibleResponseBO);
        }
        questionBO.setPossibleResponses(possibleResponseBOList);

        return questionBO;
    }

    public static QuestionEntity mapQuestionBOToEntity(QuestionBO questionBO){
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setQuestionId(questionBO.getQuestionId());
        questionEntity.setQuestionLabel(questionBO.getQuestionLabel());
        questionEntity.setQuestionType(questionBO.getQuestionType());
        questionEntity.setQuestionContent(questionBO.getQuestionContent());

        // Map du Theme
        ThemeEntity themeEntity = ThemeMapping.mapThemeBOToEntity(questionBO.getTheme());
        questionEntity.setTheme(themeEntity);

        // Map des Test
        List<TestEntity> testEntities = new ArrayList<>();
        for(TestBO testBO : questionBO.getTests()) {
            TestEntity testEntity = TestMapping.mapTestBOToEntity(testBO);
            testEntities.add(testEntity);
        }
        questionEntity.setTests(testEntities);

        // Map des UserResponse
        List<UserResponseEntity> userResponseEntities = new ArrayList<>();
        for(UserResponseBO userResponseBO : questionBO.getUserResponses()){
            UserResponseEntity userResponseEntity = UserResponseMapping.mapUserResponseBOToEntity(userResponseBO);
            userResponseEntities.add(userResponseEntity);
        }
        questionEntity.setUserResponses(userResponseEntities);

        // Map PossibleResponse
        List<PossibleResponseEntity> possibleResponseEntities = new ArrayList<>();
        for(PossibleResponseBO possibleResponseBO : questionBO.getPossibleResponses()){
            PossibleResponseEntity possibleResponseEntity = PossibleResponseMapping.mapPossibleResponseBOToEntity(possibleResponseBO);
            possibleResponseEntities.add(possibleResponseEntity);
        }
        questionEntity.setPossibleResponses(possibleResponseEntities);

        return questionEntity;
    }

}
