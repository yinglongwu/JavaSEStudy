package pers.ylw.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpSenderDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8888);

        //准备数据：控制台读取System.in
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String data = reader.readLine(); //读取控制台输入的一行数据
            byte[] datas = data.getBytes(); //获取字节数组
            //打包数据
            DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",6666));

            //发送
            socket.send(packet);

            if (data.equals("bye")){ //跳出循环，断开连接
                break;
            }
        }

        //关闭
        socket.close();
    }
}
