package com.scalian.checkit.service.model;

public class ResultEvaluationBO {
    
    private Integer resultEvaluationId;
    private Integer resultEvaluationTime;
    private Integer resultEvaluationScore;
    private Integer userId;
    private Integer evaluationId;

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
}
