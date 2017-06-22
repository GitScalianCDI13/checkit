package com.scalian.checkit.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the result_evaluation database table.
 * 
 */
@Entity
@Table(name="result_evaluation")
@NamedQuery(name="ResultEvaluationEntity.findAll", query="SELECT r FROM ResultEvaluationEntity r")
public class ResultEvaluationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="result_evaluation_id")
	private Integer resultEvaluationId;

	@Column(name="result_evaluation_score")
	private Integer resultEvaluationScore;

	@Column(name="result_evaluation_time")
	private Integer resultEvaluationTime;

	//bi-directional many-to-one association to EvaluationEntity
	@ManyToOne
	@JoinColumn(name="evaluation_id")
	private EvaluationEntity evaluation;

	//bi-directional many-to-one association to UserEntity
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user;

	//bi-directional many-to-one association to TestResultEntity
	@OneToMany(mappedBy="resultEvaluation")
	private List<TestResultEntity> testResults;

	public ResultEvaluationEntity() {
	}

	public Integer getResultEvaluationId() {
		return this.resultEvaluationId;
	}

	public void setResultEvaluationId(Integer resultEvaluationId) {
		this.resultEvaluationId = resultEvaluationId;
	}

	public Integer getResultEvaluationScore() {
		return this.resultEvaluationScore;
	}

	public void setResultEvaluationScore(Integer resultEvaluationScore) {
		this.resultEvaluationScore = resultEvaluationScore;
	}

	public Integer getResultEvaluationTime() {
		return this.resultEvaluationTime;
	}

	public void setResultEvaluationTime(Integer resultEvaluationTime) {
		this.resultEvaluationTime = resultEvaluationTime;
	}

	public EvaluationEntity getEvaluation() {
		return this.evaluation;
	}

	public void setEvaluation(EvaluationEntity evaluation) {
		this.evaluation = evaluation;
	}

	public UserEntity getUser() {
		return this.user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<TestResultEntity> getTestResults() {
		return this.testResults;
	}

	public void setTestResults(List<TestResultEntity> testResults) {
		this.testResults = testResults;
	}

	public TestResultEntity addTestResult(TestResultEntity testResult) {
		getTestResults().add(testResult);
		testResult.setResultEvaluation(this);

		return testResult;
	}

	public TestResultEntity removeTestResult(TestResultEntity testResult) {
		getTestResults().remove(testResult);
		testResult.setResultEvaluation(null);

		return testResult;
	}

}