package pers.ylw.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//动态的创建对象，通过反射
public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获得Class对象
        Class c1 = Class.forName("pers.ylw.reflection.User");

        //构造一个对象 newInstance过时代替
        User user = (User) c1.getDeclaredConstructor().newInstance(); //本质是调用类的无参构造器，没有无参构造则报错
        System.out.println(user);

        //通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user2 = (User) constructor.newInstance("姓名2", 001, 18);
        System.out.println(user2);

        //通过反射调用普通方法
        User user3 = (User) c1.getDeclaredConstructor().newInstance();
        //通过反射获取方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(user3,"姓名3"); //参数：对象，方法的参数值
        System.out.println(user3.getName());

        //通过反射操作属性
        User user4 = (User)c1.getDeclaredConstructor().newInstance();
        Field name = c1.getDeclaredField("name");
        name.setAccessible(true); //关闭安全检测，否则私有属性无法修改
        name.set(user4,"姓名4");
        System.out.println(user4.getName());
    }
}
