package pers.ylw.thread;

import java.util.concurrent.locks.ReentrantLock;

//测试Lock锁
public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();

        new Thread(testLock2,"甲").start();
        new Thread(testLock2,"乙").start();
        new Thread(testLock2,"丙").start();

    }
}

class TestLock2 implements Runnable{

    private int ticketNums = 10; //票

    //定义Lock锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        //买票
        while (true){
            try{
                lock.lock(); //加锁
                //不安全的代码
                if (ticketNums>0){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ticketNums--);
                }else {
                    break;
                }
            }finally {
                //解锁
                lock.unlock();
            }
        }
    }


}
