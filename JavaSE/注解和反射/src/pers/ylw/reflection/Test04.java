package pers.ylw.reflection;

import java.lang.annotation.ElementType;

//所有类型的Class
public class Test04 {
    public static void main(String[] args) {
        Class c1 = Object.class;        //类
        Class c2 = Comparable.class;    //接口
        Class c3 = String[].class;      //一维数组
        Class c4 = int[][].class;       //二维数组
        Class c5 = Override.class;      //注解
        Class c6 = ElementType.class;   //枚举类型
        Class c7 = Integer.class;       //基本数据类型
        Class c8 = void.class;          //空
        Class c9 = Class.class;         //Class自己

        System.out.println("类-->" + c1);
        System.out.println("接口-->" + c2);
        System.out.println("一维数组-->" + c3);
        System.out.println("二维数组-->" + c4);
        System.out.println("注解-->" + c5);
        System.out.println("枚举类型-->" + c6);
        System.out.println("基本数据类型-->" + c7);
        System.out.println("空-->" + c8);
        System.out.println("Class自己-->" + c9);

        int[] a = new int[10];
        int[] b = new int[100];
        System.out.println(a.getClass().hashCode()); //这里发现hashCode一样
        System.out.println(b.getClass().hashCode()); //只要元素类型与维度一样，就是同一个Class
    }
}
