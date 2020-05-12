package pers.ylw.lesson02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//服务端, 接收文件
public class TcpServerDemo02 {
    public static void main(String[] args) throws Exception {
        //1.创建服务
        ServerSocket serverSocket = new ServerSocket(9000);
        //2.监听客户端的连接
        Socket socket = serverSocket.accept();//阻断式监听，会一直等待客户端的连接
        //3.获取输入流
        InputStream is = socket.getInputStream();
        //4.文件输出，接收文件，用文件的管道流
        FileOutputStream fos = new FileOutputStream(new File("receive.jpg"));//输出时的文件名
        byte[] buffer = new byte[1024];
        int len;
        while ((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }

        //通知客户端我接收完毕了
        OutputStream os = socket.getOutputStream();
        os.write("我接受完毕了，你可以断开了".getBytes());


        //关闭资源
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();

    }
}
