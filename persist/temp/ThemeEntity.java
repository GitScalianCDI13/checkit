package com.scalian.checkup.temp;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "theme", schema = "public", catalog = "CheckUp")
public class ThemeEntity {
    @Id
    @Column(name = "theme_id", nullable = false)
    private int themeId;

    @Basic
    @Column(name = "theme_label", nullable = false, length = 255)
    private String themeLabel;

    @OneToMany(mappedBy = "themeByThemeId")
    private Collection<QuestionEntity> questionsByThemeId;

    @OneToMany(mappedBy = "themeByThemeId")
    private Collection<TestEntity> testsByThemeId;

    public int getThemeId() {
        return themeId;
    }
    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    public String getThemeLabel() {
        return themeLabel;
    }
    public void setThemeLabel(String themeLabel) {
        this.themeLabel = themeLabel;
    }
    public Collection<QuestionEntity> getQuestionsByThemeId() {
        return questionsByThemeId;
    }
    public void setQuestionsByThemeId(Collection<QuestionEntity> questionsByThemeId) {
        this.questionsByThemeId = questionsByThemeId;
    }
    public Collection<TestEntity> getTestsByThemeId() {
        return testsByThemeId;
    }
    public void setTestsByThemeId(Collection<TestEntity> testsByThemeId) {
        this.testsByThemeId = testsByThemeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ThemeEntity that = (ThemeEntity) o;

        if (themeId != that.themeId) return false;
        if (themeLabel != null ? !themeLabel.equals(that.themeLabel) : that.themeLabel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = themeId;
        result = 31 * result + (themeLabel != null ? themeLabel.hashCode() : 0);
        return result;
    }
}
