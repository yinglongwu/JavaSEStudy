package pers.ylw.lesson01;

//模拟龟兔赛跑
public class Race implements Runnable{

    //胜利者
    private static String winner;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {

            //模拟兔子休息，每10步休息一次
            if (Thread.currentThread().getName().equals("兔子") && i%10==0 ){
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            //判断比赛是否结束
            boolean flag = gameOver(i);

            //如果比赛结束了，就停止
            if (flag){
                break;
            }

            System.out.println(Thread.currentThread().getName()+"-->跑了"+i+"步");
        }
    }

    //判断是否到达终点完成比赛
    private boolean gameOver(int steps){
        //判断是否有胜利者
        if (winner!=null){ //注意字符串是一个类，判断为空
            return true;
        }else {
            if (steps >= 100){
                winner = Thread.currentThread().getName(); //获取线程名称
                System.out.println("winner is " + winner );
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }

}
