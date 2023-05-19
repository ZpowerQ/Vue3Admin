package com.power.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.power.domain.Department;

import java.util.List;


public interface IDepartmantService extends IService<Department> {
    public List<Department> getlistByTerm(Department department);
}
