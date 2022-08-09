import java.util.concurrent.locks.ReentrantLock;
//资源不足产生死锁
public class Main1 {
    public static void main(String[] args) {
        Data data = new Data();
        for (int i = 0; i < 3; i++) {
            new Thread(data).start();
        }
    }
}

class Data implements Runnable{
    private ReentrantLock reentrantLock = new ReentrantLock();
    @Override
    public void run() {
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName() + "得到锁");
    }
}
