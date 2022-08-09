package intefaceProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//根据接口创造对象,
public class MyInvocationHander implements InvocationHandler {
    private Object obj;

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("InvocationHander-invoke");
        return null;
    }
}
