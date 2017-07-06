package com.scalian.checkit.service.mapping;

import com.scalian.checkit.model.UserResponseEntity;
import com.scalian.checkit.service.model.UserResponseBO;

public class UserResponseMapping {

    public static UserResponseBO mapUserResponseEntityToBO(UserResponseEntity UserResponseEntity){
        UserResponseBO userResponseBO = new UserResponseBO();
        return userResponseBO;
    }
    public static UserResponseEntity mapUserResponseBOToEntity(UserResponseBO userResponseBO){
        UserResponseEntity userResponseEntity = new UserResponseEntity();
        return userResponseEntity;
    }
}
