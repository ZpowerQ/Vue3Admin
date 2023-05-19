package com.power.service;

import com.power.domain.utils.UserinfoSearch;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserinfoTest {

    @Autowired
    private IUserinfoService iUserinfoService;

    //分页查询测试
    @Test
    public void test(){
        UserinfoSearch userinfoSearch = new UserinfoSearch();
        System.out.println(iUserinfoService.getPage(userinfoSearch,1,5).getRecords());
    }

}
