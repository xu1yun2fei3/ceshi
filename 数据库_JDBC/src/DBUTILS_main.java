import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;

/*
* dbutils:
* 1.执行SQL
* 2.封装结果
* */
public class DBUTILS_main {
    public static void main(String[] args) throws Exception{
        QueryRunner runner = new QueryRunner();
        Connection connection = JDBCUtils.getConnection();

        //增
        String sql1 = "insert into borrow values(?,?,?)";
        //System.out.println(runner.update(connection, sql1, 118, 118801, "2023-09-10"));
        //改 126,软件工程,许云飞, 男, 学生,3号楼
        String sql2 = "update reader set r_pro=? where r_no=?";
        //System.out.println(runner.update(connection, sql2, "教师", 126));
        //删除
        String sql3 = "delete from reader where r_no=?";
        System.out.println(runner.update(connection, sql3, 127));

        String sql = "select * from borrow";
//        BeanListHandler多条数据,BeanHandler一条数据
        List<DBUTILS_borrow> list = runner.query(connection,sql, new BeanListHandler<DBUTILS_borrow>(DBUTILS_borrow.class));
        for (DBUTILS_borrow borrow : list) {
            System.out.println(borrow);
        }

    }
}
