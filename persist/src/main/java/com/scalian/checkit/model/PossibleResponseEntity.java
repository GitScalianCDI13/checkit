package com.scalian.checkit.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the possible_response database table.
 * 
 */
@Entity
@Table(name="possible_response", schema = "public", catalog = "CheckUp")
@NamedQuery(name="PossibleResponseEntity.findAll", query="SELECT p FROM PossibleResponseEntity p")
public class PossibleResponseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="possible_response_id")
	private Integer possibleResponseId;

	@Column(name="possible_response_checked")
	private Boolean possibleResponseChecked;

	@Column(name="possible_response_label")
	private String possibleResponseLabel;

	//bi-directional many-to-one association to QuestionEntity
	@ManyToOne
	@JoinColumn(name="question_id")
	private QuestionEntity question;

	//bi-directional many-to-one association to UserResponseEntity
	@OneToMany(mappedBy="possibleResponse")
	private List<UserResponseEntity> userResponses;

	public PossibleResponseEntity() {
	}

	public Integer getPossibleResponseId() {
		return this.possibleResponseId;
	}

	public void setPossibleResponseId(Integer possibleResponseId) {
		this.possibleResponseId = possibleResponseId;
	}

	public Boolean getPossibleResponseChecked() {
		return this.possibleResponseChecked;
	}

	public void setPossibleResponseChecked(Boolean possibleResponseChecked) {
		this.possibleResponseChecked = possibleResponseChecked;
	}

	public String getPossibleResponseLabel() {
		return this.possibleResponseLabel;
	}

	public void setPossibleResponseLabel(String possibleResponseLabel) {
		this.possibleResponseLabel = possibleResponseLabel;
	}

	public QuestionEntity getQuestion() {
		return this.question;
	}

	public void setQuestion(QuestionEntity question) {
		this.question = question;
	}

	public List<UserResponseEntity> getUserResponses() {
		return this.userResponses;
	}

	public void setUserResponses(List<UserResponseEntity> userResponses) {
		this.userResponses = userResponses;
	}

	public UserResponseEntity addUserRespons(UserResponseEntity userRespons) {
		getUserResponses().add(userRespons);
		userRespons.setPossibleResponse(this);

		return userRespons;
	}

	public UserResponseEntity removeUserRespons(UserResponseEntity userRespons) {
		getUserResponses().remove(userRespons);
		userRespons.setPossibleResponse(null);

		return userRespons;
	}

}