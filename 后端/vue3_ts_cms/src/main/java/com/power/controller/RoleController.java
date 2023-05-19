package com.power.controller;


import com.power.controller.utils.Result;
import com.power.domain.Good;
import com.power.domain.Role;
import com.power.domain.utils.RoleSearch;
import com.power.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/list")
    public Result getRoleLIst(@RequestBody RoleSearch roleSearch){
        return new Result(roleService.getlistByTerm(roleSearch),"获取数据成功");
    }

    //添加数据
    @PostMapping("/add")
    Result addRole(@RequestBody Role role){
        role.setCreatetime(new Date());
        role.setUpdatetime(new Date());
        boolean i = roleService.save(role);
        if (i == true) return new Result(true,"添加角色成功");
        return new Result(false,"添加角色失败");
    }
    //修改商品
    @PostMapping("/update")
    Result updateRole(@RequestBody Role role){
        role.setUpdatetime(new Date());
        boolean b = roleService.updateById(role);
        if(b==true) return new Result(true,"修改角色成功");
        return new Result(false,"修改角色失败");
    }
    //根据id删除商品
    @GetMapping("/delete/{id}")
    Result deleteRole(@PathVariable int id){
        boolean i = roleService.removeById(id);
        if(i == true) return new Result(true,"删除角色成功");
        return new Result(false,"删除角色失败");
    }
    //删除多条数据
    @PostMapping("/delete")
    Result deleteMoreRole(@RequestBody List<Role> roles){
        for(Role role:roles){
            roleService.removeById(role.getId());
        }
        return new Result(true,"删除多个角色成功");
    }
}
