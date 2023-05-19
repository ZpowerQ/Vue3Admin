package com.power.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.power.domain.Role;
import com.power.domain.utils.RoleSearch;

import java.util.List;

public interface IRoleService extends IService<Role> {

    public List<Role> getlistByTerm(RoleSearch roleSearch);
}
