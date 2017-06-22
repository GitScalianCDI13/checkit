package com.scalian.checkup.temp;

import com.scalian.checkup.model.UserEntity;

import javax.persistence.*;

@Entity
@Table(name = "user_response", schema = "public", catalog = "CheckUp")
public class UserResponseEntity {
    @Id
    @Column(name = "user_response_id", nullable = false)
    private int userResponseId;

    @Basic
    @Column(name = "possible_response_id", nullable = false)
    private int possibleResponseId;

    @Basic
    @Column(name = "question_id", nullable = false)
    private int questionId;

    @Basic
    @Column(name = "user_id", nullable = false)
    private int userId;

    @Basic
    @Column(name = "test_result_id", nullable = false)
    private int testResultId;

    @ManyToOne
    @JoinColumn(name = "possible_response_id", referencedColumnName = "possible_response_id", nullable = false)
    private PossibleResponseEntity possibleResponseByPossibleResponseId;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "question_id", nullable = false)
    private QuestionEntity questionByQuestionId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private UserEntity userByUserId;

    @ManyToOne
    @JoinColumn(name = "test_result_id", referencedColumnName = "test_result_id", nullable = false)
    private TestResultEntity testResultByTestResultId;

    public int getUserResponseId() {
        return userResponseId;
    }
    public void setUserResponseId(int userResponseId) {
        this.userResponseId = userResponseId;
    }
    public int getPossibleResponseId() {
        return possibleResponseId;
    }
    public void setPossibleResponseId(int possibleResponseId) {
        this.possibleResponseId = possibleResponseId;
    }
    public int getQuestionId() {
        return questionId;
    }
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getTestResultId() {
        return testResultId;
    }
    public void setTestResultId(int testResultId) {
        this.testResultId = testResultId;
    }
    public PossibleResponseEntity getPossibleResponseByPossibleResponseId() {
        return possibleResponseByPossibleResponseId;
    }
    public void setPossibleResponseByPossibleResponseId(PossibleResponseEntity possibleResponseByPossibleResponseId) {
        this.possibleResponseByPossibleResponseId = possibleResponseByPossibleResponseId;
    }
    public QuestionEntity getQuestionByQuestionId() {
        return questionByQuestionId;
    }
    public void setQuestionByQuestionId(QuestionEntity questionByQuestionId) {
        this.questionByQuestionId = questionByQuestionId;
    }
    public UserEntity getUserByUserId() {
        return userByUserId;
    }
    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }
    public TestResultEntity getTestResultByTestResultId() {
        return testResultByTestResultId;
    }
    public void setTestResultByTestResultId(TestResultEntity testResultByTestResultId) {
        this.testResultByTestResultId = testResultByTestResultId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserResponseEntity that = (UserResponseEntity) o;

        if (userResponseId != that.userResponseId) return false;
        if (possibleResponseId != that.possibleResponseId) return false;
        if (questionId != that.questionId) return false;
        if (userId != that.userId) return false;
        if (testResultId != that.testResultId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userResponseId;
        result = 31 * result + possibleResponseId;
        result = 31 * result + questionId;
        result = 31 * result + userId;
        result = 31 * result + testResultId;
        return result;
    }
}
