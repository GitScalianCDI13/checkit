package com.scalian.checkit.repository;

import com.scalian.checkit.model.QuestionEntity;
import com.scalian.checkit.model.TestEntity;
import com.scalian.checkit.model.TestResultEntity;
import com.scalian.checkit.model.UserResponseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<QuestionEntity, Integer> {

    List<QuestionEntity> findAllByTestsEqualsOrderByQuestionId(TestEntity testEntity);

}
