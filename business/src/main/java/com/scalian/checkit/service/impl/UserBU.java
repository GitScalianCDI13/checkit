package com.scalian.checkit.service.impl;

//import UserEntity;
//import UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import com.scalian.checkit.model.UserEntity;
import com.scalian.checkit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBU {

    @Autowired
    public UserRepository userRepository;

    public List<UserEntity> findByUserEmail(String userEmail){
        return userRepository.findByUserEmail(userEmail);
    }

    public UserEntity addNewCandidat(String userLastname, String userFirstname, String userEmail){
        String userPassword = "test";
        return userRepository.save(new UserEntity(3, userFirstname, userLastname, userEmail, userPassword));
    }

    //    public void testCRUD(){
//
//        //UserEntity
//        //userRepository.save(new UserEntity(1, "GG", "LL", "gg@LL", "admin"));
//
//        UserEntity userEntity1 = userRepository.findOne(1);
//        System.out.println("UserEntity:findOne : " + userEntity1.getUserLastname());
//        userEntity1.setUserLastname("New Lamy");
//        userRepository.save(userEntity1);
//
//        for (UserEntity userEntity2 : userRepository.findAll()){
//            System.out.println("UserEntity:findAll : " + userEntity2.getUserId());
//        }
//
//        for (UserEntity userEntity3 : userRepository.findByUserLastname("Lamy")){
//            System.out.println("UserEntity:findByUserLastname : " + userEntity3.getUserFirstname());
//        }
//
//
//    }
}
