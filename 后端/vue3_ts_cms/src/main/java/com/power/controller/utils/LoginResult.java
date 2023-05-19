package com.power.controller.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginResult{
    private String token;
    private int id;
    public LoginResult(String token,int id){
        this.token = token;
        this.id = id;

    }
}
