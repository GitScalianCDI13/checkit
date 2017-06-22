package com.scalian.checkit.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TestQuestionEntityPK implements Serializable {
    @Id
    @Column(name = "test_id", nullable = false)
    private int testId;

    @Id
    @Column(name = "question_id", nullable = false)
    private int questionId;

    public int getTestId() {
        return testId;
    }
    public void setTestId(int testId) {
        this.testId = testId;
    }
    public int getQuestionId() {
        return questionId;
    }
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestQuestionEntityPK that = (TestQuestionEntityPK) o;

        if (testId != that.testId) return false;
        if (questionId != that.questionId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = testId;
        result = 31 * result + questionId;
        return result;
    }
}
