package pers.ylw.lesson02;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class TcpServerDemo01 {
    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
            //1.需要一个地址（插槽）让客户端连接
            serverSocket = new ServerSocket(9999);
            while (true) { //不停的监听客户端是否发出连接请求
                //2.等待客户端连接, 这里的socket是接收客户端连过来的
                socket = serverSocket.accept();
                //3.读取客户端的消息, 服务端接收客户端的输入
                is = socket.getInputStream();
                //正常写法，使用管道流(在客户端的输出流和服务端的输入流之间，加一个管道用来修正)
                baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = is.read(buffer)) != -1){
                    baos.write(buffer,0,len);
                }
                System.out.println(baos.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源,倒着关流,先开后关,处理异常
            if (baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

//这样写有一个问题，如果是中文超出字节就会乱码
//            byte[] buffer = new byte[1024];
//            int len;
//            while ((len = is.read(buffer)) != -1){
//                String msg = new String(buffer,0,len);
//                System.out.println(msg);
//            }
