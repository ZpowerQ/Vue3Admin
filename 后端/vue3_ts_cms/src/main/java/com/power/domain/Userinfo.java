package com.power.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Userinfo {
    private int id;
    private String username;
    private String password;
    private String role;
    private String phone;
    private String usericon;
    private Date createtime;
    private Date updatetime;
    private String state;
    private int online;
}
