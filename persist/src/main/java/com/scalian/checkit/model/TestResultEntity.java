package com.scalian.checkit.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the test_result database table.
 * 
 */
@Entity
@Table(name="test_result")
@NamedQuery(name="TestResultEntity.findAll", query="SELECT t FROM TestResultEntity t")
public class TestResultEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="test_result_id")
	private Integer testResultId;

	@Column(name="test_result_score")
	private Integer testResultScore;

	@Column(name="test_result_time")
	private Integer testResultTime;

	//bi-directional many-to-one association to ResultEvaluationEntity
	@ManyToOne
	@JoinColumn(name="result_evaluation_id")
	private ResultEvaluationEntity resultEvaluation;

	//bi-directional many-to-one association to TestEntity
	@ManyToOne
	@JoinColumn(name="test_id")
	private TestEntity test;

	//bi-directional many-to-one association to UserResponseEntity
	@OneToMany(mappedBy="testResult")
	private List<UserResponseEntity> userResponses;

	public TestResultEntity() {
	}

	public Integer getTestResultId() {
		return this.testResultId;
	}

	public void setTestResultId(Integer testResultId) {
		this.testResultId = testResultId;
	}

	public Integer getTestResultScore() {
		return this.testResultScore;
	}

	public void setTestResultScore(Integer testResultScore) {
		this.testResultScore = testResultScore;
	}

	public Integer getTestResultTime() {
		return this.testResultTime;
	}

	public void setTestResultTime(Integer testResultTime) {
		this.testResultTime = testResultTime;
	}

	public ResultEvaluationEntity getResultEvaluation() {
		return this.resultEvaluation;
	}

	public void setResultEvaluation(ResultEvaluationEntity resultEvaluation) {
		this.resultEvaluation = resultEvaluation;
	}

	public TestEntity getTest() {
		return this.test;
	}

	public void setTest(TestEntity test) {
		this.test = test;
	}

	public List<UserResponseEntity> getUserResponses() {
		return this.userResponses;
	}

	public void setUserResponses(List<UserResponseEntity> userResponses) {
		this.userResponses = userResponses;
	}

	public UserResponseEntity addUserRespons(UserResponseEntity userRespons) {
		getUserResponses().add(userRespons);
		userRespons.setTestResult(this);

		return userRespons;
	}

	public UserResponseEntity removeUserRespons(UserResponseEntity userRespons) {
		getUserResponses().remove(userRespons);
		userRespons.setTestResult(null);

		return userRespons;
	}

}