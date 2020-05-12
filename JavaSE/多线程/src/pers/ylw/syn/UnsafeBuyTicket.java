package pers.ylw.syn;

//不安全的买票
//线程不安全，有重复的，有0，负数
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station,"抢票的你").start();
        new Thread(station,"抢票的他").start();
        new Thread(station,"可恶的黄牛党").start();
    }
}

class BuyTicket implements Runnable{

    private int ticketNums = 10; //票
    boolean flag = true; //外部停止方式

    @Override
    public void run() {
        //买票
        while (flag){
            buy();
        }
    }

    //synchronized 同步方法，锁的是this
    private synchronized void buy(){ //synchronized方法加锁
        //判断是否有票
        if (ticketNums<=0){
            flag = false;
            return;
        }
        //模拟延时
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //买票
        System.out.println(Thread.currentThread().getName()+"买到"+ticketNums--);
    }
}


