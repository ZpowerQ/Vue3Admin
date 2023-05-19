package com.power.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.power.controller.utils.Result;
import com.power.domain.Good;
import com.power.domain.Userinfo;
import com.power.domain.utils.GoodSearch;
import com.power.domain.utils.UserinfoSearch;
import com.power.service.IGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private IGoodService goodService;

    //分页查询
    @PostMapping("/page/{currentpage}/{size}")
    Result getUserinfoPage(@RequestBody GoodSearch goodSearch, @PathVariable(name = "currentpage") int currentpage, @PathVariable int size) {
        IPage<Good> iPage = goodService.getPage(goodSearch,currentpage,size);
        List<Good> records = iPage.getRecords();
        long total = iPage.getTotal();
        List list = new ArrayList();
        list.add(records);
        list.add(total);
        return new Result(list, "获取数据成功");
    }

    //添加数据
    @PostMapping("/add")
    Result addGood(@RequestBody Good good){
        good.setCreatetime(new Date());
        good.setUpdatetime(new Date());
        boolean i = goodService.save(good);
        if (i == true) return new Result(true,"添加商品成功");
        return new Result(false,"添加商品失败");
    }
    //修改商品
    @PostMapping("/update")
    Result updateGood(@RequestBody Good good){
        good.setUpdatetime(new Date());
        boolean b = goodService.updateById(good);
        if(b==true) return new Result(true,"修改商品成功");
        return new Result(false,"修改商品失败");
    }
    //根据id删除商品
    @GetMapping("/delete/{id}")
    Result deleteUserinfo(@PathVariable int id){
        boolean i = goodService.removeById(id);
        if(i == true) return new Result(true,"删除商品成功");
        return new Result(false,"删除商品失败");
    }
    //删除多条数据
    @PostMapping("/delete")
    Result deleteMoreUserinfo(@RequestBody List<Good> goods){
        for(Good good:goods){
            goodService.removeById(good.getId());
        }
        return new Result(true,"删除多个商品成功");
    }
}
