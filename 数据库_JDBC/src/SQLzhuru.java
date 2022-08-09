import java.sql.*;
import java.util.Scanner;

//SQL注入，用户输入名字和id 使用查询语句有结果就是登录成功，没有结果就是失败
public class SQLzhuru {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://192.168.1.12:3306/exam1?serverTimezone=UTC";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url,user,password);

//        System.out.println("输入用户名：");
//        String name = new Scanner(System.in).next();
//        System.out.println("输入id");
//        String id = new Scanner(System.in).next();

//     SQL注入：select * from reader where r_name='a' or 'b'='b' and r_no=12 or 'a'='a'
        String Tname = "a' or 'b'='b";
        String Tid = "12 or 'a'='a'";
//真实数据
        String Zname = "xuyunfei";
        String Zid = "126";


//Statement 有SQL注入的风险
        String sql = String.format("select * from reader where r_name='%s' and r_no=%s", Tname,Tid);
        Statement statement = connection.createStatement();
       // ResultSet resultSet = statement.executeQuery(sql);

        //使用prepareStatement,这是SQL注入失败
        String sql1 = "select * from reader where r_name=? and r_no=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
        preparedStatement.setString(1,Tname);
        preparedStatement.setString(2,Tid);
        ResultSet resultSet = preparedStatement.executeQuery();

        //判断是否登录成功，
        if (resultSet.next()){
            System.out.println(resultSet.getString(3)+":"+"登录成功");
        }else {
            System.out.println("登录失败");
        }

        connection.close();
    }
}
