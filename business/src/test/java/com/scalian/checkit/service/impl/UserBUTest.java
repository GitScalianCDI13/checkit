package com.scalian.checkit.service.impl;

import com.scalian.checkit.model.RoleEntity;
import com.scalian.checkit.model.UserEntity;
import com.scalian.checkit.repository.UserRepository;
import com.scalian.checkit.service.mapping.UserMapping;
import com.scalian.checkit.service.model.RoleBO;
import com.scalian.checkit.service.model.UserBO;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserBUTest {

    @InjectMocks
    private UserBU userBU = new UserBU();

    @Mock
    private UserRepository userRepository;

    @Test
    // User exists
    public void findOne1() throws Exception {
        // Expected objects
        Integer userId = 1;
        UserBO userPersisted = new UserBO();
        RoleBO roleBO = new RoleBO();
        roleBO.setRoleId(2);
        roleBO.setRoleLabel("Admin");
        userPersisted.setUserId(userId);
        userPersisted.setRole(roleBO);

        // Mockito expectations
        when(userRepository.findOne(userId)).thenReturn(UserMapping.mapUserBOToEntity(userPersisted));

        // Execute the method being tested
        UserBO userBO = userBU.findOne(userId);

        // Validation
        assertNotNull(userBO);
        Assert.assertEquals(userId, userBO.getUserId());

        verify(userRepository).findOne(userId);
    }

    @Test
    // User doesn't exist
    public void findOne2() throws Exception {
        Integer userId = 0;

        // Mockito expectations
        when(userRepository.findOne(userId)).thenReturn(null);

        // Execute the method being tested
        UserBO userBO = userBU.findOne(userId);

        // Validation
        assertNull(userBO);

        verify(userRepository).findOne(userId);
    }

    @Test
    public void findAll() throws Exception {
        // Expected List
        List<UserBO> usersList = new ArrayList<>();
        List<UserEntity> usersListPersisted = new ArrayList<>();

        RoleBO roleBO = new RoleBO();
        roleBO.setRoleId(2);
        roleBO.setRoleLabel("Admin");

        UserBO user1 = new UserBO();
        user1.setUserId(1);
        user1.setRole(roleBO);
        usersList.add(user1);

        UserBO user2 = new UserBO();
        user2.setUserId(2);
        user2.setRole(roleBO);
        usersList.add(user2);

        UserBO user3 = new UserBO();
        user3.setUserId(3);
        user3.setRole(roleBO);
        usersList.add(user3);

        for (UserBO userBO : usersList) {
            usersListPersisted.add(UserMapping.mapUserBOToEntity(userBO));
        }

        // Mockito expectations
        when(userRepository.findAll()).thenReturn(usersListPersisted);

        // Execute the method being tested
        List<UserBO> userBOList = userBU.findAll();

        // Validation
        assertNotNull(userBOList);
        assertArrayEquals(usersList.toArray(), userBOList.toArray());

        verify(userRepository).findAll();
    }


//    @Test
//    public void create() throws Exception {
//    }
//
//    @Test
//    public void update() throws Exception {
//    }
//
//    @Test
//    public void save() throws Exception {
//    }
//
//    @Test
//    public void delete() throws Exception {
//    }

    @Test
    public void findByUserEmail() throws Exception {
        // Expected objects
        String userEmail = "jlamy@test.fr";
        UserBO userExpected = new UserBO();
        RoleBO roleBO = new RoleBO();
        roleBO.setRoleId(3);
        roleBO.setRoleLabel("Candidat");
        userExpected.setUserEmail(userEmail);
        userExpected.setRole(roleBO);

        List<UserBO> userExpextedList = new ArrayList<>();
        userExpextedList.add(userExpected);

        List<UserEntity> userEntityList = new ArrayList<>();
        for (UserBO userBO : userExpextedList) {
            userEntityList.add(UserMapping.mapUserBOToEntity(userBO));
        }

        // Mockito expectations
        when(userRepository.findByUserEmail(userEmail)).thenReturn(userEntityList);

        // Execute the method being tested
        List<UserBO> userBOs = userBU.findByUserEmail(userEmail);

        // Validation
        assertNotNull(userBOs);
        assertArrayEquals(userExpextedList.toArray(), userBOs.toArray());

        verify(userRepository).findByUserEmail(userEmail);


    }

    @Test
    public void addCandidat() throws Exception {
        // Expected objects
        String userFirstname = "Jérôme";
        String userLastname = "Lamy";
        String userEmail = "jlamy@test.fr";

        Integer userId = 1;

        UserBO userExpected = new UserBO();
        RoleBO roleBO = new RoleBO();
        roleBO.setRoleId(3);
        roleBO.setRoleLabel("Candidat");
        userExpected.setUserId(userId);
        userExpected.setUserFirstname(userFirstname);
        userExpected.setUserLastname(userLastname);
        userExpected.setUserEmail(userEmail);
        userExpected.setRole(roleBO);

        UserEntity userEntity = UserMapping.mapUserBOToEntity(userExpected);

        // Mockito expectations
        when(userRepository.save(userEntity)).thenReturn(userEntity);

        // Execute the method being tested
        UserBO userBO = userBU.addCandidat(userFirstname, userLastname, userEmail);

        // Validation
        assertNotNull(userBO);
        assertEquals(userExpected.toString(), userBO.toString());

        verify(userRepository).findOne(userId);
    }

}