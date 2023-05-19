package com.power.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.power.domain.Second_menu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SecondMenuDao extends BaseMapper<Second_menu>{

}
