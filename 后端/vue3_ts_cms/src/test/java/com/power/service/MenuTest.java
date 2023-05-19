package com.power.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MenuTest {
    @Autowired
    private IMenuService iMenuService;

    @Autowired
    private ISecondMenuService iSecondMenuService;

    @Test
    public void test(){
        System.out.println(iMenuService.getMenu(1));
    }

    @Test
    public void test1(){
//        System.out.println(iSecondMenuService.save(new Second_menu()));
    }
}
