package pers.ylw.annotation;

import java.lang.annotation.*;

//测试元注解
@MyAnnotation
public class Test02 {
    public static void main(String[] args) {

    }

    @MyAnnotation
    public void test(){

    }
}

//定义一个注解
//应该是 public @interface 注解名称 但是一个文件里只能有一个public类，所以就没写public修饰
//@Target 表示是注解可以用在哪些地方
@Target(value = {ElementType.METHOD,ElementType.TYPE}) //规定这个注解只能在方法和类上使用
@Retention(value = RetentionPolicy.RUNTIME) //表示注解在什么地方还有效，源码，字节码class文件或者运行时
//范围： RUNTIME > CLASS > SOURCE
@Documented //表示是否将注解生成在JavaDoc中
@Inherited //表示子类可以继承父类的注解
@interface MyAnnotation{

}