import java.lang.reflect.Proxy;

//代理模式，委托类和代理类都可以执行，委托类是代理类的成员变量，委托类和代理类实现相同的接口.
//代码的开发原则是 可以扩展但是不要修改,代理模式实际上是在原有基础上增加新的功能,这就是代理类的作用
public class Main {
    //静态代理
    //买手机，代理买手机,如果后面有其他手机 只用修改 phoneProxy 就可以
    public static void main(String[] args) {
      DongtaiInacationHander handler = new DongtaiInacationHander();
        //委托对象
        Phone phone = new Xiaomi();
        Car car = new Baoma();
        House house = new BigHouse();

//        //静态代理
//        CarProxy carProxy = new CarProxy();
//        carProxy.setCar(car);
//        System.out.println(carProxy.saleCar());
//        PhoneProxy phoneProxy = new PhoneProxy();
//        phoneProxy.setPhone(phone);
//        System.out.println(phoneProxy.salePhone());

        //动态代理
        //方法二
//        DongtaiInacationHander dongtaiInacationHander = new DongtaiInacationHander();
//
//        Car dongtaiCarProxy = (Car) dongtaiInacationHander.bind(car);
//        System.out.println(dongtaiCarProxy.saleCar());

        //方法一
        House house1  = new BigHouse();
        //InvocationHandler 调用句柄 获取house1 的方法调用权利
        DongtaiInacationHander dongtaiInacationHander1 = new DongtaiInacationHander();

        dongtaiInacationHander1.setObj(house1);
        //参数意义：this 获取this的类加载器 和 接口
//        loader: 用哪个类加载器去加载代理对象 BigHouse 的类加载器
//        interfaces:动态代理类需要实现的接口 House
//        h:动态代理方法在执行时，会调用h里面的invoke方法去执行
        house1 = (House) Proxy.newProxyInstance(BigHouse.class.getClassLoader(),BigHouse.class.getInterfaces(), dongtaiInacationHander1);
        System.out.println(house1.saleHouse());
    }
}


