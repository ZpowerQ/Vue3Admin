package com.power.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Second_menu {
    private int id;
    private String name;
    private int parentmenu;
    private String url;
    @TableField("`index`")
    private String index;
    private String icon;
    private Date createtime;
    private String state;
}
