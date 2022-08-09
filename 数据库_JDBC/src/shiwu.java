import java.sql.Connection;
import java.sql.PreparedStatement;
//事务，互换两个人的系，两个人的系必须同时替换。try catch 包围所有代码，出现异常就回滚
//jdbc中 是默认自动提交的 就是执行一个staement 之后自动执行commit 。所以要多条语句的时候要关闭自动提交
public class shiwu {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        try {
            connection = JDBCUtils.getConnection();
            //1.关闭自动提交
            connection.setAutoCommit(false);

            System.out.println(connection.getClientInfo());
            //126,软件工程,许云飞
            //127,经济管理,陈磊
            String sql = "update reader set r_unit = ? where r_no=?";

            //许云飞 软件工程 变 计算机
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"软件工程");
            preparedStatement.setInt(2,126);
            int i = preparedStatement.executeUpdate();
            System.out.println(i);

            //控制是否中断
            int o = 10/10;

            //陈磊 经济管理 变软件工程
            preparedStatement1 = connection.prepareStatement(sql);
            preparedStatement1.setString(1,"经济管理");
            preparedStatement1.setInt(2,127);
            i = preparedStatement1.executeUpdate();
            System.out.println(i);

            //事务提交，所有语句执行完提交
            connection.commit();
        } catch (Exception throwables) {
           //事物回滚
            connection.rollback();
            throwables.printStackTrace();
        }finally {
            JDBCUtils.release(connection,preparedStatement,null);
            JDBCUtils.release(null,preparedStatement1,null);
        }
    }
}
