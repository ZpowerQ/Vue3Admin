package com.power.service;

import com.power.domain.Good_cell_count;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GoodCelltest {

    @Autowired
    private IGoodCellCountService iGoodCellCountService;

    @Test
    public void test(){
        System.out.println(iGoodCellCountService.list());
    }
}
