package com.xuyunfei.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
//component 组成 加了注解之后spring就会在容器中创建对象
@Component
public class Admin {
    private Integer admin_id;
    private String username;
    private String password;
    private String img_url;
    private String name;
}
