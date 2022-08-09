import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;

public class zifuliu {
    public static void main(String[] args) throws Exception{
        File file = new File("C:\\Demo\\java1234-master\\ceshi\\IO流\\src\\aa.txt");
        System.out.println(file.exists());
        Reader reader = new FileReader(file);

        char[] jieguo = new char[1024];
        int len = reader.read(jieguo);
        int temp = 0;
        while ((temp = reader.read()) != -1){
            System.out.println(temp);
        }
        reader.close();
    }
}
