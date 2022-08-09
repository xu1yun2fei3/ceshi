import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
      Ticket ticket = new Ticket();
      String[] chuangkou = {"A","B","C"};
        for (String chuan : chuangkou) {
            new Thread(ticket,chuan+"窗口").start();
        }
    }
}

class Ticket implements Runnable{
    private ReentrantLock reentrantLock = new ReentrantLock();
    private int shengyu = 15;
    private int shouchu = 0;
    @Override
    public void run() {
        while (shengyu>0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            reentrantLock.lock();
            shengyu--;
            shouchu++;
            if (shengyu==0){
                System.out.println(String.format("%s:售出第%d张票，售罄", Thread.currentThread().getName(), shouchu));
                return;
            }else {
                System.out.println(String.format("%s:售出第%d张票，剩余%d张票", Thread.currentThread().getName(), shouchu, shengyu));
            }
            reentrantLock.unlock();
        }
    }
}
