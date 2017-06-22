package com.scalian.checkit.service.model;

public class TestBO {

    private Integer testId;
    private String testLabel;
    private Integer themeId;

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getTestLabel() {
        return testLabel;
    }

    public void setTestLabel(String testLabel) {
        this.testLabel = testLabel;
    }

    public Integer getThemeId() {
        return themeId;
    }

    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestBO testBO = (TestBO) o;

        if (testId != null ? !testId.equals(testBO.testId) : testBO.testId != null) return false;
        if (testLabel != null ? !testLabel.equals(testBO.testLabel) : testBO.testLabel != null) return false;
        return themeId != null ? themeId.equals(testBO.themeId) : testBO.themeId == null;
    }

    @Override
    public int hashCode() {
        int result = testId != null ? testId.hashCode() : 0;
        result = 31 * result + (testLabel != null ? testLabel.hashCode() : 0);
        result = 31 * result + (themeId != null ? themeId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TestBO{" +
                "testId=" + testId +
                ", testLabel='" + testLabel + '\'' +
                ", themeId=" + themeId +
                '}';
    }
}
