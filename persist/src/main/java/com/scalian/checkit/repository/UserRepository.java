package com.scalian.checkit.repository;

import com.scalian.checkit.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    List<UserEntity> findByUserLastname(String userLastName);
    List<UserEntity> findByUserEmail(String userEmail);
}
