package com.scalian.checkit.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class EvaluationTestEntityPK implements Serializable {
    @Id
    @Column(name = "evaluation_id", nullable = false)
    private int evaluationId;

    @Id
    @Column(name = "test_id", nullable = false)
    private int testId;

    public int getEvaluationId() {
        return evaluationId;
    }
    public void setEvaluationId(int evaluationId) {
        this.evaluationId = evaluationId;
    }
    public int getTestId() {
        return testId;
    }
    public void setTestId(int testId) {
        this.testId = testId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EvaluationTestEntityPK that = (EvaluationTestEntityPK) o;

        if (evaluationId != that.evaluationId) return false;
        if (testId != that.testId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = evaluationId;
        result = 31 * result + testId;
        return result;
    }
}
