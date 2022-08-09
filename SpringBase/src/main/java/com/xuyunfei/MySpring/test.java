package com.xuyunfei.MySpring;

import com.xuyunfei.MySpring.MyApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 控制反转,将bean对象的创建权限交够spring*/
public class test {
    public static void main(String[] args) {
        //控制反转实现原理
        MyApplicationContext myApplicationContext = new MyApplicationContext("spring-ioc.xml");
        Object user = myApplicationContext.getBean("user");
        System.out.println(user);
    }
}