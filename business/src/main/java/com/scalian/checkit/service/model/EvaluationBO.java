package com.scalian.checkit.service.model;

import java.util.List;

public class EvaluationBO {
    
    private Integer evaluationId;
    private String evaluationLabel;
    private String evaluationJob;
    private List<TestBO> tests;
    private List<ResultEvaluationBO> resultEvaluations;

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

    public List<TestBO> getTests() {
        return tests;
    }

    public void setTests(List<TestBO> tests) {
        this.tests = tests;
    }

    public List<ResultEvaluationBO> getResultEvaluations() {
        return resultEvaluations;
    }

    public void setResultEvaluations(List<ResultEvaluationBO> resultEvaluations) {
        this.resultEvaluations = resultEvaluations;
    }
}
