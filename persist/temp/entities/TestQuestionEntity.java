package com.scalian.checkit.model;

import javax.persistence.*;

@Entity
@Table(name = "test_question", schema = "public", catalog = "CheckUp")
@IdClass(TestQuestionEntityPK.class)
public class TestQuestionEntity {
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

//    @ManyToOne
//    @JoinColumn(name = "test_id", referencedColumnName = "test_id", nullable = false)
//    private TestEntity testByTestId;
//    public TestEntity getTestByTestId() {
//        return testByTestId;
//    }
//    public void setTestByTestId(TestEntity testByTestId) {
//        this.testByTestId = testByTestId;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "question_id", referencedColumnName = "question_id", nullable = false)
//    private QuestionEntity questionByQuestionId;
//    public QuestionEntity getQuestionByQuestionId() {
//        return questionByQuestionId;
//    }
//    public void setQuestionByQuestionId(QuestionEntity questionByQuestionId) {
//        this.questionByQuestionId = questionByQuestionId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestQuestionEntity that = (TestQuestionEntity) o;

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
