import java.io.*;
import java.net.Socket;

public class filechuanshuClient {
    public static void main(String[] args) {
        Socket socket = null;

        InputStream inputStream = null;
        DataInputStream dataInputStream = null;
        OutputStream outputStream = null;
        DataOutputStream dataOutputStream = null;

        String message = null;
        byte[] data = null;
        int mingling = 1;

        try {
            socket = new Socket("192.168.1.5",8081);

            //接收
            inputStream = socket.getInputStream();
            dataInputStream = new DataInputStream(inputStream);
            message = dataInputStream.readUTF();
            System.out.println("主机"+socket.getInetAddress()+":"+message);


            //发送
            outputStream = socket.getOutputStream();
            dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(String.valueOf(mingling));

            String message1 = new DataInputStream(socket.getInputStream()).readUTF();
            System.out.println(message1);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                dataInputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
