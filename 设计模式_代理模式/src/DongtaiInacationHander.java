import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//根据委托类生成代理类，代理类来执行一些通用的方法
//InvocationHandler作用就是，当代理对象的原本方法被调用的时候，会绑定执行一个方法，这个方法就是InvocationHandler里面定义的内容，同时会替代原本方法的结果返回。
//        InvocationHandler接收三个参数
//        proxy，代理后的实例对象。
//        method，对象被调用方法。
//        args，调用时的参数。
class DongtaiInacationHander implements InvocationHandler {
    //1.实现InvocationHandler

    //2.注入委托对象
    private Object obj = null;

    //3。生成代理对象,
    public Object bind(Object obj){
        this.obj = obj;
        //参数意义：this 获取this的类加载器 和 接口
//        loader: 用哪个类加载器去加载代理对象
//        interfaces:动态代理类需要实现的接口
//        InvocationHandler h:动态代理方法在执行时，会调用h里面的invoke方法去执行
        return Proxy.newProxyInstance(DongtaiInacationHander.class.getClassLoader(),obj.getClass().getInterfaces(),this);
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

//    proxy，可以用来绑定实例接口的方法
//    method ，是调用的方法，可以用来方法过滤，得到方法的声明类等等。
//    第三个参数就仅仅是被调用方法的参数罢了
    //每次调用代理对象的时候会调用这个方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       //代理类需要执行的方法，日志输出等
        System.out.println("开始 日志：启动动态代理模式");
        //核心业务代码，委托对象来调用
        Object invoke = method.invoke(this.obj,args);//obj调用自己的接口实现方法
        System.out.println("结束");
        return invoke;
    }
}




