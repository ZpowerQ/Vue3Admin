package com.power.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.power.controller.utils.Result;
import com.power.domain.Second_menu;
import com.power.domain.Userinfo;
import com.power.domain.utils.MenuSearch;
import com.power.service.IMenuService;
import com.power.service.ISecondMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private IMenuService iMenuService;

    @Autowired
    private ISecondMenuService secondMenuService;

    //根据用户id获取菜单
    @GetMapping("/{id}")
    public Result getUserMenu(@PathVariable int id){
        return new Result(iMenuService.getMenu(id),"获取菜单成功");
    }
    @PostMapping("/list")
    public Result getMenuByTerm(@RequestBody MenuSearch menuSearch){
        return new Result(iMenuService.getMenuByTerm(menuSearch),"获取菜单成功");
    }

    //添加用户
    @PostMapping("/add")
    Result addUserinfo(@RequestBody Second_menu second_menu){
        second_menu.setCreatetime(new Date());
        second_menu.setState("1");
        second_menu.setId(secondMenuService.list().size()+1);
        boolean i = secondMenuService.save(second_menu);
        if(i == true) return new Result(true,"添加菜单成功");
        return new Result(false,"添加菜单失败");
    }
    //修改菜单
    @PostMapping("/update")
    Result updateMenu(@RequestBody Second_menu second_menu){
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("parentmenu",second_menu.getParentmenu());
        boolean i = secondMenuService.update(second_menu,updateWrapper);
        if(i == true) return new Result(true,"修改菜单成功");
        return new Result(false,"修改菜单失败");
    }
}
