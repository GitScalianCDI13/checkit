package com.scalian.checkit.repository;

import com.scalian.checkit.model.TestEntity;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<TestEntity, Integer> {

}
