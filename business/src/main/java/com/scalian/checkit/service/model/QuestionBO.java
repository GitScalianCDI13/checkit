package com.scalian.checkit.service.model;

import java.util.List;

public class QuestionBO {

    private Integer questionId;
    private String questionLabel;
    private String questionContent;
    private Boolean questionType;
    private ThemeBO theme;
    private List<TestBO> tests;
    private List<UserResponseBO> userResponses;
    private List<PossibleResponseBO> possibleResponses;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionLabel() {
        return questionLabel;
    }

    public void setQuestionLabel(String questionLabel) {
        this.questionLabel = questionLabel;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public Boolean getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Boolean questionType) {
        this.questionType = questionType;
    }

    public ThemeBO getTheme() {
        return theme;
    }

    public void setTheme(ThemeBO theme) {
        this.theme = theme;
    }

    public List<TestBO> getTests() {
        return tests;
    }

    public void setTests(List<TestBO> tests) {
        this.tests = tests;
    }

    public List<UserResponseBO> getUserResponses() {
        return userResponses;
    }

    public void setUserResponses(List<UserResponseBO> userResponses) {
        this.userResponses = userResponses;
    }

    public List<PossibleResponseBO> getPossibleResponses() {
        return possibleResponses;
    }

    public void setPossibleResponses(List<PossibleResponseBO> possibleResponses) {
        this.possibleResponses = possibleResponses;
    }
}
