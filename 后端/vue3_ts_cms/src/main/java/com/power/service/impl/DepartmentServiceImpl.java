package com.power.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.power.dao.DepartmentDao;
import com.power.domain.Department;
import com.power.domain.Role;
import com.power.service.IDepartmantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentDao, Department> implements IDepartmantService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<Department> getlistByTerm(Department department) {
        boolean flag = true;
        try {
            for (Field f : department.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.get(department) != null) {
                    flag = false;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if(!flag){
            String name = department.getName();
            String state = department.getState();
            QueryWrapper<Department> qwr = new QueryWrapper<>();
            qwr.like(name != null, "name", name);
            qwr.like(state != null, "state", state);
            return departmentDao.selectList(qwr);
        }
        return departmentDao.selectList(null);
    }
}
