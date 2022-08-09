public class Main {
    public static void main(String[] args) {
        try {
            int a = add(2);
            System.out.println(a);
        } catch (ZidingyiException e) {
            e.printStackTrace();
        }
        int b = add(2.3);
    }
    //传入一个参数，返回这个参数++，要求传入的参数必须是整数否则抛出异常
    static int add(Object obj){
        if (!(obj instanceof Integer)){
            String message = "输入的不是整数类型";
            throw new ZidingyiException(message);
        }else {
            int num = (int)obj;
            return num++;
        }
    }

}

class ZidingyiException extends RuntimeException{
    public ZidingyiException(String message) {
        super(message);
    }
}
