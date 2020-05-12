package pers.ylw.state;

//测试join方法，可以理解为插队
public class TestJoin implements Runnable{
    public static void main(String[] args) throws InterruptedException {

        //启动我们的线程
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        //主线程
        for (int i = 0; i < 100; i++) {
            if (i == 20){
                thread.join(); //插队,需要等这个插队的线程跑完主线程才能走
            }
            System.out.println("main" + i);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程vip来了" + i);
        }
    }
}
