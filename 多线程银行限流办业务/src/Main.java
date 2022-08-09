import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        //限流5人，网点内部只允许5人,进来的人发许可证，离开的时候收回
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                try {
                    //得到许可证
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + ":进入网点");
                    //每个客户办理3秒钟
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + ":离开网点");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }

            }).start();
        }
    }
}
