package com.power.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.power.domain.Good;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodDao extends BaseMapper<Good> {
}
