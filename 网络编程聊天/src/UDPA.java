import java.net.DatagramPacket;
import java.net.DatagramSocket;import java.net.InetAddress;
import java.util.Scanner;

public class UDPA {
    //UDP发送数据，广播发送，只发送不管对方接受到没有

    public static void main(String[] args)  throws Exception{
        //发送地址
        InetAddress inetAddress = InetAddress.getByName("192.168.1.5");
        //监听端口
        int port = 8181;

        //数据缓冲
        byte[] data = new byte[4096];
        String shuju = "我是"+inetAddress;
        data = shuju.getBytes();


        //封装数据包,发送数据包和接收数据包
        //封装发送数据包,发送地址192.168.1.5:8181
        DatagramPacket sendPacket = new DatagramPacket(data, data.length,inetAddress,port);
        //封装接受数据包
        DatagramPacket recievePacket = new DatagramPacket(data,data.length);

        //创建socket 在8181监听
        DatagramSocket datagramSocket = new DatagramSocket(8181);


        Scanner scanner = new Scanner(System.in);
        System.out.println("输入指令：1 发送数据 ；-1 接收数据 ； 其他 退出程序");

        while (true){
            int temp = (scanner.nextInt());
            if (temp == 1){
                System.out.println("发送数据：");
                //发送数据
                System.out.println("UDPA发送数据:"+new String(sendPacket.getData()));
                System.out.print(inetAddress+":" +
                        "");
                sendPacket.setData(new Scanner(System.in).nextLine().getBytes());
                datagramSocket.send(sendPacket);

            }else if (temp == -1){
                System.out.println("接收数据");
                //接收数据
                datagramSocket.receive(recievePacket);
                System.out.println("UDPA接收数据:"+new String(recievePacket.getData()));
            }else {
                System.out.println("结束程序");
            }
        }


    }

}
