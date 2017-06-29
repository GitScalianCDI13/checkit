package com.scalian.checkit.repository;

import com.scalian.checkit.model.EvaluationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface EvaluationRepository extends CrudRepository<EvaluationEntity, Integer> {


}
