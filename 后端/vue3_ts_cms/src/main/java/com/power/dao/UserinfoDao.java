package com.power.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.power.domain.Userinfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserinfoDao extends BaseMapper<Userinfo> {
}
