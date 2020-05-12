package pers.ylw.lesson04;

import pers.ylw.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestTransaction01 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            conn = JdbcUtils.getConnection();
            // 关闭数据库的自动提交功能,同时自己会开启事务，不需要像在SQL里那样写开启事务了
            conn.setAutoCommit(false); //同时会自动开启事务

            String sql01 = "update account set money = money-100 where name = 'A'";
            st = conn.prepareStatement(sql01);
            st.executeUpdate();

            //模拟中途失败,测试后发现第一个SQL语句也没有执行成功，说明事务的好处
            //int x = 1/0;

            String sql02 = "update account set money = money+100 where name = 'B'";
            st = conn.prepareStatement(sql02);
            st.executeUpdate();

            //业务完毕，提交事务
            conn.commit();
            System.out.println("操作成功");
        } catch (SQLException e){
            //不写回滚，失败也会默认回滚，但最好写上
            try {
                conn.rollback();//如果发生异常就回滚
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
}
