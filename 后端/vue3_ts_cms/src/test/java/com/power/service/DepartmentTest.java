package com.power.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DepartmentTest {

    @Autowired
    private IDepartmantService iDepartmantService;

    @Test
    public void test(){
        System.out.println(iDepartmantService.list());
    }
}
