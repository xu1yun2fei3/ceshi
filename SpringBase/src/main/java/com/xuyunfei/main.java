package com.xuyunfei;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {
        //基于xml文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Object user = applicationContext.getBean("user");
        System.out.println("基于xml:"+user);

        //基于注解,不需要写xml,
        //param : bean所在的包名
        ApplicationContext annotation_ioc = new AnnotationConfigApplicationContext("com.xuyunfei.entity");
        //在基于注解方式中 类名的id 默认是首字母小写的类名
        Object admin = annotation_ioc.getBean("admin");
        System.out.println("基于注解:"+admin);

    }
}
