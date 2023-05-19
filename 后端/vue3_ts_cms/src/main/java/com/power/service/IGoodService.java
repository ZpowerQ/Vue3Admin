package com.power.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.power.domain.Good;
import com.power.domain.utils.GoodSearch;

public interface IGoodService extends IService<Good> {
    //分页查询
    public IPage<Good> getPage(GoodSearch goodSearch, int currentpage, int size);
}
