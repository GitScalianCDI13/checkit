package com.scalian.checkit.repository;

import com.scalian.checkit.model.ResultEvaluationEntity;
import com.scalian.checkit.model.TestResultEntity;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TestResultRepository extends CrudRepository<TestResultEntity, Integer> {

    List<TestResultEntity> findAllByResultEvaluation(ResultEvaluationEntity resultEvaluationEntity);
}
