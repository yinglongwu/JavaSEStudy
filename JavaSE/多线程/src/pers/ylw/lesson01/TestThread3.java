package pers.ylw.lesson01;

//创建线程方式2：实现Runnable接口，重写run方法，执行线程需要丢入runnable接口实现类，调用start方法
public class TestThread3 implements Runnable{

    @Override
    public void run() {
        //run 方法体
        for (int i = 0; i < 20; i++) {
            System.out.println("run方法--" + i);
        }
    }

    public static void main(String[] args) {
        //main 线程，主线程

        //创建runnable接口实现类对象
        TestThread3 testThread3 = new TestThread3();
        //创建线程对象，通过线程对象来开启我们的线程,代理
//        Thread thread = new Thread(testThread3);
//        thread.start(); //启动线程
        //可以简写成
        new Thread(testThread3).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("main线程--" +i);
        }
    }
}
