package com.power.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.power.domain.Good_category;

import java.util.List;

public interface IGoodCategoryService extends IService<Good_category> {
    public List<Good_category> getAll();
}
