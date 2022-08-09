import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class TCPServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;

        File file = new File("C:\\Demo\\java1234-master\\ceshi\\网络编程聊天\\src\\touxiang.jpg");

        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("---服务端---");
            System.out.println("服务端启动，等待链接");

            while (true){
                socket = serverSocket.accept();
                //接受消息
                inputStream = socket.getInputStream();
                dataInputStream = new DataInputStream(inputStream);

                String request = dataInputStream.readUTF();
                System.out.println("客户端：" + request);

                byte[] dian = new byte[2];
                dataInputStream.read(dian);
                System.out.println(Arrays.toString(dian));

                byte[] tuxiang = new byte[4096];
                dataInputStream.read(tuxiang);
                System.out.println(Arrays.toString(tuxiang));
                outputStream = new FileOutputStream(file);
                outputStream.write(tuxiang);

                //回复消息
                outputStream = socket.getOutputStream();
                dataOutputStream = new DataOutputStream(outputStream);

                //发送文字
                String response = "hello ";
                dataOutputStream.writeUTF(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                inputStream.close();
                outputStream.close();
                dataInputStream.close();
                dataOutputStream.flush();
                dataOutputStream.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
