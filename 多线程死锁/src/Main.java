//产生死锁的四个必要条件：
//
//        1、互斥条件，指分配的资源进行排他性使用，即在一定的时间内该资源只能被一个进程/线程占用，如果此时还有其他进程/线程请求该资源，则只能等待，直到该资源占用着自己使用完成后释放。
//
//        2、请求与保持条件，指进程/线程已经获得了资源，又提出了新的资源请求，而这个资源已经被 其他进程/线程占有，此时请求进程/线程阻塞，但自己之前已经获得的资源继续保持占有。
//
//        3、不可剥夺条件，指进程/线程已经获得资源，在没有使用完成之前，不能被抢占剥夺，只能使用完成后自己释放。
//
//        4、循环等待条件，指发生死锁时，必然存在一个资源占用链，即P1等待P2正在占用的资源，P2等待P3正在占用的资源...Pn等待P1正在占用的资源.

public class Main {
    public static void main(String[] args) {
        new Thread(new AtoB()).start();
        new Thread(new BtoA()).start();
    }
}

class Data{
    public static Data data1 = new Data("A");
    public static Data data2 = new Data("B");

    private String name;

    public Data(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                '}';
    }
}

class AtoB implements Runnable{

    @Override
    public void run() {
        synchronized (Data.data1){
            System.out.println(Thread.currentThread().getName() + "：得到"+Data.data1+"并上锁");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Data.data2){
                System.out.println(Thread.currentThread().getName() + "：得到"+Data.data2+"并上锁");
            }
        }

    }
}

class BtoA implements Runnable{

    @Override
    public void run() {
        synchronized (Data.data2){
            System.out.println(Thread.currentThread().getName() + "：得到"+Data.data2+"并上锁");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Data.data1){
                System.out.println(Thread.currentThread().getName() + "：得到"+Data.data1+"并上锁");
            }
        }

    }
}
