import java.io.*;
import java.util.Arrays;

public class wenjian  {
    public static void main(String[] args) throws Exception {
        String path = "C:\\Demo\\java1234-master\\ceshi\\IO流\\src\\hh.txt";
        String path1 = "C:\\Demo\\java1234-master\\ceshi\\IO流\\src\\aa.txt";

        File file = new File(path);
        System.out.println(file.exists());
        System.out.println(file.getPath());

        FileInputStream inputStream = new FileInputStream(file);
        byte[] jieguo = new byte[1024];
        inputStream.read(jieguo);
        System.out.println(Arrays.toString(jieguo));
        inputStream.close();

        File file1 = new File(path1);
        file1.createNewFile();
        System.out.println(file1.exists());
        OutputStream outputStream = new FileOutputStream(file1);
        outputStream.write("wo jiu shi xu yun fei".getBytes());
        outputStream.close();

    }
}
