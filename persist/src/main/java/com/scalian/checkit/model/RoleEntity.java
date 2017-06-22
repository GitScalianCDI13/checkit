package com.scalian.checkit.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name="role")
@NamedQuery(name="RoleEntity.findAll", query="SELECT r FROM RoleEntity r")
public class RoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="role_id")
	private Integer roleId;

	@Column(name="role_label")
	private String roleLabel;

	//bi-directional many-to-one association to UserEntity
	@OneToMany(mappedBy="role")
	private List<UserEntity> users;

	public RoleEntity() {
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleLabel() {
		return this.roleLabel;
	}

	public void setRoleLabel(String roleLabel) {
		this.roleLabel = roleLabel;
	}

	public List<UserEntity> getUsers() {
		return this.users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public UserEntity addUser(UserEntity user) {
		getUsers().add(user);
		user.setRole(this);

		return user;
	}

	public UserEntity removeUser(UserEntity user) {
		getUsers().remove(user);
		user.setRole(null);

		return user;
	}

}