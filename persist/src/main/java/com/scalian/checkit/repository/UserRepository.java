package com.scalian.checkit.repository;

import com.scalian.checkit.model.UserEntity;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    List<UserEntity> findByUserLastname(String userLastName);
    List<UserEntity> findByUserEmail(String userEmail);
}
