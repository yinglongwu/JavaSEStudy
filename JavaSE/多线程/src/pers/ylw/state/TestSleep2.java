package pers.ylw.state;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSleep2 {
    public static void main(String[] args) {
        //tenDown();
        NowTime();

    }

    //模拟倒计时
    public static void tenDown(){
        int num =10;
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(num--);
            if (num<=0){
                break;
            }
        }
    }

    //打印当前系统的时间
    public static void NowTime(){
        Date startTime = new Date(System.currentTimeMillis());//获取当前系统时间
        while (true){
            try {
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                Thread.sleep(1000);
                startTime = new Date(System.currentTimeMillis());//更新时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
