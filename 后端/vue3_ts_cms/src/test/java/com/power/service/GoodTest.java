package com.power.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GoodTest {

    @Autowired
    private IGoodService iGoodService;

    @Test
    public void test(){
        System.out.println(iGoodService.list());
    }
}
