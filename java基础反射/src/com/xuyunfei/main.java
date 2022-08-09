package com.xuyunfei;

import com.xuyunfei.entity.User;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/*
* 从对象到类,获取类的属性,方法,构造器,接口,父类,所在的包
* */
public class main {
    public static void main(String[] args) throws Exception {
        //获取类的途径
        //通过包名
        Class cls = null;
        cls = Class.forName("com.xuyunfei.entity.User");
        //通过对象
        User user = new User();
        cls = user.getClass();
        //通过类名
        cls = User.class;

        //类的构造器,通过类的构造器可以创建对象
        Constructor constructor = cls.getConstructor();
        Object o = constructor.newInstance();
        System.out.println("反射创建对象"+o);
        //构造器的注解
        System.out.println("构造器注解的接收参数类型:"+constructor.getAnnotatedReceiverType());
        System.out.println("公开注解:"+constructor.getDeclaredAnnotations());
        //类的属性
        System.out.println("属性:"+cls.getFields());
        //类的方法
        System.out.println("方法:"+cls.getMethods());
        //类的接口
        System.out.println("接口"+cls.getInterfaces());
        //调用类的方法
        Method method = cls.getMethod("run");
        System.out.println("方法调用"+method.invoke(cls.getConstructor().newInstance()));
    }
}
