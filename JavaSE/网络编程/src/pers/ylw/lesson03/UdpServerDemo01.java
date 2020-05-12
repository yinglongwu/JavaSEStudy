package pers.ylw.lesson03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//还得等待客户端的连接（别人给你发快递，你要存在（活着）才能接收）
public class UdpServerDemo01 {

    public static void main(String[] args) throws Exception {
        //开放端口
        DatagramSocket socket = new DatagramSocket(9090);
        //接收数据包
        byte[] buffer = new byte[1024];
        //这里后面两个参数不用写，接收不需要考虑从哪里来的，只管接收就好了
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        //接收
        socket.receive(packet); //阻塞接收

        //输出包里面的东西
        System.out.println(packet.getAddress().getHostAddress());
        System.out.println(new String(packet.getData(),0,packet.getLength()));

        //关闭连接
        socket.close();
    }
}
