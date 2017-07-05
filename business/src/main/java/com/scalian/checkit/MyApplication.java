package com.scalian.checkit;

import com.scalian.checkit.model.TestEntity;
import com.scalian.checkit.service.impl.TestBU;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyApplication {

    @Autowired
    TestBU testBU;

    public static void main(String[] args) {
        //SpringApplication.run(MyApplication.class);
        ConfigurableApplicationContext context = SpringApplication.run(MyApplication.class);
        //MyApplication main = context.getBean(MyApplication.class);

        //main.test();
    }

    public void test(){
        for(TestEntity testEntity: testBU.findAll()){
            System.out.println(testEntity.getTestLabel());
        }
    }
}
