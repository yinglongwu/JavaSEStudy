package pers.ylw.lesson01;

//创建主线程方式一：继承Thread类，重写run()方法，调用start开启线程
public class TestThread1 extends Thread{

    @Override
    public void run() {
        //run 方法体
        for (int i = 0; i < 20; i++) {
            System.out.println("run方法--" + i);
        }
    }

    public static void main(String[] args) {
        //main 线程，主线程

        //创建一个线程对象
        TestThread1 testThread1 = new TestThread1();
        //调用start方法开启线程
        //注意，线程开启不一定立即执行，由cpu调度执行
        testThread1.start();//如果调用run方法就是先后执行

        for (int i = 0; i < 20; i++) {
            System.out.println("main线程--" +i);
        }
    }
}
