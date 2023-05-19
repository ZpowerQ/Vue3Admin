package com.power.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.power.dao.GoodCategoryDao;
import com.power.domain.Good_category;
import com.power.service.IGoodCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodCategoryServiceImpl extends ServiceImpl<GoodCategoryDao, Good_category> implements IGoodCategoryService {
    @Autowired
    private GoodCategoryDao goodCategoryDao;

    @Override
    public List<Good_category> getAll() {
        return goodCategoryDao.selectList(null);
    }
}
