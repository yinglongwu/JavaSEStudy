package pers.ylw.lesson01;

import java.net.InetSocketAddress;

public class TestInetSocketAddress {
    public static void main(String[] args) {

        InetSocketAddress socketAddress01 = new InetSocketAddress("127.0.0.1", 8080);
        System.out.println(socketAddress01); //输出/127.0.0.1:8080

        InetSocketAddress socketAddress02 = new InetSocketAddress("localhost", 8080);
        System.out.println(socketAddress02); //输出localhost/127.0.0.1:8080

        System.out.println(socketAddress01.getAddress()); //输出/127.0.0.1
        System.out.println(socketAddress01.getHostName()); //输出你设置的127.0.0.1对应的域名，没设置就输出127.0.0.1
        System.out.println(socketAddress01.getPort()); //输出8080

    }
}
