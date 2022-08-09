import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        //10个线程抢同一个资源,main线程每一秒创建一个新线程
        //每个线程尝试争取3秒，得到锁等待5秒后释放，没有得到直接放弃
        Ziyuan ziyuan = new Ziyuan();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(ziyuan);
            thread.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



class Ziyuan implements Runnable{
    private ReentrantLock reentrantLock = new ReentrantLock();
    @Override
    public void run() {
        try {
            if (reentrantLock.tryLock(3, TimeUnit.SECONDS)){
                System.out.println(Thread.currentThread().getName() + "：得到资源并上锁5秒");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println(Thread.currentThread().getName() + "：等待超过3秒，放弃");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //当当前线程拥有锁才会解锁
            if (reentrantLock.isHeldByCurrentThread()){
                System.out.println(Thread.currentThread().getName() + ":释放锁");
                reentrantLock.unlock();
            }
        }
    }
}

