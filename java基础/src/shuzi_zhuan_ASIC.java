import java.util.Arrays;

public class shuzi_zhuan_ASIC {
    public static void main(String[] args) {
        //字符在输出的时候会用ASII码显示
        int[] a = {1, 5, 'd'};
        System.out.println(Arrays.toString(a));
        //ASII码转字符
        for (int i = 0; i < 200; i++) {
            char shuchu = (char) i;
            System.out.println(i+":"+shuchu);
        }
    }
}
