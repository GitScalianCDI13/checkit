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
        List<QuestionEntity> questionEntities = testEntity.getQuestions();
        if(questionEntities != null) {
            for (QuestionEntity questionEntity : questionEntities) {
                QuestionBO questionBO = QuestionMapping.mapQuestionEntityToBO(questionEntity);
                questionBOList.add(questionBO);
            }
        }
        testBO.setQuestions(questionBOList);

        // Map Evaluations
        List<EvaluationBO> evaluationBOList = new ArrayList<>();
        List<EvaluationEntity> evaluationEntities = testEntity.getEvaluations();
        if(evaluationEntities != null) {
            for (EvaluationEntity evaluationEntity : evaluationEntities) {
                EvaluationBO evaluationBO = EvaluationMapping.mapEvaluationEntityToBO(evaluationEntity);
                evaluationBOList.add(evaluationBO);
            }
        }
        testBO.setEvaluations(evaluationBOList);

        // Map TestResults
        List<TestResultBO> testResultBOList = new ArrayList<>();
        List<TestResultEntity> testResultEntities = testEntity.getTestResults();
        if(testResultEntities != null) {
            for (TestResultEntity testResultEntity : testResultEntities) {
                TestResultBO testResultBO = TestResultMapping.mapTestResultEntityToBO(testResultEntity);
                testResultBOList.add(testResultBO);
            }
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
        List<QuestionBO> questionBOList = testBO.getQuestions();
        if(questionBOList != null) {
            for (QuestionBO questionBO : questionBOList) {
                QuestionEntity questionEntity = QuestionMapping.mapQuestionBOToEntity(questionBO);
                questionEntities.add(questionEntity);
            }
        }
        testEntity.setQuestions(questionEntities);

        // Map Evaluations
        List<EvaluationEntity> evaluationEntities = new ArrayList<>();
        List<EvaluationBO> evaluationBOList = testBO.getEvaluations();
        if(evaluationBOList != null) {
            for (EvaluationBO evaluationBO : evaluationBOList) {
                EvaluationEntity evaluationEntity = EvaluationMapping.mapEvaluationBOToEntity(evaluationBO);
                evaluationEntities.add(evaluationEntity);
            }
        }
        testEntity.setEvaluations(evaluationEntities);

        // Map TestResults
        List<TestResultEntity> testResultEntities = new ArrayList<>();
        List<TestResultBO> testResultBOList = testBO.getTestResults();
        if(testResultBOList != null) {
            for (TestResultBO testResultBO : testResultBOList) {
                TestResultEntity testResultEntity = TestResultMapping.mapTestResultBOToEntity(testResultBO);
                testResultEntities.add(testResultEntity);
            }
        }
        testEntity.setTestResults(testResultEntities);

        return testEntity;
    }

}
