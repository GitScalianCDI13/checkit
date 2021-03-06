package com.scalian.checkit.repository;

import com.scalian.checkit.model.QuestionEntity;
import com.scalian.checkit.model.TestResultEntity;
import com.scalian.checkit.model.UserResponseEntity;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserResponseRepository extends CrudRepository<UserResponseEntity, Integer> {
     List<UserResponseEntity> findByTestResultAndQuestion(TestResultEntity testResultEntity, QuestionEntity questionEntity);

     List<UserResponseEntity> findByTestResult(TestResultEntity testResultEntity);

}
