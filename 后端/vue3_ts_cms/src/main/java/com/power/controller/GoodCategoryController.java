package com.power.controller;


import com.power.domain.Good_category;
import com.power.service.IGoodCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping("/good_category")
public class GoodCategoryController {
    @Autowired
    private IGoodCategoryService iGoodCategoryService;

    @GetMapping("/getAll")
    public List<Good_category> getAll(){
        return iGoodCategoryService.list();
    }

}
