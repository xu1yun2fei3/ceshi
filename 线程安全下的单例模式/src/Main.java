public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                Danli danli = Danli.getDanli();
                danli.xianchengxinxi();
            }).start();
        }

    }
}

class Danli{
    private static Danli danli = new Danli();

    public static Danli getDanli(){
        return danli;
    }
    private Danli(){
        System.out.println("Danli对象创建成功");
    }

    public void xianchengxinxi(){
        System.out.println(Thread.currentThread().getName() + "：执行");
    }
}