package com.scalian.checkit.service.mapping;

import com.scalian.checkit.model.QuestionEntity;
import com.scalian.checkit.model.TestEntity;
import com.scalian.checkit.model.ThemeEntity;
import com.scalian.checkit.service.model.QuestionBO;
import com.scalian.checkit.service.model.TestBO;
import com.scalian.checkit.service.model.ThemeBO;

import java.util.ArrayList;
import java.util.List;

public class ThemeMapping {

    public static ThemeBO mapThemeEntityToBO(ThemeEntity themeEntity) {
        ThemeBO themeBO = new ThemeBO();
        themeBO.setThemeId(themeEntity.getThemeId());
        themeBO.setThemeLabel(themeEntity.getThemeLabel());

        /* Comment because not used
        // Map des QuestionEntityToBO
        List<QuestionBO> questionBOList = new ArrayList<>();
        List<QuestionEntity> questionEntityList = themeEntity.getQuestions();
        if (questionEntityList != null) {
            for (QuestionEntity questionEntity : questionEntityList) {
                QuestionBO questionBO = QuestionMapping.mapQuestionEntityToBO(questionEntity);
                questionBOList.add(questionBO);
            }
        }
        themeBO.setQuestions(questionBOList);


        // Map des TestToBO
        List<TestBO> testBOList = new ArrayList<>();
        List<TestEntity> testEntityList = themeEntity.getTests();
        if (testEntityList != null) {
            for (TestEntity testEntity : testEntityList) {
                TestBO testBO = TestMapping.mapTestEntityToBO(testEntity);
                testBOList.add(testBO);
            }
        }
        themeBO.setTests(testBOList);
        */

        return themeBO;
    }


    public static ThemeEntity mapThemeBOToEntity(ThemeBO themeBO){
        ThemeEntity themeEntity = new ThemeEntity();
        themeEntity.setThemeId(themeBO.getThemeId());
        themeEntity.setThemeLabel(themeBO.getThemeLabel());

        /* Comment because not used
        // Map des QuestionBOToEntity
        List<QuestionEntity> questionEntityList = new ArrayList<>();
        List<QuestionBO> questionBOList = themeBO.getQuestions();
        if (questionBOList != null) {
            for (QuestionBO questionBO : questionBOList) {
                QuestionEntity questionEntity = QuestionMapping.mapQuestionBOToEntity(questionBO);
                questionEntityList.add(questionEntity);
            }
        }
        themeEntity.setQuestions(questionEntityList);


        // Map des TestBOToEntity
        List<TestEntity> testEntityList = new ArrayList<>();
        List<TestBO> testBOList = themeBO.getTests();
        if (testBOList != null ) {
            for (TestBO testBO : testBOList) {
                TestEntity testEntity = TestMapping.mapTestBOToEntity(testBO);
                testEntityList.add(testEntity);
            }
        }
        themeEntity.setTests(testEntityList);*/


        return themeEntity;
    }
}
