import java.util.concurrent.locks.ReentrantLock;

public class Main1 {
    public static void main(String[] args) {
       //资源不足，一个线程始终占领一个资源，其他线程得不到导致死锁
        Sisuo sisuo = new Sisuo();
        for (int i = 0; i < 3; i++) {
            new Thread(sisuo).start();
        }
    }
}

class Sisuo implements Runnable{
    private ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {
        try {
            reentrantLock.lock();
            System.out.println(Thread.currentThread().getName() + "：执行步骤1");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "：执行步骤2");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "：执行步骤3");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}