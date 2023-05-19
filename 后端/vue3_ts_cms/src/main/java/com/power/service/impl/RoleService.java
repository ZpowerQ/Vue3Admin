package com.power.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.power.dao.RoleDao;
import com.power.domain.Role;
import com.power.domain.utils.RoleSearch;
import com.power.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class RoleService extends ServiceImpl<RoleDao, Role> implements IRoleService {

    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> getlistByTerm(RoleSearch roleSearch) {
        boolean flag = true;
        try {
            for (Field f : roleSearch.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.get(roleSearch) != null) {
                    flag = false;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if(!flag){
            Integer id = roleSearch.getId();
            String name = roleSearch.getName();
            String intro = roleSearch.getIntro();
            String starttime = roleSearch.getStarttime();
            String endtime = roleSearch.getEndtime();
            QueryWrapper<Role> qwr = new QueryWrapper<>();
            qwr.like(id != null, "id", id);
            qwr.like(name != null, "name", name);
            qwr.like(intro != null, "intro", intro);
            qwr.between(starttime != null && endtime != null, "createtime", starttime, endtime);
            return roleDao.selectList(qwr);
        }
        return roleDao.selectList(null);
    }
}
