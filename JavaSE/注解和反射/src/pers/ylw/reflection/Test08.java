package pers.ylw.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//获得类的信息
public class Test08 {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {

        User user = new User();
        Class c1 = user.getClass();
        //Class c1 = Class.forName("pers.ylw.reflection.User");

        //获得类的名字
        System.out.println(c1.getName()); //获得包名 + 类名
        System.out.println(c1.getSimpleName()); //获得类名

        //获得类的属性
        System.out.println("=========================");
//        Field[] fields = c1.getFields(); //只能找到public属性
//        for (Field field : fields) {
//            System.out.println(field); 打印不出来，
//        }

        System.out.println("=========================");
        Field[] fields = c1.getDeclaredFields(); //可以找到全部的属性
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("=========================");
        //获得指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        //获得类的方法
        System.out.println("=========================");
        Method[] methods = c1.getMethods(); //获得本类及其父类的全部public方法
        for (Method method : methods){
            System.out.println("getMethods："+method);
        }
        methods = c1.getDeclaredMethods(); //获得本类的所有方法
        for (Method method : methods){
            System.out.println("getDeclaredMethods："+method);
        }

        //获得指定方法,为什么要传参数，因为有的方法会重载
        System.out.println("=========================");
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);

        //获得构造器
        System.out.println("=========================");
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("getConstructors-->"+constructor);
        }
        Constructor[] declaredConstructors = c1.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println("getDeclaredConstructors-->"+declaredConstructor);
        }

        //获得指定构造器
        System.out.println("=========================");
        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println("指定构造器："+declaredConstructor);
    }
}
