package com.scalian.checkup.temp;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by betaspin on 19/06/17.
 */
@Entity
@Table(name = "evaluation", schema = "public", catalog = "CheckUp")
public class EvaluationEntity {
    @Id
    @Column(name = "evaluation_id", nullable = false)
    private int evaluationId;

    @Basic
    @Column(name = "evaluation_label", nullable = false, length = 255)
    private String evaluationLabel;

    @Basic
    @Column(name = "evaluation_job", nullable = true, length = 255)
    private String evaluationJob;


    private Collection<EvaluationTestEntity> evaluationTestsByEvaluationId;
    private Collection<ResultEvaluationEntity> resultEvaluationsByEvaluationId;


    public int getEvaluationId() {
        return evaluationId;
    }
    public void setEvaluationId(int evaluationId) {
        this.evaluationId = evaluationId;
    }
    public String getEvaluationLabel() {
        return evaluationLabel;
    }
    public void setEvaluationLabel(String evaluationLabel) {
        this.evaluationLabel = evaluationLabel;
    }
    public String getEvaluationJob() {
        return evaluationJob;
    }
    public void setEvaluationJob(String evaluationJob) {
        this.evaluationJob = evaluationJob;
    }

    @OneToMany(mappedBy = "evaluationByEvaluationId")
    public Collection<EvaluationTestEntity> getEvaluationTestsByEvaluationId() {
        return evaluationTestsByEvaluationId;
    }

    public void setEvaluationTestsByEvaluationId(Collection<EvaluationTestEntity> evaluationTestsByEvaluationId) {
        this.evaluationTestsByEvaluationId = evaluationTestsByEvaluationId;
    }

    @OneToMany(mappedBy = "evaluationByEvaluationId")
    public Collection<ResultEvaluationEntity> getResultEvaluationsByEvaluationId() {
        return resultEvaluationsByEvaluationId;
    }

    public void setResultEvaluationsByEvaluationId(Collection<ResultEvaluationEntity> resultEvaluationsByEvaluationId) {
        this.resultEvaluationsByEvaluationId = resultEvaluationsByEvaluationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EvaluationEntity that = (EvaluationEntity) o;

        if (evaluationId != that.evaluationId) return false;
        if (evaluationLabel != null ? !evaluationLabel.equals(that.evaluationLabel) : that.evaluationLabel != null)
            return false;
        if (evaluationJob != null ? !evaluationJob.equals(that.evaluationJob) : that.evaluationJob != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = evaluationId;
        result = 31 * result + (evaluationLabel != null ? evaluationLabel.hashCode() : 0);
        result = 31 * result + (evaluationJob != null ? evaluationJob.hashCode() : 0);
        return result;
    }
}
