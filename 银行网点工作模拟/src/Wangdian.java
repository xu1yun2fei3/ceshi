import java.util.Arrays;

class Wangdian implements jigouyunxin {
    private String name;
    private int[][] yejiben = new int[20][20];
    private Kehu[] kehus = new Kehu[100];
    public static Integer Licaierdu = 100;

    public void setKehus() {
        for (int i = 1; i < 101; i++) {
            kehus[i-1] = new Kehu(i, (int) Math.random() + 5);
        }
    }

    public Wangdian(String name) {
        this.name = name;
    }

    @Override
    public void yejifenxi(YuanGong yuanGong, int yeji) {
        this.setYejiben(yuanGong, yeji);
    }

    public void wangdianyunyin(YuanGong lindao, YuanGong[] renyuan) {
        for (int j = 0; j < 4; j++) {
            System.out.println(String.format("《第 %d 周》", (j + 1)));
            for (int i = 0; i < 4; i++) {
                System.out.println(String.format("工作上班第 %d 天", (i + 1)));
                for (YuanGong temp : renyuan) {
                    temp.shangban(this, lindao);
                }

            }
            System.out.println("开会！！！！");
            for (YuanGong temp : renyuan) {
                temp.kaihui(lindao);
            }

        }
        System.out.println("这个月结束了,月末总结大会");
        lindao.kaihui(renyuan);
        System.out.println("检测辞职！！！");
        for (YuanGong temp : renyuan) {

            temp.cizhi(lindao);
        }

    }


    public void setYejiben(YuanGong yuanGong, int yeji) {
        yejiben[yuanGong.getId()][yuanGong.getGongling()] = yeji;
    }

    public void getYejiben(YuanGong yuanGong) {
        System.out.println(yuanGong.getMingzi() + ":" + Arrays.toString(yejiben[yuanGong.getId()]));
    }

    public Kehu[] getKehus() {
        return this.kehus;
    }

}

class Yejiben {
    private YuanGong[] renyuan;
    private int yejizhibiao;
    private int[][] data = new int[20][20];

    public void addYeji(int id,int yeji){}

    public void pingu(){};
}