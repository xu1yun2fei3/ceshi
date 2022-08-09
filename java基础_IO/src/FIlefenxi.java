import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class FIlefenxi {
    public static void main(String[] args) {
        String basePath = "C:\\Demo\\java1234-master\\ceshi\\IO流\\data";
        File data = new File(basePath);
        ArrayList<String> list = new ArrayList<>();
        ArrayList<File> mulu = new ArrayList<>();

        TreeMap<String,String> treeMap = new TreeMap<>();
        File[] files = data.listFiles();

        for (File fi:files){
            if (!fi.isDirectory()){
                System.out.println(fi.getAbsoluteFile());
                mulu.add(fi);
                list.add(fi.getAbsolutePath());
                treeMap.put(fi.getName(), fi.getAbsolutePath());
            }
        }

        System.out.println(treeMap.keySet());
    }


}
