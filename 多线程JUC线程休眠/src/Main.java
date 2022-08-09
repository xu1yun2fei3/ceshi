import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        //使用sleep方法进行休眠
        //Main.SleepMethod();
        //使用JUC的TimeUnit
        //Main.JUCMethod();
        //使用wait方法,
        Data data = new Data();
        //使用wait方法，两秒后唤醒
        //data.method();
        //使用wait方法，手动唤醒
        new Thread(()->{
            data.method1();
        }).start();

        new Thread(()->{
            try {
                //8秒后唤醒上面的线程
                TimeUnit.SECONDS.sleep(8);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.method0();
        }).start();
    }


    private static void SleepMethod(){
        for (int i = 0; i < 10; i++) {
            if (i==5){
                System.out.println(Thread.currentThread().getName()+":休眠2秒");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("程序执行》》》》》》"+i);
        }
    }

    private static void JUCMethod(){
        for (int i = 0; i < 10; i++) {
            if (i==5){
                System.out.println(Thread.currentThread().getName()+":休眠2秒");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("程序执行》》》》》》"+i);
        }
    }
}

class Data{
    public synchronized void method(){
        for (int i = 0; i < 10; i++) {
            if (i==5){
                System.out.println(Thread.currentThread().getName()+":休眠2秒");
                try {
                    this.wait(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("程序执行》》》》》》"+i);
        }
    }
    public synchronized void method1(){
        for (int i = 0; i < 10; i++) {
            if (i==5){
                System.out.println(Thread.currentThread().getName()+":休眠2秒");
                try {
                    this.wait();//直接睡眠
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("程序执行》》》》》》"+i);
        }
    }
    public synchronized void method0(){
        this.notify();
    }
}

