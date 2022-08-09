/*
*   继承中代码的执行顺序
*   1.先加载类信息，再创建对象，加载类信息就是执行类中的静态代码块，静态语句
*   2.创建对象时，先加载资源（非静态代码块，非静态成员属性对象），再执行构造函数*/

public class Test {
    public static void main(String[] args) {
        Child child = new Child();
        child.test();
        ((Parent)child).test();
    }
}
class Stub {
    public Stub(String str) {
        System.out.println(str + "对象创建");
    }
}

class Parent {
    static Stub parentStaticStub = new Stub("父类静态对象-");

    static {
        System.out.println("父类的静态代码块执行...");
    }

    {
        System.out.println("父类的代码块执行...");
    }

    Stub parentStub = new Stub("父类对象-");

    Stub stub;

    public Parent() {
        System.out.println("父类构造执行...");
        stub = new Stub("父类构造器创建对象-");
    }

    public void test(){
        System.out.println("Hello from Parent");
    }
}

class Child extends Parent {

    static Stub childstaticStub = new Stub("子类静态对象-");

    static {
        System.out.println("子类静态代码执行...");
    }

    {
        System.out.println("子类代码块执行...");
    }

    Stub childStub = new Stub("子类对象-");

    Stub stub;

    public Child() {
        System.out.println("子类构造器执行...");
        stub = new Stub("子类构造器创建对象-");
    }

    public void test(){
        System.out.println("Hello from Child");
    }
}