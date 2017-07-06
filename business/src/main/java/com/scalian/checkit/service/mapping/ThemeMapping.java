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

    public static ThemeBO mapThemeEntityToBO(ThemeEntity themeEntity){
        ThemeBO themeBO = new ThemeBO();
        themeBO.setThemeId(themeEntity.getThemeId());
        themeBO.setThemeLabel(themeEntity.getThemeLabel());


        // Map des QuestionEntityToBO
        List<QuestionBO> questionBOList = new ArrayList<>();
        for (QuestionEntity questionEntity : themeEntity.getQuestions()){
            QuestionBO questionBO = QuestionMapping.mapQuestionEntityToBO(questionEntity);
            questionBOList.add(questionBO);
        }
        themeBO.setQuestions(questionBOList);


        // Map des TestToBO
        List<TestBO> testBOList = new ArrayList<>();
        for (TestEntity testEntity : themeEntity.getTests()){
            TestBO testBO = TestMapping.mapTestEntityToBO(testEntity);
            testBOList.add(testBO);
        }
        themeBO.setTests(testBOList);

        return themeBO;

    }

    public static ThemeEntity mapThemeBOToEntity(ThemeBO themeBO){
        ThemeEntity themeEntity = new ThemeEntity();
        themeEntity.setThemeId(themeBO.getThemeId());
        themeEntity.setThemeLabel(themeBO.getThemeLabel());

        // Map des QuestionBOToEntity
        List<QuestionEntity> questionEntityList = new ArrayList<>();
        for (QuestionBO questionBO : themeBO.getQuestions()){
            QuestionEntity questionEntity = QuestionMapping.mapQuestionBOToEntity(questionBO);
            questionEntityList.add(questionEntity);
        }
        themeEntity.setQuestions(questionEntityList);


        // Map des TestBOToEntity
        List<TestEntity> testEntityList = new ArrayList<>();
        for (TestBO testBO : themeBO.getTests()){
            TestEntity testEntity = TestMapping.mapTestBOToEntity(testBO);
            testEntityList.add(testEntity);
        }
        themeEntity.setTests(testEntityList);


        return themeEntity;
    }
}
