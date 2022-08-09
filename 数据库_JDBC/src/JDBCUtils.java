import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.*;

//JDBC 工具类 实现获取链接和释放资源，所有方法和属性都是静态的通过类就可以直接使用

public class JDBCUtils {
    private static String url = "jdbc:mysql://192.168.1.12:3306/uushop?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
    private static String user = "root";
    private static String password = "123456";

    //1.获取链接
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    };
    //获取数据库连接池的链接
    public static Connection getConnection1(){
        Connection connection = null;
        ComboPooledDataSource dataSource = null;
        try {
            dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl(url);
            dataSource.setUser(user);
            dataSource.setPassword(password);
            //初始化连接数，最大连接数，最小连接数，增量
            dataSource.setInitialPoolSize(20);
            dataSource.setMinPoolSize(30);
            dataSource.setMinPoolSize(2);
            dataSource.setAcquireIncrement(5);
            connection = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    //.释放资源
    public static void release(Connection connection, Statement statement, ResultSet resultSet){
        //如果链接存在就关闭
        try {
            if (connection != null) connection.close();
            if (statement != null) statement.close();
            if (resultSet != null) resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
