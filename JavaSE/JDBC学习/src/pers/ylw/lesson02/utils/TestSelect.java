package pers.ylw.lesson02.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSelect {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn= JdbcUtils.getConnection(); //使用自己写的JdbcUtils类获取数据库连接
            st = conn.createStatement(); //获得SQL的执行对象

            //书写SQL语句
            String sql = "select * from users";

            //执行sql查询语句，接收返回的结果集
            rs = st.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getString("NAME"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally { //finally最后一定会执行
            JdbcUtils.release(conn,st,rs);
        }
    }
}
