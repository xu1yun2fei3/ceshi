import java.util.concurrent.*;

//线程池模拟银行上班情况，柜台表示线程，银行日常两个柜台，一个备用柜台，等待区两人，超过5个客户拒绝办理第六人
public class Main1 {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(
                //核心池，目前上班柜台数
                2,
                //最大线程数，银行做多柜台数量
                3,
                //线程存活时间
                1L,
                TimeUnit.SECONDS,
                //阻塞队列，等候区
                new ArrayBlockingQueue<>(2),
                //线程工厂，生成线程对象
                Executors.defaultThreadFactory()
                //拒绝任务策略
                //直接拒绝，抛出异常
//                new ThreadPoolExecutor.AbortPolicy()
                //放弃执行，不抛出遗产
//                new ThreadPoolExecutor.DiscardPolicy()
                //尝试与阻塞队伍争夺，不抛出异常
//                new ThreadPoolExecutor.DiscardOldestPolicy()
                //谁调用谁处理,main来处理
        );

        //Executors 提供的线程池实例
        //线程池只有一个线程对象
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        //线程池有5个线程对象
        ExecutorService executorService2 = Executors.newFixedThreadPool(5);
        //线程池中的线程对象根据电脑配置随机决定
        ExecutorService executorService3 = Executors.newCachedThreadPool();
        for (int i = 0; i < 7; i++) {
            final int temp = i;
            executorService.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":办理业务-"+temp);
            });
        }
        //关闭线程池
        executorService.shutdown();
    }
}
