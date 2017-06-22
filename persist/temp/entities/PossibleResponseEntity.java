package com.scalian.checkit.model;

import javax.persistence.*;

@Entity
@Table(name ="possible_response", schema = "public", catalog = "CheckUp")
public class PossibleResponseEntity {
    @Id
    @Column(name = "possible_response_id", nullable = false)
    private int possibleResponseId;

    @Basic
    @Column(name = "possible_response_label", nullable = false, length = 255)
    private String possibleResponseLabel;

    @Basic
    @Column(name = "possible_response_checked", nullable = false)
    private boolean possibleResponseChecked;

    @Basic
    @Column(name = "question_id", nullable = false)
    private int questionId;

    public int getPossibleResponseId() {
        return possibleResponseId;
    }
    public void setPossibleResponseId(int possibleResponseId) {
        this.possibleResponseId = possibleResponseId;
    }
    public String getPossibleResponseLabel() {
        return possibleResponseLabel;
    }
    public void setPossibleResponseLabel(String possibleResponseLabel) {
        this.possibleResponseLabel = possibleResponseLabel;
    }
    public boolean isPossibleResponseChecked() {
        return possibleResponseChecked;
    }
    public void setPossibleResponseChecked(boolean possibleResponseChecked) {
        this.possibleResponseChecked = possibleResponseChecked;
    }
    public int getQuestionId() {
        return questionId;
    }
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

//    @ManyToOne
//    @JoinColumn(name = "question_id", referencedColumnName = "question_id", nullable = false)
//    private QuestionEntity questionByQuestionId;
//    public QuestionEntity getQuestionByQuestionId() {
//        return questionByQuestionId;
//    }
//    public void setQuestionByQuestionId(QuestionEntity questionByQuestionId) {
//        this.questionByQuestionId = questionByQuestionId;
//    }
//
//    @OneToMany(mappedBy = "possibleResponseByPossibleResponseId")
//    private Collection<UserResponseEntity> userResponsesByPossibleResponseId;
//    public Collection<UserResponseEntity> getUserResponsesByPossibleResponseId() {
//        return userResponsesByPossibleResponseId;
//    }
//    public void setUserResponsesByPossibleResponseId(Collection<UserResponseEntity> userResponsesByPossibleResponseId) {
//        this.userResponsesByPossibleResponseId = userResponsesByPossibleResponseId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PossibleResponseEntity that = (PossibleResponseEntity) o;

        if (possibleResponseId != that.possibleResponseId) return false;
        if (possibleResponseChecked != that.possibleResponseChecked) return false;
        if (questionId != that.questionId) return false;
        if (possibleResponseLabel != null ? !possibleResponseLabel.equals(that.possibleResponseLabel) : that.possibleResponseLabel != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = possibleResponseId;
        result = 31 * result + (possibleResponseLabel != null ? possibleResponseLabel.hashCode() : 0);
        result = 31 * result + (possibleResponseChecked ? 1 : 0);
        result = 31 * result + questionId;
        return result;
    }
}
