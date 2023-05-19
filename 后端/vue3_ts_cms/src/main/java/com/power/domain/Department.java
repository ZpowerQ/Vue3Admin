package com.power.domain;


import lombok.Data;

import java.util.Date;

@Data
public class Department {
    private Integer id;
    private String name;
    private String state;
    private Date createtime;
    private Date updatetime;
}
