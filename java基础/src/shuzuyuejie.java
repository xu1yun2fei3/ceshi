import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class shuzuyuejie {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        Iterator iterator = list.iterator();
        list.remove(0);
    }
}
