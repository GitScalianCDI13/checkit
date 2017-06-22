package com.scalian.checkit.service.model;

import javax.print.attribute.IntegerSyntax;

public class UserBO {
    
    private Integer userId;
    private String userFirstname;
    private String userLastname;
    private Integer userAge;
    private Integer userExperiency;
    private Integer userProjects;
    private String userEmail;
    private String userPassword;
    private RoleBO role;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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

    public RoleBO getRole() {
        return role;
    }

    public void setRole(RoleBO role) {
        this.role = role;
    }
}
