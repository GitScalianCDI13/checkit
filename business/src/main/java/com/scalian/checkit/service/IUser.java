package com.scalian.checkit.service;

import com.scalian.checkit.service.model.UserBO;

import java.util.List;

public interface IUser {
    List<UserBO> findByUserEmail(String userEmail);
    UserBO addCandidat(String userFirstname, String userLastname, String userEmail);
}
