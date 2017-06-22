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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EvaluationBO that = (EvaluationBO) o;

        if (evaluationId != null ? !evaluationId.equals(that.evaluationId) : that.evaluationId != null) return false;
        if (evaluationLabel != null ? !evaluationLabel.equals(that.evaluationLabel) : that.evaluationLabel != null)
            return false;
        return evaluationJob != null ? evaluationJob.equals(that.evaluationJob) : that.evaluationJob == null;
    }

    @Override
    public int hashCode() {
        int result = evaluationId != null ? evaluationId.hashCode() : 0;
        result = 31 * result + (evaluationLabel != null ? evaluationLabel.hashCode() : 0);
        result = 31 * result + (evaluationJob != null ? evaluationJob.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EvaluationBO{" +
                "evaluationId=" + evaluationId +
                ", evaluationLabel='" + evaluationLabel + '\'' +
                ", evaluationJob='" + evaluationJob + '\'' +
                '}';
    }
}
