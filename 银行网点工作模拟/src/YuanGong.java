import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class YuanGong {
    private String mingzi;
    private String gangwei;
    private int yejizhibiao;
    private int id;

    private int yeji = 0;
    private int reqing = 100;
    private int gongling = 0;
    private boolean xinqing = false;
    private int nenglidengji = 5;


    //开会，上班，晋升，辞职,请假
    //热情降为0 的时候开始提出辞职，每个月末检测一次辞职想法
    public void cizhi(YuanGong lindao){
        if (this.reqing <= 0 ){
            System.out.println(this.mingzi+"：老子辞职敢了，爱咋滴咋地");
            lindao.yeji = lindao.yeji-2;
            System.out.println(lindao);

            System.out.println(this);
            return;
        }
        lindao.xinqing = false;
        this.xinqing = false;
    }
    //随机被夸奖或者批评
    public void kaihui(YuanGong zhuchi){
        Boolean iskuajiang = (int)(Math.random()+0.6) == 1?true:false;
        if (iskuajiang){
            System.out.println(this.mingzi+zhuchi.getMingzi()+"批评了我，员工热情-1");
            this.xinqing = false;
            this.reqing = this.reqing-2;
        }else {
            System.out.println(this.mingzi+":"+zhuchi.getMingzi()+"：夸奖了我，员工热情+1");
            this.xinqing = true;
            this.reqing++;
        }

    }
    public void kaihui(YuanGong[] renyuan){
        if (this.getXinqing()==false){
            System.out.println("这周业绩不达标，大家做的很不好");
            for (YuanGong temp :
                    renyuan) {
                if ((int) (Math.random() + 0.5) >= 0) {
                    String.format("%s: 受到批评了 热情减少 ",temp.getMingzi());
                    temp.setReqing(temp.reqing-2);
                }else {
                    String.format("%s: 受到表扬了 热情增加 ",temp.getMingzi());
                    temp.setReqing(temp.reqing+2);
                }
            }
        }else {
            System.out.println("大家这个月做很好");
            for (YuanGong temp :
                    renyuan) {
                temp.setReqing(temp.reqing+1);
            }
        }
    }

    public void shangban(jigouyunxin wangdian,YuanGong lindao){

        if (this.reqing <= 0){
            this.cizhi(lindao);
        }else {
            this.reqing--;
            this.gongling++;
            int jintiyeji = (int)(Math.random()*6);
            wangdian.yejifenxi(this,jintiyeji);
            this.yeji = this.yeji+ jintiyeji;
            if (jintiyeji < this.yejizhibiao){
                this.reqing--;
                this.xinqing = false;
                System.out.println(String.format("%s：业绩没有完成，哎 热情-1,业绩：%d,心情：%s，业绩总数：%d",this.mingzi,jintiyeji,(this.xinqing?"高兴":"沮丧"),this.yeji));
            }else {
                System.out.println(String.format("%s：业绩完成，热情+1,业绩：%d,心情：%s，业绩总数：%d",this.mingzi,jintiyeji,(this.xinqing?"高兴":"沮丧"),this.yeji));
                this.reqing++;
                this.xinqing = true;
            }
        }


    }

    private void jinsheng(){

    }

    //看领导心情和请假天数，心情好可以3-2天，心情不好0-1天
    public boolean qingjia(YuanGong lindao,int day){
        if (day>3){
            System.out.println(lindao.getMingzi()+":请假天数太长，不批");
            System.out.println("请假失败");
            return false;
        }else if ((lindao.getXinqing()==true&day<3)|(lindao.getXinqing()==false&day<1)){
            System.out.println("请假成功");
            return true;
        }else{
            System.out.println("请假失败");
            return false;
        }
    }

    public String getMingzi() {
        return mingzi;
    }

    public void setMingzi(String mingzi) {
        this.mingzi = mingzi;
    }

    public String getGangwei() {
        return gangwei;
    }

    public void setGangwei(String gangwei) {
        this.gangwei = gangwei;
    }

    public int getYejizhibiao() {
        return yejizhibiao;
    }

    public void setYejizhibiao(int yejizhibiao) {
        if (yejizhibiao < 0){
            System.err.println("业绩指标不能为负数，设为默认值50");
            this.yejizhibiao = 10;
        }else {
            this.yejizhibiao = yejizhibiao;
        }
    }

    public int getYeji() {
        return yeji;
    }

    public void setYeji(int yeji) {
        this.yeji = yeji;
    }

    public int getReqing() {
        return reqing;
    }

    public void setReqing(int reqing) {
        this.reqing = reqing;
    }

    public int getGongling() {
        return gongling;
    }

    public void setGongling(int gongling) {
        this.gongling = gongling;
    }

    public boolean getXinqing() {
        return xinqing;
    }

    public void setXinqing(boolean xinqing) {
        this.xinqing = xinqing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "YuanGong{" +
                "mingzi='" + mingzi + '\'' +
                ", gangwei='" + gangwei + '\'' +
                ", yejizhibiao=" + yejizhibiao +
                ", yeji=" + yeji +
                ", reqing=" + reqing +
                ", gongling=" + gongling +
                ", xinqing=" + xinqing +
                '}';
    }

    public YuanGong(int id,String mingzi, String gangwei, int yejizhibiao) {
        this.id = id;
        this.mingzi = mingzi;
        this.gangwei = gangwei;
        this.yejizhibiao = yejizhibiao;
    }
}

class Lindao extends YuanGong{

    public Lindao(int id, String mingzi, String gangwei, int yejizhibiao) {
        super(id, mingzi, gangwei, yejizhibiao);
    }
}

class Guiyuan extends YuanGong{
    private ReentrantLock reentrantLock =new ReentrantLock();
    public Guiyuan(int id, String mingzi, String gangwei, int yejizhibiao) {
        super(id, mingzi, gangwei, yejizhibiao);
    }
    //买理财
    public  void Licai(Kehu kehu){
        if (kehu.getId()==0)return;
        synchronized (Wangdian.class){
            Wangdian.Licaierdu = Wangdian.Licaierdu-(int)(kehu.getZichan()*0.5);
            kehu.setZichan((int)(kehu.getZichan()*0.5));
            System.out.println(String.format("%s:客户%d购买理财%d,理财额度：%d",Thread.currentThread().getName(),kehu.getId(), (int) (kehu.getZichan() * 10),Wangdian.Licaierdu));
            kehu.setId(0);
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Datang extends YuanGong{

    public Datang(int id, String mingzi, String gangwei, int yejizhibiao) {
        super(id, mingzi, gangwei, yejizhibiao);
    }
}

class Kehujingli extends YuanGong{

    public Kehujingli(int id, String mingzi, String gangwei, int yejizhibiao) {
        super(id, mingzi, gangwei, yejizhibiao);
    }
}
