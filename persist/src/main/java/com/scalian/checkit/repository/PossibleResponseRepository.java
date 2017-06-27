package com.scalian.checkit.repository;

import com.scalian.checkit.model.PossibleResponseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PossibleResponseRepository extends CrudRepository<PossibleResponseEntity, Integer> {

    List<PossibleResponseEntity> findByPossibleResponseChecked(Boolean data);

}
