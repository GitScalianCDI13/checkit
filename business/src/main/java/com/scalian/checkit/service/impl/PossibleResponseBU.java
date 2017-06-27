package com.scalian.checkit.service.impl;

import com.scalian.checkit.model.PossibleResponseEntity;
import com.scalian.checkit.repository.PossibleResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PossibleResponseBU {

    @Autowired
    public PossibleResponseRepository possibleResponseRepository;

    public PossibleResponseEntity findOne(Integer id){
        return possibleResponseRepository.findOne(id);
    }

    public List<PossibleResponseEntity> findByPossibleResponseChecked(Boolean data){
        return possibleResponseRepository.findByPossibleResponseChecked(data);
    }

}
