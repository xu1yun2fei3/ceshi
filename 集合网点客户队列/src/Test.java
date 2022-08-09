//网点取号和办业务
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();

        //100个客人取号
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                list.add(i);
                System.out.println(String.format("客户%d到店取号",i));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //两个窗口办理业务
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (Integer temp : list) {
            executorService.execute(()->{
                list.remove(0);
                System.out.println(Thread.currentThread().getName()+":客户办理完成");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        // ArrayIndexOutOfBoundsException数组越界异常 iterator没有调用iterator.next()指针没有向后移动，所以hasNext（）一直为true
//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()){
//            executorService.execute(()->{
//                final Object obj = iterator.next();
//                list.remove(0);
//                System.out.println(Thread.currentThread().getName()+":客户办理完成");
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
        executorService.shutdown();

    }
}
