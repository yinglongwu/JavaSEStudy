package pers.ylw.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable{

    DatagramSocket socket = null;
    private int port;
    private String msgFrom;

    public TalkReceive(int port,String msgFrom) {
        this.port = port;
        this.msgFrom = msgFrom;
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while(true){
            try {
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
                System.out.println(msgFrom + ": " + receiveData);

                if (receiveData.equals("bye")){//断开连接
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //断开
        socket.close();
    }
}
