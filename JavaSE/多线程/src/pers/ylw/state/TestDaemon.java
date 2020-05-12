package pers.ylw.state;

//测试守护线程，举例：上帝守护你
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true); //设置上帝为守护线程，不设置默认为false用户线程
        thread.start(); //上帝守护线程启动

        new Thread(you).start();//你用户线程启动
        // （用户线程执行完毕后，虚拟机就关闭了，但是有延迟所以守护线程还是运行了一会）
    }
}

//上帝，守护线程
class God implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("上帝保佑着你");
        }
    }
}


//你，用户线程
class You implements Runnable{

    @Override
    public void run() {
        System.out.println("==========hello world==========");
        for (int i = 0; i < 36500; i++) {
            System.out.println("你一生都开心的活着");
        }
        System.out.println("==========goodbye world==========");
    }
}