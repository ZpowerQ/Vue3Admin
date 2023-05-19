package com.power.controller;

import com.power.controller.utils.CreateToken;
import com.power.controller.utils.LoginResult;
import com.power.controller.utils.Result;
import com.power.domain.Userinfo;
import com.power.domain.utils.Account;
import com.power.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private IUserinfoService iUserinfoService;

    @PostMapping("/account")
    public Result login(@RequestBody Account account){
        Userinfo userinfo = iUserinfoService.accountLogin(account);
        if(userinfo != null){
            String token = CreateToken.getToken(userinfo);
            return new Result(new LoginResult(token,userinfo.getId()),"登录成功");
        }
        return new Result(null,"登录失败");
    }
    @PostMapping("/parse")
    public Result parseToken(HttpServletRequest request){
        String token = request.getHeader("Authorization").substring(7);
        String[] info = CreateToken.parseToken(token);
        if(info.length != 0){
            Userinfo user = new Userinfo();
            user.setId(Integer.parseInt(info[0]));
            user.setUsername(info[1]);
            String newToken = CreateToken.getToken(user);
            return new Result(new LoginResult(newToken, user.getId()),"token有效");
        }
        return new Result(null,"token无效");
    }
}
