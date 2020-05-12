package pers.ylw.lesson01;

//多个线程同时操作一个对象
//买票例子

//发现问题，多个线程操作同一个资源的情况下，线程不安全，数据紊乱
public class TestThread4 implements Runnable {

    //票数
    private int ticketNums = 10;

    @Override
    public void run() {
        while(true){

            if (ticketNums<=0){
                break;
            }

            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Thread.currentThread()返回线程本身，getName()获得线程的名字
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketNums--+"票");
        }
    }

    public static void main(String[] args) {
        TestThread4 testThread4 = new TestThread4();

        new Thread(testThread4,"小明").start();
        new Thread(testThread4,"老师").start();
        new Thread(testThread4,"黄牛党").start();
    }
}
