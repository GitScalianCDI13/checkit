package com.scalian.checkit.service.model;

import java.util.List;

public class PossibleResponseBO {

    private Integer possibleResponseId;
    private Boolean possibleResponseChecked;
    private String possibleResponseLabel;
    private QuestionBO question;
    private List<UserResponseBO> userResponses;

    public Integer getPossibleResponseId() {
        return possibleResponseId;
    }

    public void setPossibleResponseId(Integer possibleResponseId) {
        this.possibleResponseId = possibleResponseId;
    }

    public Boolean getPossibleResponseChecked() {
        return possibleResponseChecked;
    }

    public void setPossibleResponseChecked(Boolean possibleResponseChecked) {
        this.possibleResponseChecked = possibleResponseChecked;
    }

    public String getPossibleResponseLabel() {
        return possibleResponseLabel;
    }

    public void setPossibleResponseLabel(String possibleResponseLabel) {
        this.possibleResponseLabel = possibleResponseLabel;
    }

    public QuestionBO getQuestion() {
        return question;
    }

    public void setQuestion(QuestionBO question) {
        this.question = question;
    }

    public List<UserResponseBO> getUserResponses() {
        return userResponses;
    }

    public void setUserResponses(List<UserResponseBO> userResponses) {
        this.userResponses = userResponses;
    }
}
