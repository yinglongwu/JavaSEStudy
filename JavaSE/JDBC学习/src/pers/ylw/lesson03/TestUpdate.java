package pers.ylw.lesson03;

import pers.ylw.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestUpdate {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = JdbcUtils.getConnection();

            //注意PreparedStatement与Statement的区别
            //书写SQL语句,使用?占位符代替参数
            String sql = "update users set `NAME` = ? where id =?;";
            st = conn.prepareStatement(sql);//预编译sql，先写sql，然后不执行
            //手动给参数赋值,第一个参数是?的下标（从1开始），第二个参数是?的值
            st.setString(1,"zhangsan");
            st.setInt(2,1);

            //执行
            int i = st.executeUpdate();
            if (i>0){
                System.out.println("更新成功！");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn,st,null);
        }
    }
}
