//判断两个自定义的对象相等，需要同时重写equals方法和hashcode方法
public class Object_chongxie {
    public static void main(String[] args) {
       Student student1 = new Student(123,"xuyufnei");
       System.out.println(student1);
       Student student2 = new Student(123,"wnagyiling");
       System.out.println(student2);

       System.out.println("是否相等："+student1.equals(student2));
    }
}

//重写hashcode() 和 equals(),用学生的id来唯一标识一个学生
class Student {
    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
       return  String.format("name=%s,id=5d",this.name,this.id);
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Student){
            Student s = (Student) o;
            if (this.id == s.id){
                return true;
            }
            return false;
        }
        return false;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
