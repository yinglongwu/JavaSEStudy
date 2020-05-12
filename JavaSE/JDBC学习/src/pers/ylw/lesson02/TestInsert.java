package pers.ylw.lesson02;

import pers.ylw.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn= JdbcUtils.getConnection(); //使用自己写的JdbcUtils类获取数据库连接
            st = conn.createStatement(); //获得SQL的执行对象

            //书写SQL语句
            String sql = "INSERT INTO users(`id`,`NAME`,`PASSWORD`,`email`,`birthday`)" +
                    "VALUES(4,'ylw','123456','123456@qq.com','2020-01-01')";

            //执行插入语句，接收返回值
            int i = st.executeUpdate(sql);
            if (i>0){
                System.out.println("插入成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally { //finally最后一定会执行
            JdbcUtils.release(conn,st,rs);
        }
    }
}
