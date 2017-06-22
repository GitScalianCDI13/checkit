package com.scalian.checkup.temp;

import com.scalian.checkup.model.UserEntity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by betaspin on 19/06/17.
 */
@Entity
@Table(name = "result_evaluation", schema = "public", catalog = "CheckUp")
public class ResultEvaluationEntity {
    @Id
    @Column(name = "result_evaluation_id", nullable = false)
    private int resultEvaluationId;

    @Basic
    @Column(name = "result_evaluation_time", nullable = true)
    private Integer resultEvaluationTime;

    @Basic
    @Column(name = "result_evaluation_score", nullable = true)
    private Integer resultEvaluationScore;

    @Basic
    @Column(name = "user_id", nullable = false)
    private int userId;

    @Basic
    @Column(name = "evaluation_id", nullable = false)
    private int evaluationId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private UserEntity userByUserId;

    @ManyToOne
    @JoinColumn(name = "evaluation_id", referencedColumnName = "evaluation_id", nullable = false)
    private EvaluationEntity evaluationByEvaluationId;

    @OneToMany(mappedBy = "resultEvaluationByResultEvaluationId")
    private Collection<TestResultEntity> testResultsByResultEvaluationId;

    public int getResultEvaluationId() {
        return resultEvaluationId;
    }
    public void setResultEvaluationId(int resultEvaluationId) {
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
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getEvaluationId() {
        return evaluationId;
    }
    public void setEvaluationId(int evaluationId) {
        this.evaluationId = evaluationId;
    }
    public UserEntity getUserByUserId() {
        return userByUserId;
    }
    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }
    public EvaluationEntity getEvaluationByEvaluationId() {
        return evaluationByEvaluationId;
    }
    public void setEvaluationByEvaluationId(EvaluationEntity evaluationByEvaluationId) {
        this.evaluationByEvaluationId = evaluationByEvaluationId;
    }
    public Collection<TestResultEntity> getTestResultsByResultEvaluationId() {
        return testResultsByResultEvaluationId;
    }
    public void setTestResultsByResultEvaluationId(Collection<TestResultEntity> testResultsByResultEvaluationId) {
        this.testResultsByResultEvaluationId = testResultsByResultEvaluationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResultEvaluationEntity that = (ResultEvaluationEntity) o;

        if (resultEvaluationId != that.resultEvaluationId) return false;
        if (userId != that.userId) return false;
        if (evaluationId != that.evaluationId) return false;
        if (resultEvaluationTime != null ? !resultEvaluationTime.equals(that.resultEvaluationTime) : that.resultEvaluationTime != null)
            return false;
        if (resultEvaluationScore != null ? !resultEvaluationScore.equals(that.resultEvaluationScore) : that.resultEvaluationScore != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = resultEvaluationId;
        result = 31 * result + (resultEvaluationTime != null ? resultEvaluationTime.hashCode() : 0);
        result = 31 * result + (resultEvaluationScore != null ? resultEvaluationScore.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + evaluationId;
        return result;
    }
}
