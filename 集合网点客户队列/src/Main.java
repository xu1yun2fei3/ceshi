import java.util.*;

//集合，以id为唯一表示，生成，去重
public class Main {
    public static void main(String[] args) {
        //生成10个客户
        //有序，key唯一，value可重复，按照key排序
        TreeMap treeMap = new TreeMap();
        //无序，key唯一，value可重复
        HashMap hashMap = new HashMap();
        //无序，key唯一，线程安全
        Hashtable hashtable = new Hashtable();

        List list = new ArrayList();
        LinkedList linkedList = new LinkedList();
        //线程安全
        Vector vector = new Vector();
        //栈，先进后出
        Stack stack = new Stack();

        //无序，唯一
        HashSet hashSet = new HashSet();
        //有序，唯一，构建顺序和遍历顺序一致
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        //有序，唯一，按照升序排列，元素可比较
        TreeSet treeSet = new TreeSet();
        String[] mindan = "xuyunfei,wangyiling,lixue,guoyuanhao,wangling,fangjiancai,liujia,zhoulina,liuyan,yuanlei,xuyunfei".split(",");

        for (int i = 0; i < mindan.length; i++) {
            treeMap.put(i,mindan[i]);
            hashMap.put(i,mindan[i]);
            stack.push(mindan[i]);
            hashSet.add(mindan[i]);
        }

        System.out.println(treeMap);
        System.out.println(stack);
        System.out.println(hashSet);
        System.out.println(hashMap);


    }
}

class Kehu implements Comparable{
    private int id;
    private String name;

    public Kehu(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //用id作为比较标准
    @Override
    public int compareTo(Object o) {
        Kehu kehu = (Kehu) o;
        if (this.id > kehu.id)return 1;
        if (this.id == kehu.id)return 0;
        if (this.id < kehu.id) return -1;
        return 0;
    }

    //重写equals和hashcode 用id来判断两个是否相等
    @Override
    public boolean equals(Object obj) {
        if (this==obj)return true;
        if (obj instanceof Kehu){
            Kehu kehu = (Kehu)obj;
            if (this.id == kehu.id){
                return true;
            }
            return false;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return this.id;
    }
}
