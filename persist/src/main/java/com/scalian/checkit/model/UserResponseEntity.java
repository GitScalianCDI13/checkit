package com.scalian.checkit.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_response database table.
 * 
 */
@Entity
@Table(name="user_response", schema = "public", catalog = "CheckUp")
@NamedQuery(name="UserResponseEntity.findAll", query="SELECT u FROM UserResponseEntity u")
public class UserResponseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_response_id")
	private Integer userResponseId;

	//bi-directional many-to-one association to PossibleResponseEntity
	@ManyToOne
	@JoinColumn(name="possible_response_id")
	private PossibleResponseEntity possibleResponse;

	//bi-directional many-to-one association to QuestionEntity
	@ManyToOne
	@JoinColumn(name="question_id")
	private QuestionEntity question;

	//bi-directional many-to-one association to TestResultEntity
	@ManyToOne
	@JoinColumn(name="test_result_id")
	private TestResultEntity testResult;

	//bi-directional many-to-one association to UserEntity
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user;

	public UserResponseEntity() {
	}

	public Integer getUserResponseId() {
		return this.userResponseId;
	}

	public void setUserResponseId(Integer userResponseId) {
		this.userResponseId = userResponseId;
	}

	public PossibleResponseEntity getPossibleResponse() {
		return this.possibleResponse;
	}

	public void setPossibleResponse(PossibleResponseEntity possibleResponse) {
		this.possibleResponse = possibleResponse;
	}

	public QuestionEntity getQuestion() {
		return this.question;
	}

	public void setQuestion(QuestionEntity question) {
		this.question = question;
	}

	public TestResultEntity getTestResult() {
		return this.testResult;
	}

	public void setTestResult(TestResultEntity testResult) {
		this.testResult = testResult;
	}

	public UserEntity getUser() {
		return this.user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}