package com.power.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Good {
    private Integer id;
    private String name;
    private Float originalprice;
    private Float currentprice;
    private String photo;
    private String state;
    private Integer stock;
    private Date createtime;
    private Date updatetime;
}
