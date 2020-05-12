package pers.ylw.lesson03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//Udp不需要连接服务器
public class UdpClientDemo01 {
    public static void main(String[] args) throws Exception {
        //1.建立一个Socket
        DatagramSocket socket = new DatagramSocket();

        //2.建个包
        String msg = "你好啊，服务器！"; //包的内容
        //发送给谁
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9090;
        //参数解释: 包内的数据（转为字节数组），数据字节数组的起始，数据字节数组的结束，目标ip，端口
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);

        //3.发送包
        socket.send(packet);

        //4.关闭流
        socket.close();
    }
}
