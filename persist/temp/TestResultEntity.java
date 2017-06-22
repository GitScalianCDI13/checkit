package com.scalian.checkup.temp;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "test_result", schema = "public", catalog = "CheckUp")
public class TestResultEntity {
    @Id
    @Column(name = "test_result_id", nullable = false)
    private int testResultId;

    @Basic
    @Column(name = "test_result_score", nullable = true)
    private Integer testResultScore;

    @Basic
    @Column(name = "test_result_time", nullable = true)
    private Integer testResultTime;

    @Basic
    @Column(name = "test_id", nullable = false)
    private int testId;

    @Basic
    @Column(name = "result_evaluation_id", nullable = false)
    private int resultEvaluationId;

    @ManyToOne
    @JoinColumn(name = "test_id", referencedColumnName = "test_id", nullable = false)
    private TestEntity testByTestId;

    @ManyToOne
    @JoinColumn(name = "result_evaluation_id", referencedColumnName = "result_evaluation_id", nullable = false)
    private ResultEvaluationEntity resultEvaluationByResultEvaluationId;

    @OneToMany(mappedBy = "testResultByTestResultId")
    private Collection<UserResponseEntity> userResponsesByTestResultId;

    public int getTestResultId() {
        return testResultId;
    }
    public void setTestResultId(int testResultId) {
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
    public int getTestId() {
        return testId;
    }
    public void setTestId(int testId) {
        this.testId = testId;
    }
    public int getResultEvaluationId() {
        return resultEvaluationId;
    }
    public void setResultEvaluationId(int resultEvaluationId) {
        this.resultEvaluationId = resultEvaluationId;
    }
    public TestEntity getTestByTestId() {
        return testByTestId;
    }
    public void setTestByTestId(TestEntity testByTestId) {
        this.testByTestId = testByTestId;
    }
    public ResultEvaluationEntity getResultEvaluationByResultEvaluationId() {
        return resultEvaluationByResultEvaluationId;
    }
    public void setResultEvaluationByResultEvaluationId(ResultEvaluationEntity resultEvaluationByResultEvaluationId) {
        this.resultEvaluationByResultEvaluationId = resultEvaluationByResultEvaluationId;
    }
    public Collection<UserResponseEntity> getUserResponsesByTestResultId() {
        return userResponsesByTestResultId;
    }
    public void setUserResponsesByTestResultId(Collection<UserResponseEntity> userResponsesByTestResultId) {
        this.userResponsesByTestResultId = userResponsesByTestResultId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestResultEntity that = (TestResultEntity) o;

        if (testResultId != that.testResultId) return false;
        if (testId != that.testId) return false;
        if (resultEvaluationId != that.resultEvaluationId) return false;
        if (testResultScore != null ? !testResultScore.equals(that.testResultScore) : that.testResultScore != null)
            return false;
        if (testResultTime != null ? !testResultTime.equals(that.testResultTime) : that.testResultTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = testResultId;
        result = 31 * result + (testResultScore != null ? testResultScore.hashCode() : 0);
        result = 31 * result + (testResultTime != null ? testResultTime.hashCode() : 0);
        result = 31 * result + testId;
        result = 31 * result + resultEvaluationId;
        return result;
    }
}
