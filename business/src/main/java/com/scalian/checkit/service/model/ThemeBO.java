package com.scalian.checkit.service.model;

import java.util.List;

public class ThemeBO {

    private Integer themeId;
    private String themeLabel;
    private List<QuestionBO> questions;
    private List<TestBO> tests;

    public Integer getThemeId() {
        return themeId;
    }

    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }

    public String getThemeLabel() {
        return themeLabel;
    }

    public void setThemeLabel(String themeLabel) {
        this.themeLabel = themeLabel;
    }

    public List<QuestionBO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionBO> questions) {
        this.questions = questions;
    }

    public List<TestBO> getTests() {
        return tests;
    }

    public void setTests(List<TestBO> tests) {
        this.tests = tests;
    }
}
