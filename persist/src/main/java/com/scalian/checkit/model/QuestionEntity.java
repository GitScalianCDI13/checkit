package com.scalian.checkit.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the question database table.
 * 
 */
@Entity
@Table(name="question", schema = "public", catalog = "CheckUp")
@NamedQuery(name="QuestionEntity.findAll", query="SELECT q FROM QuestionEntity q")
public class QuestionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="question_id")
	private Integer questionId;

	@Column(name="question_label")
	private String questionLabel;

	@Column(name="question_content")
	private String questionContent;

	@Column(name="question_type")
	private Boolean questionType;

	//bi-directional many-to-one association to PossibleResponseEntity
	@OneToMany(mappedBy="question")
	private List<PossibleResponseEntity> possibleResponses;

	//bi-directional many-to-one association to ThemeEntity
	@ManyToOne
	@JoinColumn(name="theme_id")
	private ThemeEntity theme;

	//bi-directional many-to-many association to TestEntity
	@ManyToMany(mappedBy="questions")
	private List<TestEntity> tests;

	//bi-directional many-to-one association to UserResponseEntity
	@OneToMany(mappedBy="question")
	private List<UserResponseEntity> userResponses;

	public QuestionEntity() {
	}

	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQuestionLabel() {
		return this.questionLabel;
	}

	public void setQuestionLabel(String questionLabel) {
		this.questionLabel = questionLabel;
	}

	public Boolean getQuestionType() {
		return this.questionType;
	}

	public void setQuestionType(Boolean questionType) {
		this.questionType = questionType;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public List<PossibleResponseEntity> getPossibleResponses() {
		return this.possibleResponses;
	}

	public void setPossibleResponses(List<PossibleResponseEntity> possibleResponses) {
		this.possibleResponses = possibleResponses;
	}

	public PossibleResponseEntity addPossibleRespons(PossibleResponseEntity possibleRespons) {
		getPossibleResponses().add(possibleRespons);
		possibleRespons.setQuestion(this);

		return possibleRespons;
	}

	public PossibleResponseEntity removePossibleRespons(PossibleResponseEntity possibleRespons) {
		getPossibleResponses().remove(possibleRespons);
		possibleRespons.setQuestion(null);

		return possibleRespons;
	}

	public ThemeEntity getTheme() {
		return this.theme;
	}

	public void setTheme(ThemeEntity theme) {
		this.theme = theme;
	}

	public List<TestEntity> getTests() {
		return this.tests;
	}

	public void setTests(List<TestEntity> tests) {
		this.tests = tests;
	}

	public List<UserResponseEntity> getUserResponses() {
		return this.userResponses;
	}

	public void setUserResponses(List<UserResponseEntity> userResponses) {
		this.userResponses = userResponses;
	}

	public UserResponseEntity addUserRespons(UserResponseEntity userRespons) {
		getUserResponses().add(userRespons);
		userRespons.setQuestion(this);

		return userRespons;
	}

	public UserResponseEntity removeUserRespons(UserResponseEntity userRespons) {
		getUserResponses().remove(userRespons);
		userRespons.setQuestion(null);

		return userRespons;
	}

}