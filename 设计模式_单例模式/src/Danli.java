public class Danli {
    public static void main(String[] args) {
        A a = A.getInstance();
        a.showMessage();
    }
}
//单例模式，构造函数是private 保证无法使用构造函数创建对象，蒋自身对象作为一个初始化静态的熟悉，使用public静态方法返回
class A {
    private static A a = new A();
    private void A(){};

    public static A getInstance(){
        return a;
    }
    public void showMessage(){
        System.out.println("这是一个单例模式");
    }
}
