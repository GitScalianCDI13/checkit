package com.scalian.checkit.repository;

import com.scalian.checkit.model.TestResultEntity;

import org.springframework.data.repository.CrudRepository;

public interface TestResultRepository extends CrudRepository<TestResultEntity, Integer> {

}
