package pers.ylw.syn;

//不安全的取钱
//两个人去银行取钱，账户
public class UnsafeBank {
    public static void main(String[] args) {
        //账户
        Account account = new Account(100,"结婚基金");
        //取钱的人
        Drawing you = new Drawing(account, 50, "you");
        Drawing girlFriend = new Drawing(account, 100, "girlFriend");

        you.start();
        girlFriend.start();
    }
}

//账户
class Account{
    int money; //余额
    String name; //卡名

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行，模拟取钱
class Drawing extends Thread{
    Account account; //账户
    int drawingMoney; //取了多少钱
    int nowMoney; //现在手里的钱

    public Drawing(Account account,int drawingMoney,String name){
        super(name); //传给父类线程的名字
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    //取钱
    @Override
    public void run() { //这里不能在方法上加synchronized，synchronized 默认锁的是this
        synchronized (account){ //要使用同步块的方式，锁住account对象，锁住的对象要是变化的量
            //判断有账户里没有钱
            if (account.money-drawingMoney<0){
                System.out.println(Thread.currentThread().getName()+"钱不够，取不了");
                return;
            }

            //模拟延时，放大问题的发生性
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //卡内余额
            account.money = account.money - drawingMoney;
            //现在手里的钱
            nowMoney = nowMoney + drawingMoney;

            System.out.println(account.name+"余额为："+account.money);
            //Thread.currentThread().getName() = this.getName()
            System.out.println(this.getName() + "手里的钱：" + nowMoney);
        }

    }

}
