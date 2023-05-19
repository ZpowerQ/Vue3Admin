package com.power.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.power.controller.utils.Result;
import com.power.domain.Userinfo;
import com.power.domain.utils.UserinfoSearch;
import com.power.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/userinfo")
public class UserinfoController {
    @Autowired
    private IUserinfoService userinfoService;

    //根据条件获取获取所有数据
    @GetMapping("/list")
    Result getAllUserInfo(UserinfoSearch userinfoSearch) {
        return new Result(userinfoService.list(), "获取数据成功");
    }

    //根据id查询数据
    @GetMapping("/{id}")
    Result getUserinfoById(@PathVariable int id) {
        return new Result(userinfoService.getById(id), "获取数据成功");
    }

    //分页查询
    @PostMapping("/page/{currentpage}/{size}")
    Result getUserinfoPage(@RequestBody UserinfoSearch userinfoSearch, @PathVariable(name = "currentpage") int currentpage, @PathVariable int size) {
        IPage<Userinfo> iPage = userinfoService.getPage(userinfoSearch,currentpage,size);
        List<Userinfo> records = iPage.getRecords();
        long total = iPage.getTotal();
        List list = new ArrayList();
        list.add(records);
        list.add(total);
        return new Result(list, "获取数据成功");
    }

    //添加用户
    @PostMapping("/add")
    Result addUserinfo(@RequestBody Userinfo userinfo){
        userinfo.setCreatetime(new Date());
        userinfo.setUpdatetime(new Date());
        userinfo.setUsericon("http://localhost:8080/default.png");
        userinfo.setOnline(0);
        boolean i = userinfoService.save(userinfo);
        if(i == true) return new Result(true,"添加用户信息成功");
        return new Result(false,"添加用户信息失败");
    }
    //修改用户
    @PostMapping("/update")
    Result updateUserinfo(@RequestBody Userinfo userinfo){
        userinfo.setUpdatetime(new Date());
        boolean i = userinfoService.updateById(userinfo);
        if(i == true) return new Result(true,"修改用户成功");
        return new Result(false,"修改用户失败");
    }
    //根据id删除用户
    @GetMapping("/delete/{id}")
    Result deleteUserinfo(@PathVariable int id){
        boolean i = userinfoService.removeById(id);
        if(i == true) return new Result(true,"删除用户成功");
        return new Result(false,"删除用户失败");
    }
    //删除多条数据
    @PostMapping("/delete")
    Result deleteMoreUserinfo(@RequestBody List<Userinfo> userinfos){
        for(Userinfo userinfo:userinfos){
            userinfoService.removeById(userinfo.getId());
        }
        return new Result(true,"删除多条用户成功");
    }
}
