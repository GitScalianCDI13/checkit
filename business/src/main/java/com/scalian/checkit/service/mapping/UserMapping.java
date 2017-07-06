package com.scalian.checkit.service.mapping;

import com.scalian.checkit.model.ResultEvaluationEntity;
import com.scalian.checkit.model.UserEntity;
import com.scalian.checkit.model.UserResponseEntity;
import com.scalian.checkit.service.model.ResultEvaluationBO;
import com.scalian.checkit.service.model.UserBO;
import com.scalian.checkit.service.model.UserResponseBO;

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

        // Map des ResultEvaluationEntityToBO
        List<ResultEvaluationBO> resultEvaluationBOList = new ArrayList<>();
        for (ResultEvaluationEntity resultEvaluationEntity : userEntity.getResultEvaluations()) {
            ResultEvaluationBO resultEvaluationBO = ResultEvaluationMapping.mapResultEvaluationEntityToBO(resultEvaluationEntity);
            resultEvaluationBOList.add(resultEvaluationBO);
        }
        userBO.setResultEvaluations(resultEvaluationBOList);

        // Map des UserResponseToBO
        List<UserResponseBO> userResponseBOList = new ArrayList<>();
        for (UserResponseEntity userResponseEntity : userEntity.getUserResponses()) {
            UserResponseBO userResponseBO = UserResponseMapping.mapUserResponseEntityToBO(userResponseEntity);
            userResponseBOList.add(userResponseBO);
        }
        userBO.setUserResponses(userResponseBOList);

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
        for (ResultEvaluationBO resultEvaluationBO : userBO.getResultEvaluations()) {
            ResultEvaluationEntity resultEvaluationEntity = ResultEvaluationMapping.mapEvaluationBOToEntity(resultEvaluationBO);
            resultEvaluationEntityList.add(resultEvaluationEntity);
        }
        userEntity.setResultEvaluations(resultEvaluationEntityList);

        // Map des UserResponseBOToEntity
        List<UserResponseEntity> userResponseEntityList = new ArrayList<>();
        for (UserResponseBO userResponseBO : userBO.getUserResponses()) {
            UserResponseEntity userResponseEntity = UserResponseMapping.mapUserResponseBOToEntity(userResponseBO);
            userResponseEntityList.add(userResponseEntity);
        }
        userEntity.setUserResponses(userResponseEntityList);

        return userEntity;
    }


}