import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("服务器已经启动:等待链接");
            while (true){
                socket = serverSocket.accept();

                //多线程处理
                new Thread(new SocketThread(socket)).start();
                //处理数据
                InputStream inputStream = socket.getInputStream();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}

class SocketThread implements Runnable{
    //实现服务端的业务逻辑

    private Socket socket;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        //任务就是，显示客户端发过来的数据

        InputStream inputStream = null;
        OutputStream outputStream = null;

        String clientMessage = null;
        Scanner scanner = new Scanner(System.in);
        try {
            while (true){
                //接收数据
                inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                clientMessage = dataInputStream.readUTF();
                System.out.println(socket.getInetAddress() + ":" + clientMessage);

                //发送数据
                System.out.print("localhost:");
                String hufu = scanner.nextLine();
                outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                dataOutputStream.writeUTF(hufu);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}