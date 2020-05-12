package pers.ylw.lesson01;

import java.sql.*;

// 我的第一个JDBC程序
public class JdbcDemo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());不推荐
        Class.forName("com.mysql.jdbc.Driver"); //固定写法

        //2.用户信息和url
        //useUnicode=true&characterEncoding=utf8mb4&useSSL=true添加参数，支持中文编码&设置字符集&安全连接
        //报错：java.security.cert.CertPathValidatorException: Path does not chain with any of the trust anchors
        //没有证书，设置useSSL=false
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=false";
        String username = "root";
        String password = "123456";

        //3.连接成功，返回一个数据库对象
        //驱动管理，获得连接,connection代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);

        //4.获取执行SQL的对象,statement 执行sql用的对象
        Statement statement = connection.createStatement();


        //5.执行SQL对象去执行sql
        //写SQL语句
        String sql = "SELECT * FROM users";
        //使用执行SQL的对象statement去执行查询语句，并接收结果
        ResultSet resultSet = statement.executeQuery(sql); //返回结果集，封装了全部的查询结果

        while(resultSet.next()){ //resultSet.getObject()里的列名和数据库里的要一致
            System.out.println("id=" + resultSet.getObject("id"));
            System.out.println("name=" + resultSet.getObject("NAME"));
            System.out.println("pwd=" + resultSet.getObject("PASSWORD"));
            System.out.println("email=" + resultSet.getObject("email"));
            System.out.println("birthday=" + resultSet.getObject("birthday"));
            System.out.println("=============================================");
        }

        //6.释放连接（释放顺序，后使用的先释放）
        resultSet.close();
        statement.close();
        connection.close();

    }
}
