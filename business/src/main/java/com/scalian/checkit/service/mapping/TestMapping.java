package com.scalian.checkit.service.mapping;

import com.scalian.checkit.model.*;
import com.scalian.checkit.service.model.*;

import java.util.ArrayList;
import java.util.List;

public class TestMapping {

    public static TestBO mapTestEntityToBO(TestEntity testEntity){
        TestBO testBO = new TestBO();
        testBO.setTestId(testEntity.getTestId());
        testBO.setTestLabel(testEntity.getTestLabel());
        testBO.setTestDescription(testEntity.getTestDescription());
        testBO.setTestSynopsis(testEntity.getTestSynopsis());
        testBO.setTestImage(testEntity.getTestImage());

        // Map Theme
        ThemeBO themeBO = ThemeMapping.mapThemeEntityToBO(testEntity.getTheme());
        testBO.setTheme(themeBO);

        // Map Questions
        List<QuestionBO> questionBOList = new ArrayList<>();
        for(QuestionEntity questionEntity : testEntity.getQuestions()){
            QuestionBO questionBO = QuestionMapping.mapQuestionEntityToBO(questionEntity);
            questionBOList.add(questionBO);
        }
        testBO.setQuestions(questionBOList);

        // Map Evaluations
        List<EvaluationBO> evaluationBOList = new ArrayList<>();
        for(EvaluationEntity evaluationEntity : testEntity.getEvaluations()){
            EvaluationBO evaluationBO = EvaluationMapping.mapEvaluationEntityToBO(evaluationEntity);
            evaluationBOList.add(evaluationBO);
        }
        testBO.setEvaluations(evaluationBOList);

        // Map TestResults
        List<TestResultBO> testResultBOList = new ArrayList<>();
        for(TestResultEntity testResultEntity : testEntity.getTestResults()){
            TestResultBO testResultBO = TestResultMapping.mapTestResultEntityToBO(testResultEntity);
            testResultBOList.add(testResultBO);
        }
        testBO.setTestResults(testResultBOList);

        return testBO;
    }

    public static TestEntity mapTestBOToEntity(TestBO testBO){
        TestEntity testEntity = new TestEntity();
        testEntity.setTestId(testBO.getTestId());
        testEntity.setTestLabel(testBO.getTestLabel());
        testEntity.setTestDescription(testBO.getTestDescription());
        testEntity.setTestSynopsis(testBO.getTestSynopsis());
        testEntity.setTestImage(testBO.getTestImage());

        // Map Theme
        ThemeEntity themeEntity = ThemeMapping.mapThemeBOToEntity(testBO.getTheme());
        testEntity.setTheme(themeEntity);

        // Map Questions
        List<QuestionEntity> questionEntities = new ArrayList<>();
        for (QuestionBO questionBO : testBO.getQuestions()){
            QuestionEntity questionEntity = QuestionMapping.mapQuestionBOToEntity(questionBO);
            questionEntities.add(questionEntity);
        }
        testEntity.setQuestions(questionEntities);

        // Map Evaluations
        List<EvaluationEntity> evaluationEntities = new ArrayList<>();
        for(EvaluationBO evaluationBO : testBO.getEvaluations()){
            EvaluationEntity evaluationEntity = EvaluationMapping.mapEvaluationBOToEntity(evaluationBO);
            evaluationEntities.add(evaluationEntity);
        }
        testEntity.setEvaluations(evaluationEntities);

        // Map TestResults
        List<TestResultEntity> testResultEntities = new ArrayList<>();
        for(TestResultBO testResultBO : testBO.getTestResults()){
            TestResultEntity testResultEntity = TestResultMapping.mapTestResultBOToEntity(testResultBO);
            testResultEntities.add(testResultEntity);
        }
        testEntity.setTestResults(testResultEntities);

        return testEntity;
    }

}
