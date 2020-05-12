package pers.ylw.lesson01;

import java.net.InetAddress;
import java.net.UnknownHostException;

//测试IP
public class TestInetAddress {
    public static void main(String[] args) {
        try {
            //查询本机地址
            InetAddress inetAddress01 = InetAddress.getByName("127.0.0.1");//返回/127.0.0.1
            System.out.println(inetAddress01);
            InetAddress inetAddress02 = InetAddress.getByName("localhost");//返回localhost/127.0.0.1
            System.out.println(inetAddress02);
            InetAddress inetAddress03 = InetAddress.getLocalHost(); //返回计算机名/192开头ip
            System.out.println(inetAddress03);

            //查询网站ip地址
            InetAddress inetAddress04 = InetAddress.getByName("www.baidu.com");//返回www.baidu.com/14.215.177.38
            System.out.println(inetAddress04);

            //常用方法
            //System.out.println(inetAddress04.getAddress()); //返回一组地址，没什么用
            System.out.println(inetAddress04.getCanonicalHostName()); //返回规范ip
            System.out.println(inetAddress04.getHostAddress()); //返回ip地址
            System.out.println(inetAddress04.getHostName()); //获取域名，或计算机名

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
