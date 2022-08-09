import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;

//数据库链接池 c3p0
public class c3p0_linajiechi {
    public static void main(String[] args) throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //链接数据库
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://192.168.1.12:3306/uushop?serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        //设置参数,初始化连接数，最大连接数，最小链接数，增量
        dataSource.setInitialPoolSize(20);
        dataSource.setMaxPoolSize(30);
        dataSource.setMinPoolSize(2);
        dataSource.setAcquireIncrement(5);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
