package com.scalian.checkit.service.mapping;

import com.scalian.checkit.model.RoleEntity;
import com.scalian.checkit.service.model.RoleBO;

public class RoleMapping {
    public static RoleBO mapRoleEntityToBO(RoleEntity roleEntity){
        RoleBO roleBO = new RoleBO();
        roleBO.setRoleId(roleEntity.getRoleId());
        roleBO.setRoleLabel(roleEntity.getRoleLabel());
        return roleBO;
    }

    public static RoleEntity mapRoleBOToEntity(RoleBO roleBO){
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(roleBO.getRoleId());
        roleEntity.setRoleLabel(roleBO.getRoleLabel());
        return roleEntity;
    }
}
