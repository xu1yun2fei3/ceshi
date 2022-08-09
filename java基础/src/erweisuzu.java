import java.util.Arrays;

public class erweisuzu {
    public static void main(String[] args) {
        String[] fenzu = {"gaogui","datang","kehujingli","zhuguan","dianziyinhang","baoan","qinjie"};
        String[] chenyuan="xuyunfei,wangyilin,fangjiacan,wanshi/wangling,liuyang/lixue,guoyuanhao/liujia,zhoulina/xinxiaoli,xierongfang/baoan1,baoan2,baoan3/qinjieanyi".split("/");

        String[][] quanzu = new String[fenzu.length][];
        for (int i = 0; i < fenzu.length; i++) {
            String[] chenyuantemp = chenyuan[i].split(",");
            quanzu[i]= new String[chenyuantemp.length];
            int len = chenyuantemp.length;
            quanzu[i][0] = fenzu[i];
            for (int j = 1; j < len; j++) {
                quanzu[i][j] = chenyuantemp[j-1];
            }
        }
        for (String[] temp : quanzu) {

            System.out.println(Arrays.toString(temp));

        }
        //创建一个不同长度的二维数组
        int[][] a = {{1,2},{1,5,6},{2,5}};
        a[0] = new int[4];

        System.out.println(Arrays.toString(a[0]));
    }
}
