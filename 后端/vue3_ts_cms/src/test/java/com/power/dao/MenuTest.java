package com.power.dao;

import com.power.domain.Second_menu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MenuTest {
    @Autowired
    private MenuDao menuDao;

    @Autowired
    private SecondMenuDao secondMenuDao;

    @Test
    public void test(){
        System.out.println(secondMenuDao.selectList(null));
    }

}
