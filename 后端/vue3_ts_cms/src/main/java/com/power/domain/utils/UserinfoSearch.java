package com.power.domain.utils;

import lombok.Data;

import java.util.List;

//用户信息查询条件
@Data
public class UserinfoSearch {
    private Integer id;
    private String username;
    private String phone;
    private Integer state;
    private List<String> createtime;
    
}
