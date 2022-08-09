import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

//网点客户取号和柜员办理业务
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i <3 ; i++) {
            new Thread(()->{
                for (int j = 0; j < 5; j++) {
                    Kehu kehu = new Kehu();
                    kehu.quhao();
                    System.out.println(Kehu.kehus);
                }
            }).start();
        }
    }
}

class Kehu{
    private int id;
    //线程不安全
    //public static List<Kehu> kehus = new ArrayList<>();
    //在ArrayList的基础上套上一个synconized
    //public  static List<Kehu> kehus = Collections.synchronizedList(new ArrayList<>());
    //JUC 读写分离解决解决问题
    public  static List<Kehu> kehus = new CopyOnWriteArrayList<>();
    public Kehu() {
        this.id = Kehu.kehus.size();
    }

    public int getId() {
        return id;
    }

    public void quhao(){
        Kehu.kehus.add(this);
        System.out.println("取号：" + kehus.size() + 1);
    };

    public void banyewu(Kehu kehu){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Kehu.kehus.remove(kehu);
        System.out.println("客户：" + kehu.getId() + "办理完成");
    }
}


