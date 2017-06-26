package com.scalian.checkit.service.impl;

import com.scalian.checkit.model.TestEntity;
import com.scalian.checkit.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestBU {

    @Autowired
    public TestRepository testRepository;

    public TestEntity findOne(Integer id){
        return testRepository.findOne(id);
    }

    public Iterable<TestEntity> findAll(){
        return testRepository.findAll();
    }
}
