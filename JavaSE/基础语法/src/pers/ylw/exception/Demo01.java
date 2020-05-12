package pers.ylw.exception;

public class Demo01 {
    public static void main(String[] args) {
        a();
    }

    //Java在执行程序时把方法压入栈
    //无限调用方法导致栈溢出异常StackOverflowError
    public static void a(){
        a();
    }
}
