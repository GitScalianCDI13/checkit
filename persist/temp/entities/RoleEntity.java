package com.scalian.checkit.model;

import javax.persistence.*;

@Entity
@Table(name = "role", schema = "public", catalog = "CheckUp")
public class RoleEntity {
    @Id
    @Column(name = "role_id", nullable = false)
    private int roleId;

    @Basic
    @Column(name = "role_label", nullable = true, length = 255)
    private String roleLabel;

    public int getRoleId() {
        return roleId;
    }
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    public String getRoleLabel() {
        return roleLabel;
    }
    public void setRoleLabel(String roleLabel) {
        this.roleLabel = roleLabel;
    }

//    @OneToMany(mappedBy = "roleByRoleId")
//    private Collection<UserEntity> usersByRoleId;
//    public Collection<UserEntity> getUsersByRoleId() {
//        return usersByRoleId;
//    }
//    public void setUsersByRoleId(Collection<UserEntity> usersByRoleId) {
//        this.usersByRoleId = usersByRoleId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (roleId != that.roleId) return false;
        if (roleLabel != null ? !roleLabel.equals(that.roleLabel) : that.roleLabel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + (roleLabel != null ? roleLabel.hashCode() : 0);
        return result;
    }


}
