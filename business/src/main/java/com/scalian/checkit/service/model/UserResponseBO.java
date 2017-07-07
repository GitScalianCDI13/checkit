package com.scalian.checkit.service.model;

public class UserResponseBO {

    private Integer userResponseId;
    private Integer testResultId;

    private PossibleResponseBO possibleResponse;
    private QuestionBO question;
    private TestResultBO testResult;
    private UserBO user;

    public Integer getUserResponseId() {
        return userResponseId;
    }

    public void setUserResponseId(Integer userResponseId) {
        this.userResponseId = userResponseId;
    }

    public Integer getTestResultId() {
        return testResultId;
    }

    public void setTestResultId(Integer testResultId) {
        this.testResultId = testResultId;
    }

    public PossibleResponseBO getPossibleResponse() {
        return possibleResponse;
    }

    public void setPossibleResponse(PossibleResponseBO possibleResponse) {
        this.possibleResponse = possibleResponse;
    }

    public QuestionBO getQuestion() {
        return question;
    }

    public void setQuestion(QuestionBO question) {
        this.question = question;
    }

    public TestResultBO getTestResult() {
        return testResult;
    }

    public void setTestResult(TestResultBO testResult) {
        this.testResult = testResult;
    }

    public UserBO getUser() {
        return user;
    }

    public void setUser(UserBO user) {
        this.user = user;
    }
}
