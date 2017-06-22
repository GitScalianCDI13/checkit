package com.scalian.checkit.service.impl;

//import UserEntity;
//import UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import com.scalian.checkit.model.RoleEntity;
import com.scalian.checkit.model.UserEntity;
import com.scalian.checkit.repository.UserRepository;
import com.scalian.checkit.service.ICRUD;
import com.scalian.checkit.service.IUser;
import com.scalian.checkit.service.mapping.UserMapping;
import com.scalian.checkit.service.model.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserBU implements ICRUD<UserBO>, IUser {

    @Autowired
    public UserRepository userRepository;

    @Override
    public UserBO findOne(Integer id) {
        return null;
    }

    @Override
    public List<UserBO> findAll() {
        return null;
    }

    @Override
    public UserBO create(UserBO data) {
        return null;
    }

    @Override
    public UserBO update(UserBO data) {
        return null;
    }

    @Override
    public UserBO save(UserBO data) {
        return null;
    }

    @Override
    public UserBO delete(Integer id) {
        return null;
    }

    @Override
    public List<UserBO> findByUserEmail(String userEmail){

        UserEntity user = userRepository.findOne(16);

        List<UserEntity> data = userRepository.findByUserEmail(userEmail);

        List<UserBO> users = new ArrayList<>();

        for(UserEntity userEntity: data){
            users.add(UserMapping.mapUserEntityToBO(userEntity));
        }
        return users;
    }

    public UserEntity addCandidat(String userLastname, String userFirstname, String userEmail){

        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(3);

        UserEntity userEntity = new UserEntity();
        userEntity.setRole(roleEntity);
        userEntity.setUserFirstname(userFirstname);
        userEntity.setUserLastname(userLastname);
        userEntity.setUserEmail(userEmail);
        userEntity.setUserPassword("test");

        return userRepository.save(userEntity);
    }
}
