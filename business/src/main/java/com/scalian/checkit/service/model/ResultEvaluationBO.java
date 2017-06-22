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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResultEvaluationBO that = (ResultEvaluationBO) o;

        if (resultEvaluationId != null ? !resultEvaluationId.equals(that.resultEvaluationId) : that.resultEvaluationId != null)
            return false;
        if (resultEvaluationTime != null ? !resultEvaluationTime.equals(that.resultEvaluationTime) : that.resultEvaluationTime != null)
            return false;
        if (resultEvaluationScore != null ? !resultEvaluationScore.equals(that.resultEvaluationScore) : that.resultEvaluationScore != null)
            return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        return evaluationId != null ? evaluationId.equals(that.evaluationId) : that.evaluationId == null;
    }

    @Override
    public int hashCode() {
        int result = resultEvaluationId != null ? resultEvaluationId.hashCode() : 0;
        result = 31 * result + (resultEvaluationTime != null ? resultEvaluationTime.hashCode() : 0);
        result = 31 * result + (resultEvaluationScore != null ? resultEvaluationScore.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (evaluationId != null ? evaluationId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ResultEvaluationBO{" +
                "resultEvaluationId=" + resultEvaluationId +
                ", resultEvaluationTime=" + resultEvaluationTime +
                ", resultEvaluationScore=" + resultEvaluationScore +
                ", userId=" + userId +
                ", evaluationId=" + evaluationId +
                '}';
    }
}
