package com.power.controller;


import com.power.controller.utils.Result;
import com.power.domain.Department;
import com.power.domain.Role;
import com.power.domain.utils.RoleSearch;
import com.power.service.IDepartmantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private IDepartmantService iDepartmantService;

    @PostMapping("/list")
    public Result getRoleLIst(@RequestBody Department department){
        return new Result(iDepartmantService.getlistByTerm(department),"获取数据成功");
    }
    //添加数据
    @PostMapping("/add")
    Result addRole(@RequestBody Department department){
        department.setCreatetime(new Date());
        department.setUpdatetime(new Date());
        boolean i = iDepartmantService.save(department);
        if (i == true) return new Result(true,"添加部门成功");
        return new Result(false,"添加部门失败");
    }

    //修改部门
    @PostMapping("/update")
    Result updateRole(@RequestBody Department department){
        department.setUpdatetime(new Date());
        boolean b = iDepartmantService.updateById(department);
        if(b==true) return new Result(true,"修改部门成功");
        return new Result(false,"修改部门失败");
    }
    //根据id删除部门
    @GetMapping("/delete/{id}")
    Result deleteRole(@PathVariable int id){
        boolean i = iDepartmantService.removeById(id);
        if(i == true) return new Result(true,"删除部门成功");
        return new Result(false,"删除部门失败");
    }
}
