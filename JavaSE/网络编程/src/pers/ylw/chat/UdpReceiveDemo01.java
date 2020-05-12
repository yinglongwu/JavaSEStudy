package pers.ylw.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiveDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(6666);

        while(true){
            //准备接收包裹的容器
            byte[] bytes = new byte[1024]; //亲测，一个汉字3个字节
            DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length);
            socket.receive(packet); //阻塞式接收

            //获取接收的数据
            byte[] data = packet.getData();
            //注意这里接收时要用packet.getLength()
            String receiveData = new String(data,0,packet.getLength());
            //使用data.lenght，在调试时会发现最右边少一个引号，导致下面的equals一致判断错误
            //String receiveData = new String(data,0,data.length);
            System.out.println(receiveData);

            if (receiveData.equals("bye")){//断开连接
                break;
            }
        }

        //断开
        socket.close();
    }
}
