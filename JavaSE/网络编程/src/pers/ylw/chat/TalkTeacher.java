package pers.ylw.chat;

public class TalkTeacher {
    public static void main(String[] args) {
        //开启两个线程
        //确保发送目标端口是学生的接收端口
        new Thread(new TalkSend(5555,"localhost",8888)).start();
        new Thread(new TalkReceive(9999,"学生说")).start();
    }
}
