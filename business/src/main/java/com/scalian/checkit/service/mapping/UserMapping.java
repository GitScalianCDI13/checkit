package com.scalian.checkit.service.mapping;

import com.scalian.checkit.model.ResultEvaluationEntity;
import com.scalian.checkit.model.UserEntity;
import com.scalian.checkit.service.model.ResultEvaluationBO;
import com.scalian.checkit.service.model.UserBO;

import java.util.ArrayList;
import java.util.List;

public class UserMapping {
    public static UserBO mapUserEntityToBO(UserEntity userEntity) {
        UserBO userBO = new UserBO();
        userBO.setUserId(userEntity.getUserId());
        userBO.setRole(RoleMapping.mapRoleEntityToBO(userEntity.getRole()));
        userBO.setUserFirstname(userEntity.getUserFirstname());
        userBO.setUserLastname(userEntity.getUserLastname());
        userBO.setUserAge(userEntity.getUserAge());
        userBO.setUserEmail(userEntity.getUserEmail());
        userBO.setUserExperiency(userEntity.getUserExperiency());
        userBO.setUserProjects(userEntity.getUserProjects());
        userBO.setUserPassword(userEntity.getUserPassword());

/*        // Map des ResultEvaluationEntityToBO
        List<ResultEvaluationBO> resultEvaluationBOList = new ArrayList<>();
        List<ResultEvaluationEntity> resultEvaluationEntities = userEntity.getResultEvaluations();
        if(resultEvaluationEntities != null) {
            for (ResultEvaluationEntity resultEvaluationEntity : resultEvaluationEntities) {
                ResultEvaluationBO resultEvaluationBO = ResultEvaluationMapping.mapResultEvaluationEntityToBO(resultEvaluationEntity);
                resultEvaluationBOList.add(resultEvaluationBO);
            }
        }
        userBO.setResultEvaluations(resultEvaluationBOList);*/

        return userBO;
    }


    public static UserEntity mapUserBOToEntity(UserBO userBO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userBO.getUserId());
        userEntity.setRole(RoleMapping.mapRoleBOToEntity(userBO.getRole()));
        userEntity.setUserFirstname(userBO.getUserFirstname());
        userEntity.setUserLastname(userBO.getUserLastname());
        userEntity.setUserAge(userBO.getUserAge());
        userEntity.setUserEmail(userBO.getUserEmail());
        userEntity.setUserExperiency(userBO.getUserExperiency());
        userEntity.setUserProjects(userBO.getUserProjects());
        userEntity.setUserPassword(userBO.getUserPassword());

        // Map des ResultEvaluationBOToEntity
        List<ResultEvaluationEntity> resultEvaluationEntityList = new ArrayList<>();
        List<ResultEvaluationBO> resultEvaluationBOList = userBO.getResultEvaluations();
        if(resultEvaluationBOList != null) {
            for (ResultEvaluationBO resultEvaluationBO : resultEvaluationBOList) {
                ResultEvaluationEntity resultEvaluationEntity = ResultEvaluationMapping.mapEvaluationBOToEntity(resultEvaluationBO);
                resultEvaluationEntityList.add(resultEvaluationEntity);
            }
        }
        userEntity.setResultEvaluations(resultEvaluationEntityList);

        return userEntity;
    }


}