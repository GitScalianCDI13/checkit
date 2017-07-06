package com.scalian.checkit.service.model;

import java.util.List;

public class ResultEvaluationBO {
    
    private Integer resultEvaluationId;
    private Integer resultEvaluationTime;
    private Integer resultEvaluationScore;
    private Integer userId;
    private Integer evaluationId;
    private EvaluationBO evaluation;
    private UserBO user;
    private List<TestResultBO> testResults;

    public Integer getResultEvaluationId() {
        return resultEvaluationId;
    }

    public void setResultEvaluationId(Integer resultEvaluationId) {
        this.resultEvaluationId = resultEvaluationId;
    }

    public Integer getResultEvaluationTime() {
        return resultEvaluationTime;
    }

    public void setResultEvaluationTime(Integer resultEvaluationTime) {
        this.resultEvaluationTime = resultEvaluationTime;
    }

    public Integer getResultEvaluationScore() {
        return resultEvaluationScore;
    }

    public void setResultEvaluationScore(Integer resultEvaluationScore) {
        this.resultEvaluationScore = resultEvaluationScore;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Integer evaluationId) {
        this.evaluationId = evaluationId;
    }

    public EvaluationBO getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(EvaluationBO evaluation) {
        this.evaluation = evaluation;
    }

    public UserBO getUser() {
        return user;
    }

    public void setUser(UserBO user) {
        this.user = user;
    }

    public List<TestResultBO> getTestResults() {
        return testResults;
    }

    public void setTestResults(List<TestResultBO> testResults) {
        this.testResults = testResults;
    }
}
