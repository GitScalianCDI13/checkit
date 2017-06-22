package com.scalian.checkit.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the theme database table.
 * 
 */
@Entity
@Table(name="theme", schema = "public", catalog = "CheckUp")
@NamedQuery(name="ThemeEntity.findAll", query="SELECT t FROM ThemeEntity t")
public class ThemeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="theme_id")
	private Integer themeId;

	@Column(name="theme_label")
	private String themeLabel;

	//bi-directional many-to-one association to QuestionEntity
	@OneToMany(mappedBy="theme")
	private List<QuestionEntity> questions;

	//bi-directional many-to-one association to TestEntity
	@OneToMany(mappedBy="theme")
	private List<TestEntity> tests;

	public ThemeEntity() {
	}

	public Integer getThemeId() {
		return this.themeId;
	}

	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}

	public String getThemeLabel() {
		return this.themeLabel;
	}

	public void setThemeLabel(String themeLabel) {
		this.themeLabel = themeLabel;
	}

	public List<QuestionEntity> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<QuestionEntity> questions) {
		this.questions = questions;
	}

	public QuestionEntity addQuestion(QuestionEntity question) {
		getQuestions().add(question);
		question.setTheme(this);

		return question;
	}

	public QuestionEntity removeQuestion(QuestionEntity question) {
		getQuestions().remove(question);
		question.setTheme(null);

		return question;
	}

	public List<TestEntity> getTests() {
		return this.tests;
	}

	public void setTests(List<TestEntity> tests) {
		this.tests = tests;
	}

	public TestEntity addTest(TestEntity test) {
		getTests().add(test);
		test.setTheme(this);

		return test;
	}

	public TestEntity removeTest(TestEntity test) {
		getTests().remove(test);
		test.setTheme(null);

		return test;
	}

}