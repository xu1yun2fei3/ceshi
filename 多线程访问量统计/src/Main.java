import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Acount1 acount = new Acount1();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(acount);
            thread.start();
        }
    }
}


class Acount implements Runnable{
    //使用reentrantLock进行上锁
    private static int num = 0;
    private ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {
        reentrantLock.lock();
        num++;
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":是第" + num + "个访客");
        reentrantLock.unlock();
    }
}

class Acount0 implements Runnable{
    //使用synchronized 对Run方法进行上锁
    private static int num = 0;
    @Override
    public synchronized void run() {
        num++;
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":是第" + num + "个访客");
    }
}

class Acount1 implements Runnable{
    //使用synchronized 对Run方法进行上锁
    private static Integer num = 0;
    @Override
    public  void run() {
        synchronized (Acount1.class){
            num++;
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":是第" + num + "个访客");
        }

    }
}