package pers.ylw.lesson03;

import pers.ylw.lesson02.utils.JdbcUtils;

import java.sql.*;

//测试PreparedStatement防止SQL注入
public class SQL注入 {
    public static void main(String[] args) {

        //正常登陆
        //login("zhangsan","123456");

        //sql注入
        login("''or 1=1","123456");

    }

    //登录业务
    public static void login(String username,String password){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        //PreparedStatement 防止SQL注入的本质，把传递进来的参数当做字符
        //假设其中存在转义字符，比如说'会被直接转义

        try {
            conn= JdbcUtils.getConnection(); //使用自己写的JdbcUtils类获取数据库连接

            //书写SQL语句
            String sql = "select * from users where `NAME` = ? AND `password` = ?"; //与Mybatis类似
            //预编译
            st = conn.prepareStatement(sql);
            //手动设置参数
            st.setString(1,username);
            st.setString(2,password);

            //执行sql查询语句，接收返回的结果集
            rs = st.executeQuery();
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
