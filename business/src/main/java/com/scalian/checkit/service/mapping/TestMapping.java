package com.scalian.checkit.service.mapping;

import com.scalian.checkit.model.TestEntity;
import com.scalian.checkit.service.model.TestBO;

public class TestMapping {

    public static TestBO mapTestEntityToBO(TestEntity testEntity){
        TestBO testBO = new TestBO();

        return testBO;
    }

    public static TestEntity mapTestBOToEntity(TestBO testBO){
        TestEntity testEntity = new TestEntity();


        return testEntity;
    }

}
