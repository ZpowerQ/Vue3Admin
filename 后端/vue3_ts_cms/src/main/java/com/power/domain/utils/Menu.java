package com.power.domain.utils;

import com.power.domain.Second_menu;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Menu {
    private String index;
    private String name;
    private List<Second_menu> children;
    private String icon;
    private Date createtime;
    private String state;
}
