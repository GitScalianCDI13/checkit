package com.scalian.checkit.service.model;

public class EvaluationBO {
    
    private Integer evaluationId;
    private String evaluationLabel;
    private String evaluationJob;

    public Integer getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Integer evaluationId) {
        this.evaluationId = evaluationId;
    }

    public String getEvaluationLabel() {
        return evaluationLabel;
    }

    public void setEvaluationLabel(String evaluationLabel) {
        this.evaluationLabel = evaluationLabel;
    }

    public String getEvaluationJob() {
        return evaluationJob;
    }

    public void setEvaluationJob(String evaluationJob) {
        this.evaluationJob = evaluationJob;
    }
}
