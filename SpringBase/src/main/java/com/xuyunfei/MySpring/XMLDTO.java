package com.xuyunfei.MySpring;

import lombok.Data;

import java.util.List;
import java.util.Map;

/*
* 对spring-iop 中一个bean的抽象
* */
@Data
public class XMLDTO {
    private String id;
    private String clazz;
    private List<Map<String,String>> properties;
}
