import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        String renyuanmindan = "xuyunfei,wangyilin,fanjiancai,wangling,yuanlei,lixue,guoyuanhao,liuyan";
        YuanGong[] shangbanrenyuan = util.shangbanrenyuan(renyuanmindan);

        YuanGong lindao = new YuanGong(11,"zhoulina","lindao",150);
        Wangdian beixia = new Wangdian("beixia");
        beixia.setKehus();
        //System.out.println(Arrays.toString(beixia.getKehus()));
        Guiyuan xuyunfei = new Guiyuan(1,"xuyunfei","gaogui",5);
        Guiyuan wangyiling = new Guiyuan(2,"wangyiling","gaogui",10);

        Thread chuankou1 = new Thread(()->{
            for (Kehu temp : beixia.getKehus()) {
                if (temp.getId()==0)continue;
                xuyunfei.Licai(temp);
            }
        },"窗口1");

        Thread chuankou2 = new Thread(()->{
            for (Kehu temp : beixia.getKehus()) {
                if (temp.getId()==0)continue;


                wangyiling.Licai(temp);
            }
        },"窗口2");

        chuankou1.start();
        chuankou2.start();

        //beixia.wangdianyunyin(lindao,shangbanrenyuan);


    }

}



