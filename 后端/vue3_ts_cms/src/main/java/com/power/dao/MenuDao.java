package com.power.dao;

import com.power.domain.First_menu;
import com.power.domain.Second_menu;
import com.power.domain.User_menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuDao {

//    @Select("select * from user_menu where userId = #{id}")
//    public List<User_menu> getUserMenu(int id);
//
//    @Select("select * from first_menu where id = #{id}")
//    public First_menu getFirstMenu(int id);
//
//    @Select("select * from second_menu where parentMenu = #{id}")
//    public List<Second_menu> getSecondMenu(int id);

    @Select("select distinct firstMenuId from user_menu where userId = #{id}")
    public List<User_menu> getFirstMenuId(int id);

    @Select("select * from first_menu where id = #{id}")
    public First_menu getFirstMenu(int id);

    @Select("select distinct secondMenuId from user_menu where userId = #{arg0} and firstMenuId = #{arg1}")
    public List<User_menu> getSecondMenuId(int id,int firstId);

    @Select("select * from second_menu where id = #{id}")
    public Second_menu getSecondMenu(int id);
}
