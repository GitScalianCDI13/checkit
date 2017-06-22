package com.scalian.checkup.temp;

import com.scalian.checkup.model.UserEntity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by betaspin on 19/06/17.
 */
@Entity
@Table(name = "role", schema = "public", catalog = "CheckUp")
public class RoleEntity {
    private int roleId;
    private String roleLabel;
    private Collection<UserEntity> usersByRoleId;

    @Id
    @Column(name = "role_id", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "role_label", nullable = true, length = 255)
    public String getRoleLabel() {
        return roleLabel;
    }

    public void setRoleLabel(String roleLabel) {
        this.roleLabel = roleLabel;
    }

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

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<UserEntity> getUsersByRoleId() {
        return usersByRoleId;
    }

    public void setUsersByRoleId(Collection<UserEntity> usersByRoleId) {
        this.usersByRoleId = usersByRoleId;
    }
}
