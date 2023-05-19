package com.power.domain.utils;

import lombok.Data;

import java.util.List;

@Data
public class GoodSearch {
    private Integer id;
    private String name;
    private Integer state;
    private List<String> createtime;
}
