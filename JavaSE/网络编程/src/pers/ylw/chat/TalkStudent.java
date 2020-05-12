package pers.ylw.chat;

public class TalkStudent {
    public static void main(String[] args) {
        //开启两个线程
        //确保发送目标端口是老师的接收端口
        new Thread(new TalkSend(7777,"localhost",9999)).start();
        new Thread(new TalkReceive(8888,"老师说")).start();
    }
}
