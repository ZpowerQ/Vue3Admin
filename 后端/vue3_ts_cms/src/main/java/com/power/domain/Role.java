package com.power.domain;


import lombok.Data;

import java.util.Date;

@Data
public class Role {
    private Integer id;
    private String name;
    private String intro;
    private Date createtime;
    private Date updatetime;
}
