package com.scalian.checkup.temp;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "user", schema = "public", catalog = "CheckUp")
public class UserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private int userId;

    @Basic
    @Column(name = "user_firstname", nullable = false, length = 255)
    private String userFirstname;

    @Basic
    @Column(name = "user_lastname", nullable = false, length = 255)
    private String userLastname;

    @Basic
    @Column(name = "user_age", nullable = true)
    private Integer userAge;

    @Basic
    @Column(name = "user_experiency", nullable = true)
    private Integer userExperiency;

    @Basic
    @Column(name = "user_projects", nullable = true)
    private Integer userProjects;

    @Basic
    @Column(name = "user_email", nullable = false, length = 255)
    private String userEmail;

    @Basic
    @Column(name = "user_password", nullable = false, length = 8)
    private String userPassword;

    @Basic
    @Column(name = "role_id", nullable = false)
    private int roleId;

    @OneToMany(mappedBy = "userByUserId")
    private Collection<ResultEvaluationEntity> resultEvaluationsByUserId;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
    private RoleEntity roleByRoleId;

    @OneToMany(mappedBy = "userByUserId")
    private Collection<UserResponseEntity> userResponsesByUserId;

    public UserEntity(){
        //Default constructor needed for JPA.
    }

    public UserEntity(Integer userId, String userFirstName, String userLastname) {
        this.userId = userId;
        this.userFirstname = userFirstName;
        this.userLastname = userLastname;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserFirstname() {
        return userFirstname;
    }
    public void setUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
    }
    public String getUserLastname() {
        return userLastname;
    }
    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }
    public Integer getUserAge() {
        return userAge;
    }
    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
    public Integer getUserExperiency() {
        return userExperiency;
    }
    public void setUserExperiency(Integer userExperiency) {
        this.userExperiency = userExperiency;
    }
    public Integer getUserProjects() {
        return userProjects;
    }
    public void setUserProjects(Integer userProjects) {
        this.userProjects = userProjects;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public int getRoleId() {
        return roleId;
    }
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    public Collection<ResultEvaluationEntity> getResultEvaluationsByUserId() {
        return resultEvaluationsByUserId;
    }
    public void setResultEvaluationsByUserId(Collection<ResultEvaluationEntity> resultEvaluationsByUserId) {
        this.resultEvaluationsByUserId = resultEvaluationsByUserId;
    }
    public RoleEntity getRoleByRoleId() {
        return roleByRoleId;
    }
    public void setRoleByRoleId(RoleEntity roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
    public Collection<UserResponseEntity> getUserResponsesByUserId() {
        return userResponsesByUserId;
    }
    public void setUserResponsesByUserId(Collection<UserResponseEntity> userResponsesByUserId) {
        this.userResponsesByUserId = userResponsesByUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userId != that.userId) return false;
        if (roleId != that.roleId) return false;
        if (userFirstname != null ? !userFirstname.equals(that.userFirstname) : that.userFirstname != null)
            return false;
        if (userLastname != null ? !userLastname.equals(that.userLastname) : that.userLastname != null) return false;
        if (userAge != null ? !userAge.equals(that.userAge) : that.userAge != null) return false;
        if (userExperiency != null ? !userExperiency.equals(that.userExperiency) : that.userExperiency != null)
            return false;
        if (userProjects != null ? !userProjects.equals(that.userProjects) : that.userProjects != null) return false;
        if (userEmail != null ? !userEmail.equals(that.userEmail) : that.userEmail != null) return false;
        if (userPassword != null ? !userPassword.equals(that.userPassword) : that.userPassword != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userFirstname != null ? userFirstname.hashCode() : 0);
        result = 31 * result + (userLastname != null ? userLastname.hashCode() : 0);
        result = 31 * result + (userAge != null ? userAge.hashCode() : 0);
        result = 31 * result + (userExperiency != null ? userExperiency.hashCode() : 0);
        result = 31 * result + (userProjects != null ? userProjects.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + roleId;
        return result;
    }
    
    @Override
    public String toString(){
        return String.format(
                "User[id=%d, firstName='%s', lastName='%s']",
                userId, userFirstname, userLastname);
    }
}
