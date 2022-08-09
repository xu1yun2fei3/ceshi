import java.util.Scanner;

public class xunhuan_caishuziyouxi {
    public static void main(String[] args) {
        //猜数字游戏，随机数，输入，字符串
        int mubiao  = (int)(Math.random()*100);
        //System.out.println(mubiao);
        Scanner scanner = new Scanner(System.in);
        int caice = 0;
        int shangbian = 100;
        int xiabian = 1;
        int cishu = 0;
        System.out.println(String.format("%d 到 %d 之间: \n",xiabian,shangbian));

        do {
            caice = scanner.nextInt();
            if (caice<xiabian || caice>shangbian){
                System.out.println(String.format("必须输入 %d 到 %d 之间的数！！！ \n",xiabian,shangbian));
                caice = scanner.nextInt();
            }
            if (caice > mubiao){
                shangbian = caice;
                System.out.println(String.format("%d---%d之间", xiabian, shangbian));
            }else {
                xiabian = caice;
                System.out.println(String.format("%d---%d之间", xiabian, shangbian));
            }
            cishu++;
        }while (mubiao != caice);

        System.out.println(String.format("你一共用了%d次才成功",cishu));
    }
}
