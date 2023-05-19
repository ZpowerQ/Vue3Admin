package com.power.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.power.domain.Department;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentDao extends BaseMapper<Department> {
}
