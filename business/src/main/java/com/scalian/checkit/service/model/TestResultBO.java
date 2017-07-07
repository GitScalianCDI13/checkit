package com.scalian.checkit.service.model;

import java.util.List;

public class TestResultBO {

    private Integer testResultId;
    private Integer testResultScore;
    private Integer testResultTime;
    private Integer resultEvaluationId;

    private ResultEvaluationBO resultEvaluation;
    private TestBO test;
    private List<UserResponseBO> userResponses;


    public Integer getTestResultId() {
        return testResultId;
    }

    public void setTestResultId(Integer testResultId) {
        this.testResultId = testResultId;
    }

    public Integer getTestResultScore() {
        return testResultScore;
    }

    public void setTestResultScore(Integer testResultScore) {
        this.testResultScore = testResultScore;
    }

    public Integer getTestResultTime() {
        return testResultTime;
    }

    public void setTestResultTime(Integer testResultTime) {
        this.testResultTime = testResultTime;
    }

    public Integer getResultEvaluationId() {
        return resultEvaluationId;
    }

    public void setResultEvaluationId(Integer resultEvaluationId) {
        this.resultEvaluationId = resultEvaluationId;
    }

    public ResultEvaluationBO getResultEvaluation() {
        return resultEvaluation;
    }

    public void setResultEvaluation(ResultEvaluationBO resultEvaluation) {
        this.resultEvaluation = resultEvaluation;
    }

    public TestBO getTest() {
        return test;
    }

    public void setTest(TestBO test) {
        this.test = test;
    }

    public List<UserResponseBO> getUserResponses() {
        return userResponses;
    }

    public void setUserResponses(List<UserResponseBO> userResponses) {
        this.userResponses = userResponses;
    }
}
