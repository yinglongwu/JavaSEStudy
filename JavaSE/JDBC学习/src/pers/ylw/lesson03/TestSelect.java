package pers.ylw.lesson03;

import pers.ylw.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSelect {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();

            //注意PreparedStatement与Statement的区别
            //书写SQL语句,使用?占位符代替参数
            String sql = "select * from users where id =?";
            st = conn.prepareStatement(sql);//预编译sql，先写sql，然后不执行
            //手动给参数赋值,第一个参数是?的下标（从1开始），第二个参数是?的值
            st.setInt(1,1);

            //执行
            rs = st.executeQuery();

            //打印查询结果
            while (rs.next()){
                System.out.println(rs.getString("NAME"));
                System.out.println(rs.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
}
