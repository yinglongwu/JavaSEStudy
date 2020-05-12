package pers.ylw.lesson02.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL注入 {
    public static void main(String[] args) {

        //sql注入
        login("'or '1=1","'or'1=1");
        //注入语句拼接后为
        //select * from users where `NAME` =''or '1=1' AND `password` = ''or'1=1'
        //重点：`NAME` =''or '1=1' AND `password` = ''or'1=1' 等于空或者为true，永远正确

    }

    //登录业务
    public static void login(String username,String password){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn= JdbcUtils.getConnection(); //使用自己写的JdbcUtils类获取数据库连接
            st = conn.createStatement(); //获得SQL的执行对象

            //书写SQL语句
            //select * from users where `NAME` ='username' AND `password` = 'password'
            String sql = "select * from users where `NAME` ='"+username+"' AND `password` = '" + password+"'";

            //执行sql查询语句，接收返回的结果集
            rs = st.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getString("NAME"));
                System.out.println(rs.getString("password"));
                System.out.println("==================================");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally { //finally最后一定会执行
            JdbcUtils.release(conn,st,rs);
        }
    }
}
