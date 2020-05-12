package pers.ylw.reflection;

//测试类什么时候会初始化
public class Test06 {

    static {
        System.out.println("main类被初始化");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //1.主动引用
        //Son son = new Son();

        //2.反射也会产生主动引用
        //Class.forName("pers.ylw.reflection.Son");

        //不会产生类的引用的方法
        //System.out.println(Son.b); //子类调用父类静态属性，子类不会被初始化

        //Son[] array = new Son[5];

        System.out.println(Son.M); //常量不会引起父类跟子类的初始化


    }
}

class Father{
    static int b = 2;
    static {
        System.out.println("父类被初始化");
    }

}

class Son extends Father{
    static {
        System.out.println("子类被初始化");
        m = 300;
    }

    static int m = 100;
    static final int M = 1;
}
