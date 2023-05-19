package com.power.controller.utils;

import lombok.Data;

@Data
public class Result {
    private boolean flag;
    private Object data;
    private String msg;

    public Result(Object date){
        this.flag = true;
        this.data = date;
    }
    public Result(Object data,String msg){
        this.flag = true;
        this.data = data;
        this.msg = msg;
    }
}
