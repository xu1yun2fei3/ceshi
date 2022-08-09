import java.io.*;

public class FileCopy {
    //实现文件的复制
    public static void main(String[] args) {
        //文件路径
        String path = "C:\\Demo\\java1234-master\\ceshi\\IO流\\src\\";
        File inputFile = new File(path+"hh.txt");
        File outputFile = new File(path+"output.txt");

        FileCopy.ByteCopy(inputFile,outputFile);
    }

    private static void CharCopy(File inputFile , File outputFile){
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(inputFile));
            bufferedWriter = new BufferedWriter(new FileWriter(outputFile));

            //一次性读取一行
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
                bufferedWriter.write(line+"\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.flush();
                bufferedWriter.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void ByteCopy(File inputFile,File outputFile){
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //字节流
            bufferedInputStream = new BufferedInputStream(new FileInputStream(inputFile));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outputFile));

            int temp = 0;
            while ((temp = bufferedInputStream.read()) != -1){
                bufferedOutputStream.write(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
