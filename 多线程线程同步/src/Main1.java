import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//读写锁实现对集合的读写，读写分离，写锁独占，读锁共享
public class Main1 {
    public static void main(String[] args) {
        Cache cache = new Cache();

        for (int i = 0; i < 10; i++) {
            final Integer temp = i;
            final String temp0 = String.valueOf((char) i);
            new Thread(()->{
                cache.write(temp,temp0);
            }).start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            final Integer temp = i;
            new Thread(()->{
                cache.read(temp);
            }).start();
        }
    }
}

class Cache{
    private Map<Integer,String> map = new HashMap<>();
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void write(Integer key,String value){
        readWriteLock.writeLock().lock();
        System.out.println(Thread.currentThread().getName()+":开始写入");
        map.put(key,value);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":写入完成");
        readWriteLock.writeLock().unlock();
    }

    public void read(Integer key){
        //有无读锁结果都没有变化
        readWriteLock.readLock().lock();
        System.out.println(Thread.currentThread().getName()+":读取");
        map.get(key);
        System.out.println(Thread.currentThread().getName()+":读取结束");
        readWriteLock.readLock().unlock();
    }
}
