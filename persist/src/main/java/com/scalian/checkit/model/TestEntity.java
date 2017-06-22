package com.scalian.checkit.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the test database table.
 * 
 */
@Entity
@Table(name="test")
@NamedQuery(name="TestEntity.findAll", query="SELECT t FROM TestEntity t")
public class TestEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="test_id")
	private Integer testId;

	@Column(name="test_label")
	private String testLabel;

	//bi-directional many-to-many association to EvaluationEntity
	@ManyToMany(mappedBy="tests")
	private List<EvaluationEntity> evaluations;

	//bi-directional many-to-many association to QuestionEntity
	@ManyToMany
	@JoinTable(
		name="test_question"
		, joinColumns={
			@JoinColumn(name="test_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="question_id")
			}
		)
	private List<QuestionEntity> questions;

	//bi-directional many-to-one association to ThemeEntity
	@ManyToOne
	@JoinColumn(name="theme_id")
	private ThemeEntity theme;

	//bi-directional many-to-one association to TestResultEntity
	@OneToMany(mappedBy="test")
	private List<TestResultEntity> testResults;

	public TestEntity() {
	}

	public Integer getTestId() {
		return this.testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public String getTestLabel() {
		return this.testLabel;
	}

	public void setTestLabel(String testLabel) {
		this.testLabel = testLabel;
	}

	public List<EvaluationEntity> getEvaluations() {
		return this.evaluations;
	}

	public void setEvaluations(List<EvaluationEntity> evaluations) {
		this.evaluations = evaluations;
	}

	public List<QuestionEntity> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<QuestionEntity> questions) {
		this.questions = questions;
	}

	public ThemeEntity getTheme() {
		return this.theme;
	}

	public void setTheme(ThemeEntity theme) {
		this.theme = theme;
	}

	public List<TestResultEntity> getTestResults() {
		return this.testResults;
	}

	public void setTestResults(List<TestResultEntity> testResults) {
		this.testResults = testResults;
	}

	public TestResultEntity addTestResult(TestResultEntity testResult) {
		getTestResults().add(testResult);
		testResult.setTest(this);

		return testResult;
	}

	public TestResultEntity removeTestResult(TestResultEntity testResult) {
		getTestResults().remove(testResult);
		testResult.setTest(null);

		return testResult;
	}

}