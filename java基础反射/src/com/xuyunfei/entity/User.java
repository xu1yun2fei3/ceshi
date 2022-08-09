package com.xuyunfei.entity;

import lombok.Data;

@Data
public class User implements Runnable{
    private Integer user_id;
    private  String moblie;
    private  String password;
    private String create_time;
    private String update_time;

    @Override
    public void run() {
        System.out.println("User thread");
    }
}