package com.power.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.power.dao.GoodDao;
import com.power.domain.Good;
import com.power.domain.Userinfo;
import com.power.domain.utils.GoodSearch;
import com.power.domain.utils.UserinfoSearch;
import com.power.service.IGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.lang.reflect.Field;


@Service
public class GoodServiceImpl extends ServiceImpl<GoodDao, Good> implements IGoodService {

    @Autowired
    private GoodDao goodDao;

    @Override
    public IPage<Good> getPage(GoodSearch goodSearch, int currentpage, int size) {
        boolean flag = true;
        try {
            for (Field f : goodSearch.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.get(goodSearch) != null) {
                    flag = false;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if(!flag){
            Integer id = goodSearch.getId();
            String name = goodSearch.getName();
            Integer state = goodSearch.getState();
            String starttime = goodSearch.getCreatetime().get(0);
            String endtime = goodSearch.getCreatetime().get(1);
            QueryWrapper<Good> qwr = new QueryWrapper<>();
            qwr.like(id != null, "id", id);
            qwr.like(name != null, "name", name);
            qwr.like(state != null, "state", state);
            qwr.between(starttime != null && endtime != null, "createtime", starttime, endtime);
            return goodDao.selectPage(new Page<>(currentpage,size),qwr);
        }
        return goodDao.selectPage(new Page<>(currentpage,size),null);
    }
}
