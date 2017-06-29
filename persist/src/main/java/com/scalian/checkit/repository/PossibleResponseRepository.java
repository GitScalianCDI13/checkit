package com.scalian.checkit.repository;

import com.scalian.checkit.model.PossibleResponseEntity;
import com.scalian.checkit.model.QuestionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PossibleResponseRepository extends CrudRepository<PossibleResponseEntity, Integer> {

    List<PossibleResponseEntity> findByQuestionAndPossibleResponseChecked(QuestionEntity questionEntity, Boolean data);
    List<PossibleResponseEntity> findAllByQuestionOrderByPossibleResponseId(QuestionEntity questionEntity);
}
