package com.power.service;

import com.power.domain.utils.Menu;
import com.power.domain.utils.MenuSearch;

import java.util.List;

public interface IMenuService {

    //根据用户id获取菜单
    public List<Menu> getMenu(int userId);

    //根据条件查询菜单
    public List<Menu> getMenuByTerm(MenuSearch menuSearch);
}
