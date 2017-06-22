package com.scalian.checkit.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the evaluation database table.
 * 
 */
@Entity
@Table(name="evaluation")
@NamedQuery(name="EvaluationEntity.findAll", query="SELECT e FROM EvaluationEntity e")
public class EvaluationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="evaluation_id")
	private Integer evaluationId;

	@Column(name="evaluation_job")
	private String evaluationJob;

	@Column(name="evaluation_label")
	private String evaluationLabel;

	//bi-directional many-to-many association to TestEntity
	@ManyToMany
	@JoinTable(
		name="evaluation_test"
		, joinColumns={
			@JoinColumn(name="evaluation_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="test_id")
			}
		)
	private List<TestEntity> tests;

	//bi-directional many-to-one association to ResultEvaluationEntity
	@OneToMany(mappedBy="evaluation")
	private List<ResultEvaluationEntity> resultEvaluations;

	public EvaluationEntity() {
	}

	public Integer getEvaluationId() {
		return this.evaluationId;
	}

	public void setEvaluationId(Integer evaluationId) {
		this.evaluationId = evaluationId;
	}

	public String getEvaluationJob() {
		return this.evaluationJob;
	}

	public void setEvaluationJob(String evaluationJob) {
		this.evaluationJob = evaluationJob;
	}

	public String getEvaluationLabel() {
		return this.evaluationLabel;
	}

	public void setEvaluationLabel(String evaluationLabel) {
		this.evaluationLabel = evaluationLabel;
	}

	public List<TestEntity> getTests() {
		return this.tests;
	}

	public void setTests(List<TestEntity> tests) {
		this.tests = tests;
	}

	public List<ResultEvaluationEntity> getResultEvaluations() {
		return this.resultEvaluations;
	}

	public void setResultEvaluations(List<ResultEvaluationEntity> resultEvaluations) {
		this.resultEvaluations = resultEvaluations;
	}

	public ResultEvaluationEntity addResultEvaluation(ResultEvaluationEntity resultEvaluation) {
		getResultEvaluations().add(resultEvaluation);
		resultEvaluation.setEvaluation(this);

		return resultEvaluation;
	}

	public ResultEvaluationEntity removeResultEvaluation(ResultEvaluationEntity resultEvaluation) {
		getResultEvaluations().remove(resultEvaluation);
		resultEvaluation.setEvaluation(null);

		return resultEvaluation;
	}

}