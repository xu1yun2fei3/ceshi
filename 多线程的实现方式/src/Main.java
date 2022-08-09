import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Main {
    public static void method(){
        //线程执行的方法，单独抽出来
        System.out.println(Thread.currentThread().getName() + ":开始执行");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":结束");
    }

    public static void main(String[] args) {
        //Runable
        Runnable method0 = new RunableMethod();
        //Callable
        Callable method1 = new CallableMethod();
        FutureTask<String> futureTask = new FutureTask<>(method1);

        for (int i = 0; i < 5; i++) {
//            Thread thread = new Thread(futureTask);
//            thread.start();
            //Callable
            new Thread(new FutureTask<String>(new CallableMethod())).start();
        }

        //lamba表达式
//        for (int i = 0; i < 5; i++) {
//
//            new Thread(()->{
//                Main.method();
//            }).start();
//        }


    }
}

class ThreadMethod extends Thread{
    //集成Thread类

    @Override
    public void run() {
        Main.method();
    }
}

class RunableMethod implements Runnable{
    //实现Runable接口
    @Override
    public void run() {
        Main.method();
    }
}

class CallableMethod implements Callable<String>{
    @Override
    public String call() throws Exception {
        Main.method();
        return "Callable-Method1：执行成功";
    }
}