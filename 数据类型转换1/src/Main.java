import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //基本数据类型和包装类 装箱和拆箱 基本数据类型<--->包装类
        Integer integer = Integer.valueOf("256");
        int a = integer.intValue();

        //基本数据类型间转换，低转高 直接转，高转低 强制转
        int b = 5;
        byte b1 = (byte)b;

        //char 和 byte
        char b3 = '许';
        char b33 = 'a';
        byte b4 = (byte)b3;
        byte b44 = (byte)b33;
        //二进制输出整数
        System.out.println(Integer.toBinaryString(b4));
        System.out.println(Integer.toBinaryString(b44));

        b1 = 5;
        b = b1;
        //字符之间按照assic码表转
        int b2 = 'f';
        //System.out.println(b2);

        //String 和 数组
        String[] str = "xu yun fei".split(" ");
        String str1 = Arrays.toString(str);
        //System.out.println(str1);

        String[] c = "1,2,3".split(",");
        int[] c1 = new int[c.length-1];
        for (int i = 0; i < c.length-1; i++) {
            c1[i] = Integer.parseInt(c[i]);
        }
        //System.out.println(c1);

        //String 和基本数据类型  包装类.parse*(String s)
        int i = Integer.parseInt("256");
        double i1 = Double.parseDouble("256.35");
        Boolean i3 = Boolean.parseBoolean("true");

        //集合 和 数组
        //集合-》数组 Collection.toArray()
        //数组-》集合



    }
}
