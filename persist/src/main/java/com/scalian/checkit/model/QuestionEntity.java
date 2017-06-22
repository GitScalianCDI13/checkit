package com.scalian.checkit.model;

import javax.persistence.*;

@Entity
@Table(name = "question", schema = "public", catalog = "CheckUp")
public class QuestionEntity {
    @Id
    @Column(name = "question_id", nullable = false)
    private int questionId;

    @Basic
    @Column(name = "question_label", nullable = false, length = 255)
    private String questionLabel;

    @Basic
    @Column(name = "question_type", nullable = false)
    private boolean questionType;

    @Basic
    @Column(name = "theme_id", nullable = false)
    private int themeId;



    public int getQuestionId() {
        return questionId;
    }
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
    public String getQuestionLabel() {
        return questionLabel;
    }
    public void setQuestionLabel(String questionLabel) {
        this.questionLabel = questionLabel;
    }
    public boolean isQuestionType() {
        return questionType;
    }
    public void setQuestionType(boolean questionType) {
        this.questionType = questionType;
    }
    public int getThemeId() {
        return themeId;
    }
    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

//    @OneToMany(mappedBy = "questionByQuestionId")
//    private Collection<PossibleResponseEntity> possibleResponsesByQuestionId;
//    public Collection<PossibleResponseEntity> getPossibleResponsesByQuestionId() {
//        return possibleResponsesByQuestionId;
//    }
//    public void setPossibleResponsesByQuestionId(Collection<PossibleResponseEntity> possibleResponsesByQuestionId) {
//        this.possibleResponsesByQuestionId = possibleResponsesByQuestionId;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "theme_id", referencedColumnName = "theme_id", nullable = false)
//    private ThemeEntity themeByThemeId;
//    public ThemeEntity getThemeByThemeId() {
//        return themeByThemeId;
//    }
//    public void setThemeByThemeId(ThemeEntity themeByThemeId) {
//        this.themeByThemeId = themeByThemeId;
//    }
//
//    @OneToMany(mappedBy = "questionByQuestionId")
//    private Collection<TestQuestionEntity> testQuestionsByQuestionId;
//    public Collection<TestQuestionEntity> getTestQuestionsByQuestionId() {
//        return testQuestionsByQuestionId;
//    }
//    public void setTestQuestionsByQuestionId(Collection<TestQuestionEntity> testQuestionsByQuestionId) {
//        this.testQuestionsByQuestionId = testQuestionsByQuestionId;
//    }
//
//    @OneToMany(mappedBy = "questionByQuestionId")
//    private Collection<UserResponseEntity> userResponsesByQuestionId;
//    public Collection<UserResponseEntity> getUserResponsesByQuestionId() {
//        return userResponsesByQuestionId;
//    }
//    public void setUserResponsesByQuestionId(Collection<UserResponseEntity> userResponsesByQuestionId) {
//        this.userResponsesByQuestionId = userResponsesByQuestionId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionEntity that = (QuestionEntity) o;

        if (questionId != that.questionId) return false;
        if (questionType != that.questionType) return false;
        if (themeId != that.themeId) return false;
        if (questionLabel != null ? !questionLabel.equals(that.questionLabel) : that.questionLabel != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionId;
        result = 31 * result + (questionLabel != null ? questionLabel.hashCode() : 0);
        result = 31 * result + (questionType ? 1 : 0);
        result = 31 * result + themeId;
        return result;
    }
}
