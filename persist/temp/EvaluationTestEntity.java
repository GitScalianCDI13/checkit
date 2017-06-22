package com.scalian.checkup.temp;

import javax.persistence.*;

/**
 * Created by betaspin on 19/06/17.
 */
@Entity
@Table(name = "evaluation_test", schema = "public", catalog = "CheckUp")
@IdClass(EvaluationTestEntityPK.class)
public class EvaluationTestEntity {
    @Id
    @Column(name = "evaluation_id", nullable = false)
    private int evaluationId;

    @Id
    @Column(name = "test_id", nullable = false)
    private int testId;

    @ManyToOne
    @JoinColumn(name = "evaluation_id", referencedColumnName = "evaluation_id", nullable = false)
    private EvaluationEntity evaluationByEvaluationId;

    @ManyToOne
    @JoinColumn(name = "test_id", referencedColumnName = "test_id", nullable = false)
    private TestEntity testByTestId;

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
    public EvaluationEntity getEvaluationByEvaluationId() {
        return evaluationByEvaluationId;
    }
    public void setEvaluationByEvaluationId(EvaluationEntity evaluationByEvaluationId) {
        this.evaluationByEvaluationId = evaluationByEvaluationId;
    }
    public TestEntity getTestByTestId() {
        return testByTestId;
    }
    public void setTestByTestId(TestEntity testByTestId) {
        this.testByTestId = testByTestId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EvaluationTestEntity that = (EvaluationTestEntity) o;

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
