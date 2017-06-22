package com.scalian.checkit.repository;

import com.scalian.checkit.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    List<UserEntity> findByUserLastname(String userLastName);
    List<UserEntity> findByUserEmail(String userEmail);
}
