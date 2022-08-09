interface Xinzhuang {
    //非抽象方法，成员变量都是静态的，default 可以被实现类重写，和调用
    String name = "xinxi：xingzhuag";
    default public void xinxi(){
        System.out.println(name);
    }
    void draw();
}
public class Main {
    public static void main(String[] args) {
        Fatory fatory = new Fatory();
        Xinzhuang xinzhuang = fatory.getXinzhuang(2);
        xinzhuang.draw();
        yuan y = (yuan) fatory.getXinzhuang(1);
        y.xinxi();
    }
}


class Fatory {
    public Xinzhuang getXinzhuang(int id) {
        switch (id) {
            case 1:
                return new yuan();
            case 2:
                return new fang();
            case 3:
                return new sanjiao();
        }
        return null;
    }
}
class yuan implements Xinzhuang {
    @Override
    public void draw() {
        System.out.println("画一个圆");
    }

    @Override
    public void xinxi() {
        System.out.println("xinxi：yuan");
    }
}
class fang implements Xinzhuang {
    @Override
    public void draw() {
        System.out.println("画一个方形");
    }
}

class sanjiao implements Xinzhuang {
    @Override
    public void draw() {
        System.out.println("画一个三角形");
    }
}