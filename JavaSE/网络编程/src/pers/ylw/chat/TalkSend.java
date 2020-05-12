package pers.ylw.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

//多线程
public class TalkSend implements Runnable{

    DatagramSocket socket = null;
    BufferedReader reader = null;

    private int fromPort;
    private String toIP;
    private int toPort;


    public TalkSend(int fromPort, String toIP, int toPort) {
        this.fromPort = fromPort;
        this.toIP = toIP;
        this.toPort = toPort;

        try {
            socket = new DatagramSocket(fromPort);
            reader = new BufferedReader(new InputStreamReader(System.in)); //控制台读取System.in
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            try {
                String data = reader.readLine(); //读取控制台输入的一行数据
                byte[] datas = data.getBytes(); //获取字节数组
                //打包数据
                DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress(this.toIP,this.toPort));

                //发送
                socket.send(packet);
                if (data.equals("bye")){ //跳出循环，断开连接
                    break;
                }

            } catch (Exception e){
                e.printStackTrace();
            }

        }

        //关闭
        socket.close();
    }
}
