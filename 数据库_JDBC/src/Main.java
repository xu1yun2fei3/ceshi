import java.sql.*;

//JDBC链接数据库步骤
public class Main {
    public static void main(String[] args) throws Exception {
        // 1.加载驱动 使用反射加载 com.mysql.cj.jdbc.Driver 驱动;要把jdbc jar包添加到项目中，projectStructure中
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2.链接数据库,使用DriverManager获取链接 Connection
        //serverTimezone=UTC 设置时区 报错的时候可以用 UTC世界统一时间
        //useUnicode=true&characterEncoding=UTF-8 解决中文乱码
        String url = "jdbc:mysql://192.168.1.12:3306/jianhang?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
        String url1 = "jdbc:mysql://192.168.1.12:3306/exam1?serverTimezone=UTC";

        String user = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println(connection.getClientInfo() );

        connection.setAutoCommit(false);


        // 3.执行语句

        //执行存储过程
        //String sql3 = "call add_student_course(2)";

        //在java中增删改 都是用executeUpdate，查询用executeQuery
        //preparedStatement 使用这个可以防止SQL注入，提供占位符功能？ 一般是使用这个
        //执行语句，返回受影响的数据条数。

//        //一般不使用，创建语句
        Statement statement = connection.createStatement();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //拼接SQL语句
        //增
        String sql = "insert into course(name) value('node.js')";
        String sql0 = "insert into course(name) value(?);";
        preparedStatement = connection.prepareStatement(sql0);
        preparedStatement.setString(1,"node.js");
       // System.out.println(preparedStatement.executeUpdate());

        //删
        String sql2 = "delete from course where name='node.js'";
        preparedStatement = connection.prepareStatement(sql2);
        //System.out.println(preparedStatement.executeUpdate());

        //改 shell -> shell.js
        String sql3 = "update course set name=? where id=12";
        preparedStatement = connection.prepareStatement(sql3);
        preparedStatement.setString(1,"shell.js");
        //System.out.println(preparedStatement.executeUpdate());

        //查
        String sql4 = "select * from course";
        //resultSet = statement.executeQuery(sql4);
        resultSet = connection.prepareStatement(sql4).executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString(2));
        }

        //5.关闭链接
        JDBCUtils.release(connection,preparedStatement,resultSet);
    }
}
