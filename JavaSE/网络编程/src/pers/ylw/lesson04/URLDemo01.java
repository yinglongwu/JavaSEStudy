package pers.ylw.lesson04;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo01 {
    public static void main(String[] args) throws MalformedURLException {
        //问号后面是参数
        URL url = new URL("http://localhost:8080/helloword/index.jsp?username=ylw&password=123");
        //常用方法
        System.out.println(url.getProtocol()); //协议
        System.out.println(url.getHost()); //主机ip
        System.out.println(url.getPort()); //端口
        System.out.println(url.getPath()); //文件
        System.out.println(url.getFile()); //文件带参数
        System.out.println(url.getQuery()); //参数
    }
}
