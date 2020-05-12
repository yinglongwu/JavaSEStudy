package pers.ylw.reflection;

public class Test05 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.m); //100

        /*
        1.加载到内存，会产生一个类对应的class对象
        2.连接，连接结束后 m = 0
        3.初始化，执行
            <clinit>(){
                System.out.println("A类静态代码块初始化");
                m = 300;
                m = 100;
            }
           所以得到的 m = 100
         */
    }
}

class A{
    static {
        System.out.println("A类静态代码块初始化");
        m = 300;
    }
    static int m = 100;

    /*
    * 准备阶段 m = 0
    * m = 300
    * m = 100
    * */

    public A(){
        System.out.println("A类的无参构造初始化");
    }
}
