package intefaceProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        InvocationHandler myhandler = new MyInvocationHander();

        UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(User.class.getClassLoader(),User.class.getInterfaces(),myhandler);
        userMapper.test();
        userMapper.test2();
    }
}
