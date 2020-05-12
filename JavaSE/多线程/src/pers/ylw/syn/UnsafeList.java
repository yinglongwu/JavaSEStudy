package pers.ylw.syn;

import java.util.ArrayList;
import java.util.List;

//线程不安全的集合
public class UnsafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        //模拟延时
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size()); //这里会发现集合的大小比10000小
        // 因为可能在一个瞬间有两个线程操作了同一个位置，导致覆盖，也就是说List是不安全的
    }
}
