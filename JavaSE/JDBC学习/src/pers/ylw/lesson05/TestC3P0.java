package pers.ylw.lesson05;

import pers.ylw.lesson05.utils.JdbcUtils_C3P0;
import pers.ylw.lesson05.utils.JdbcUtils_DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class TestC3P0 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = JdbcUtils_C3P0.getConnection(); //只是改了这一行和最后关闭资源的时候，使用的类，其他的前面的笔记没有区别

            //注意PreparedStatement与Statement的区别
            //书写SQL语句,使用?占位符代替参数
            String sql = "insert into users(`id`,`NAME`,`PASSWORD`,`email`,`birthday`) values (?,?,?,?,?)";
            st = conn.prepareStatement(sql);//预编译sql，先写sql，然后不执行
            //手动给参数赋值,第一个参数是?的下标（从1开始），第二个参数是?的值
            st.setInt(1,4);
            st.setString(2,"ylw");
            st.setString(3,"123456");
            st.setString(4,"123456@qq.com");
            //注意时间转换,sql.Date数据库时间，util.Date Java时间，new Date().getTime()获得时间戳
            st.setDate(5,new java.sql.Date(new Date().getTime()));
            //执行
            int i = st.executeUpdate();
            if (i>0){
                System.out.println("插入成功！");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils_C3P0.release(conn,st,null); //关资源
        }
    }
}
