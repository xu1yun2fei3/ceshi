import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Maipiao maipiao = new Maipiao();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //maipiao.ready0();
                    maipiao.go0();
                    //maipiao.end0();
                }
            });
            thread.start();
        }

    }
}

class Maipiao {
    public Integer piao = 10;
    private ReentrantLock reentrantLock = new ReentrantLock();

    //准备抢票
    public void ready(){
        System.out.println(Thread.currentThread().getName() + "：准备抢票");
    }
    public void ready0(){
        System.out.println(Thread.currentThread().getName() + "：准备抢票");
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //抢票
    //不锁
    public void go(){
        this.piao--;
        System.out.println(Thread.currentThread().getName() + "：抢票ing,剩余："+this.piao);
    }
    //使用重入锁
    public void go0(){
        reentrantLock.lock();
        this.piao--;
        System.out.println(Thread.currentThread().getName() + "：抢票ing,剩余："+this.piao);
        reentrantLock.unlock();
    }
    //锁住的是go方法
    public synchronized void go1(){
        this.piao--;
        System.out.println(Thread.currentThread().getName() + "：抢票ing,剩余："+this.piao);
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public  void go2(){
        //锁住的是对象
        synchronized (this){
            this.piao--;
            System.out.println(Thread.currentThread().getName() + "：抢票ing,剩余："+this.piao);
        }
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //抢票结束
    public void end(){
        System.out.println(Thread.currentThread().getName() + "：抢票结束");
    }
    public void end0(){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "：抢票结束");
    }

}
