package com.scalian.checkit.service.model;

import java.util.List;

public class TestBO {

    private Integer testId;
    private String testLabel;
    private String testImage;
    private String testDescription;
    private String testSynopsis;
    private ThemeBO theme;
    private List<EvaluationBO> evaluations;
    private List<QuestionBO> questions;
    private List<TestResultBO> testResults;

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getTestImage() {
        return testImage;
    }

    public void setTestImage(String testImage) {
        this.testImage = testImage;
    }

    public String getTestDescription() {
        return testDescription;
    }

    public void setTestDescription(String testDescription) {
        this.testDescription = testDescription;
    }

    public String getTestSynopsis() {
        return testSynopsis;
    }

    public void setTestSynopsis(String testSynopsis) {
        this.testSynopsis = testSynopsis;
    }

    public List<EvaluationBO> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<EvaluationBO> evaluations) {
        this.evaluations = evaluations;
    }

    public List<QuestionBO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionBO> questions) {
        this.questions = questions;
    }

    public ThemeBO getTheme() {
        return theme;
    }

    public void setTheme(ThemeBO theme) {
        this.theme = theme;
    }

    public List<TestResultBO> getTestResults() {
        return testResults;
    }

    public void setTestResults(List<TestResultBO> testResults) {
        this.testResults = testResults;
    }

    public String getTestLabel() {
        return testLabel;
    }

    public void setTestLabel(String testLabel) {
        this.testLabel = testLabel;
    }
}
