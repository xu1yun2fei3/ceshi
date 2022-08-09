import java.util.Scanner;

public class cunqianlinliping {
    public static void main(String[] args) {

        int dangwei = 0;
        System.out.println("你存多少钱：");
        int jiner =new Scanner(System.in).nextInt();
        System.out.println("你是否是转存（是/否）:");

        boolean iszhuangcun=new Scanner(System.in).next()=="是"?true:false;

        if (jiner <= 3){
            dangwei = 1;
        }else if (jiner <= 5){
            dangwei = 2;
        }else if (jiner <= 10){
            dangwei = 3;
        }else if (jiner <= 20){
            dangwei = 4;
        }else if (jiner <= 50){
            dangwei = 5;
        }else {
            dangwei = 6;
        }

        if (iszhuangcun==true){
            dangwei = dangwei-1;
        }
        System.out.println("给客户一个"+(dangwei-1)+"挡的礼品");
        switch (dangwei){
            case 0:
                System.out.println("香皂，对联");
                break;
            case 1:
                System.out.println("小水杯6个，或者毛巾");
                break;
            case 2:
                System.out.println("餐具一套");
                break;
            case 3:
                System.out.println("炒锅一个");
                break;
            case 4:
                System.out.println("电吹风或者咖啡机");
                break;
            case 5:
                System.out.println("涮烫一体锅");
            case 6:
                System.out.println("虎年金钞购买资格一个");
                break;
        }

    }
}
