import java.util.Arrays;
import java.util.Scanner;

public class shuzu_suijichouqu {
    public static void main(String[] args) {
        //随机抽取人来做任务，以及分组用/分割，二级分组用“，”分割
        String[] fenzu = {"gaogui","datang","kehujingli","zhuguan","dianziyinhang","baoan","qinjie"};
        String[] chenyuan="xuyunfei,wangyilin,fangjiacan,wanshi/wangling,liuyang/lixue,guoyuanhao/liujia,zhoulina/xinxiaoli,xierongfang/baoan1,baoan2,baoan3/qinjieanyi".split("/");

        String[] jieguo = fenzu;
        String[][] quanzu = new String[fenzu.length][];
        for (String[] zu:quanzu) {

        }

        System.out.println("全员名单："+Arrays.toString(chenyuan));
        int i = 0;
        System.out.println(String.format("需要抽取几组员工(1-%d)：\n",fenzu.length));
        Scanner scanner= new Scanner(System.in);
        int zusu = scanner.nextInt();
        if (zusu<0&&zusu>fenzu.length){
            System.out.println(String.format("只能选1 到 %d 组，重新输入。\n",fenzu.length));
            zusu = scanner.nextInt();
        }
        for (String zuyuan:chenyuan) {
            System.out.println(String.format("在 %s 组中：",fenzu[i]));
            String[] mubiao = zuyuan.split(",");
            String zhongjian = chouqian(mubiao);
            jieguo[i] = zhongjian;
            if (i==zusu)break;
            i++;
        }
        System.out.println("抽中名单："+Arrays.toString(jieguo)+"\n一共有"+i+"组");

    }

    static String chouqian(String[] chenyuan){
        String mubiao = chenyuan[(int)(Math.random()*chenyuan.length)];
        System.out.println(String.format("从 %s 中选取 \n %s 来完成这个任务",Arrays.toString(chenyuan),mubiao));
        return mubiao;
    }
}
