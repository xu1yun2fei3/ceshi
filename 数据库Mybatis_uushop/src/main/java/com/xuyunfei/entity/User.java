package com.xuyunfei.entity;

import lombok.Data;

@Data
public class User {
    private Integer user_id;
    private String mobile;
    private String password;
    private String create_time;
    private String update_time;
}
