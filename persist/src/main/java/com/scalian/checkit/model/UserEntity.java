package com.scalian.checkit.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user", schema = "public", catalog = "CheckUp")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer userId;

	@Column(name="user_age")
	private Integer userAge;

	@Column(name="user_email")
	private String userEmail;

	@Column(name="user_experiency")
	private Integer userExperiency;

	@Column(name="user_firstname")
	private String userFirstname;

	@Column(name="user_lastname")
	private String userLastname;

	@Column(name="user_password")
	private String userPassword;

	@Column(name="user_projects")
	private Integer userProjects;

	//bi-directional many-to-one association to ResultEvaluationEntity
	@OneToMany(mappedBy="user")
	private List<ResultEvaluationEntity> resultEvaluations;

	//bi-directional many-to-one association to RoleEntity
	@ManyToOne
	@JoinColumn(name="role_id")
	private RoleEntity role;

	//bi-directional many-to-one association to UserResponseEntity
	@OneToMany(mappedBy="user")
	private List<UserResponseEntity> userResponses;

	public UserEntity() {
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserAge() {
		return this.userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Integer getUserExperiency() {
		return this.userExperiency;
	}

	public void setUserExperiency(Integer userExperiency) {
		this.userExperiency = userExperiency;
	}

	public String getUserFirstname() {
		return this.userFirstname;
	}

	public void setUserFirstname(String userFirstname) {
		this.userFirstname = userFirstname;
	}

	public String getUserLastname() {
		return this.userLastname;
	}

	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getUserProjects() {
		return this.userProjects;
	}

	public void setUserProjects(Integer userProjects) {
		this.userProjects = userProjects;
	}

	public List<ResultEvaluationEntity> getResultEvaluations() {
		return this.resultEvaluations;
	}

	public void setResultEvaluations(List<ResultEvaluationEntity> resultEvaluations) {
		this.resultEvaluations = resultEvaluations;
	}

	public ResultEvaluationEntity addResultEvaluation(ResultEvaluationEntity resultEvaluation) {
		getResultEvaluations().add(resultEvaluation);
		resultEvaluation.setUser(this);

		return resultEvaluation;
	}

	public ResultEvaluationEntity removeResultEvaluation(ResultEvaluationEntity resultEvaluation) {
		getResultEvaluations().remove(resultEvaluation);
		resultEvaluation.setUser(null);

		return resultEvaluation;
	}

	public RoleEntity getRole() {
		return this.role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public List<UserResponseEntity> getUserResponses() {
		return this.userResponses;
	}

	public void setUserResponses(List<UserResponseEntity> userResponses) {
		this.userResponses = userResponses;
	}

	public UserResponseEntity addUserRespons(UserResponseEntity userRespons) {
		getUserResponses().add(userRespons);
		userRespons.setUser(this);

		return userRespons;
	}

	public UserResponseEntity removeUserRespons(UserResponseEntity userRespons) {
		getUserResponses().remove(userRespons);
		userRespons.setUser(null);

		return userRespons;
	}

}