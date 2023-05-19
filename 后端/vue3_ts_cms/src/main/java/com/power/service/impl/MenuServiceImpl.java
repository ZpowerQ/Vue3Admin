package com.power.service.impl;

import com.power.dao.MenuDao;
import com.power.domain.Second_menu;
import com.power.domain.User_menu;
import com.power.domain.utils.Menu;
import com.power.domain.utils.MenuSearch;
import com.power.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MenuServiceImpl implements IMenuService {
    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> getMenu(int userId) {
        List<Menu> menus = new ArrayList<Menu>();
        List<User_menu> user_FmenuId = menuDao.getFirstMenuId(userId);
        for (User_menu f : user_FmenuId) {
            Menu menu = new Menu();
            int firstId = f.getFirstMenuId();
            //设置index
            String id = menuDao.getFirstMenu(firstId).getIndex();
            menu.setIndex(id);
            //设置创建时间
            Date createtime = menuDao.getFirstMenu(firstId).getCreatetime();
            menu.setCreatetime(createtime);
            //设置状态
            String state = menuDao.getFirstMenu(firstId).getState();
            menu.setState(state);
            //设置一级菜单
            String firstName = menuDao.getFirstMenu(firstId).getName();
            menu.setName(firstName);
            //设置图标
            String icon = menuDao.getFirstMenu(firstId).getIcon();
            menu.setIcon(icon);
            //找出二级菜单
            List<Second_menu> second_menus = new ArrayList<>();
            List<User_menu> user_SmenusId = menuDao.getSecondMenuId(userId, firstId);
            for (User_menu s : user_SmenusId) {
                Second_menu second_menu = menuDao.getSecondMenu(s.getSecondMenuId());
                second_menus.add(second_menu);
            }
            menu.setChildren(second_menus);
            menus.add(menu);
        }
        return menus;
    }

    @Override
    public List<Menu> getMenuByTerm(MenuSearch menuSearch) {
        Integer id = menuSearch.getId();
        String name = menuSearch.getName();
        String state = menuSearch.getState();
        List<Menu> menus = getMenu(id);
        List<Menu> finialmenus = new ArrayList<>();
        if(name == null && state == null) {
            return menus;
        }
        for(Menu m:menus){
            if(name != null && state != null){
                if(m.getName().indexOf(name) != -1 && m.getState().indexOf(state) != -1){
                    finialmenus.add(m);
                }
            }else if(name != null){
                if(m.getName().indexOf(name) != -1){
                    finialmenus.add(m);
                }
            }else if(state != null){
                if(m.getState().indexOf(state) != -1){
                    finialmenus.add(m);
                }
            }
        }
        return finialmenus;
    }
}
