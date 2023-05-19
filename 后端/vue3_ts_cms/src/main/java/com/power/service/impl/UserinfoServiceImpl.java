package com.power.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.power.dao.UserinfoDao;
import com.power.domain.Userinfo;
import com.power.domain.utils.Account;
import com.power.domain.utils.UserinfoSearch;
import com.power.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class UserinfoServiceImpl extends ServiceImpl<UserinfoDao, Userinfo> implements IUserinfoService {

    @Autowired
    private UserinfoDao userinfoDao;


    @Override
    public Userinfo accountLogin(Account account) {
        String username = account.getUsername();
        String password = account.getPassword();
        QueryWrapper<Userinfo> qwr = new QueryWrapper<>();
        qwr.eq(username!=null,"username",username);
        qwr.eq(password!=null,"password",password);
        qwr.eq("state","1");
        return userinfoDao.selectOne(qwr);
    }

    //分页查询
    @Override
    public IPage<Userinfo> getPage(UserinfoSearch userinfoSearch,int currentpage,int size) {
        boolean flag = true;
        try {
            for (Field f : userinfoSearch.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.get(userinfoSearch) != null) {
                    flag = false;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if(!flag){
            Integer id = userinfoSearch.getId();
            String username = userinfoSearch.getUsername();
            String phone = userinfoSearch.getPhone();
            Integer state = userinfoSearch.getState();
            String starttime = userinfoSearch.getCreatetime().get(0);
            String endtime = userinfoSearch.getCreatetime().get(1);
            QueryWrapper<Userinfo> qwr = new QueryWrapper<>();
            qwr.like(id != null, "id", id);
            qwr.like(username != null, "username", username);
            qwr.like(phone != null, "phone", phone);
            qwr.like(state != null, "state", state);
            qwr.between(starttime != null && endtime != null, "createtime", starttime, endtime);
            return userinfoDao.selectPage(new Page<>(currentpage,size),qwr);
        }
        return userinfoDao.selectPage(new Page<>(currentpage,size),null);
    }
}
