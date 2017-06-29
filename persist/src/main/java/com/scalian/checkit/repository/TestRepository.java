package com.scalian.checkit.repository;

import com.scalian.checkit.model.EvaluationEntity;
import com.scalian.checkit.model.TestEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TestRepository extends CrudRepository<TestEntity, Integer> {
    List<TestEntity> findAllByEvaluationsEqualsOrderByTestId(EvaluationEntity evaluation);
}
