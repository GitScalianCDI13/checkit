package com.scalian.checkup.temp;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by betaspin on 19/06/17.
 */
@Entity
@Table(name = "test", schema = "public", catalog = "CheckUp")
public class TestEntity {
    @Id
    @Column(name = "test_id", nullable = false)
    private int testId;

    @Basic
    @Column(name = "test_label", nullable = false, length = 255)
    private String testLabel;

    @Basic
    @Column(name = "theme_id", nullable = false)
    private int themeId;

    @OneToMany(mappedBy = "testByTestId")
    private Collection<EvaluationTestEntity> evaluationTestsByTestId;

    @ManyToOne
    @JoinColumn(name = "theme_id", referencedColumnName = "theme_id", nullable = false)
    private ThemeEntity themeByThemeId;

    @OneToMany(mappedBy = "testByTestId")
    private Collection<TestQuestionEntity> testQuestionsByTestId;

    @OneToMany(mappedBy = "testByTestId")
    private Collection<TestResultEntity> testResultsByTestId;

    public int getTestId() {
        return testId;
    }
    public void setTestId(int testId) {
        this.testId = testId;
    }
    public String getTestLabel() {
        return testLabel;
    }
    public void setTestLabel(String testLabel) {
        this.testLabel = testLabel;
    }
    public int getThemeId() {
        return themeId;
    }
    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }
    public Collection<EvaluationTestEntity> getEvaluationTestsByTestId() {
        return evaluationTestsByTestId;
    }
    public void setEvaluationTestsByTestId(Collection<EvaluationTestEntity> evaluationTestsByTestId) {
        this.evaluationTestsByTestId = evaluationTestsByTestId;
    }
    public ThemeEntity getThemeByThemeId() {
        return themeByThemeId;
    }
    public void setThemeByThemeId(ThemeEntity themeByThemeId) {
        this.themeByThemeId = themeByThemeId;
    }
    public Collection<TestQuestionEntity> getTestQuestionsByTestId() {
        return testQuestionsByTestId;
    }
    public void setTestQuestionsByTestId(Collection<TestQuestionEntity> testQuestionsByTestId) {
        this.testQuestionsByTestId = testQuestionsByTestId;
    }
    public Collection<TestResultEntity> getTestResultsByTestId() {
        return testResultsByTestId;
    }
    public void setTestResultsByTestId(Collection<TestResultEntity> testResultsByTestId) {
        this.testResultsByTestId = testResultsByTestId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestEntity that = (TestEntity) o;

        if (testId != that.testId) return false;
        if (themeId != that.themeId) return false;
        if (testLabel != null ? !testLabel.equals(that.testLabel) : that.testLabel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = testId;
        result = 31 * result + (testLabel != null ? testLabel.hashCode() : 0);
        result = 31 * result + themeId;
        return result;
    }
}
