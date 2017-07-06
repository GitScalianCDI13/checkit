package com.scalian.checkit.service.mapping;

import com.scalian.checkit.model.TestResultEntity;
import com.scalian.checkit.service.model.TestResultBO;

public class TestResultMapping {

    public static TestResultBO mapTestResultEntityToBO(TestResultEntity testResultEntity){
        TestResultBO testResultBO = new TestResultBO();

        return testResultBO;
    }

    public static TestResultEntity mapTestResultBOToEntity(TestResultBO testResultBO){
        TestResultEntity testResultEntity = new TestResultEntity();


        return testResultEntity;
    }

}
