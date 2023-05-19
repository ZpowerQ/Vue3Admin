package com.power.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.power.domain.Userinfo;
import com.power.domain.utils.Account;
import com.power.domain.utils.UserinfoSearch;

import java.util.List;

public interface IUserinfoService extends IService<Userinfo> {

    public Userinfo accountLogin(Account account);

    //分页查询
    public IPage<Userinfo> getPage(UserinfoSearch userinfoSearch,int currentpage,int size);
}
