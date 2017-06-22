package com.scalian.checkit.repository;

import com.scalian.checkit.model.QuestionEntity;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<QuestionEntity, Integer> {

}
