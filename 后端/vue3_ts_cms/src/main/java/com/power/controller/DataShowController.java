package com.power.controller;


import com.power.controller.utils.Result;
import com.power.service.IGoodCellCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class DataShowController {

    @Autowired
    private IGoodCellCountService iGoodCellCountService;

    @GetMapping("/cellcount")
    public Result getGoodCellCount(){
        return new Result(iGoodCellCountService.list(),"获取分类商品销量成功");
    }
}
