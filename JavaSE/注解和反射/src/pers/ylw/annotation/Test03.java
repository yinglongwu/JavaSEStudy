package pers.ylw.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解
public class Test03 {

    //注解可以显式赋值， 如果没有默认值，我们就必须给注解赋值
    @MyAnnotation2(name = "名字", age=18)
    public void test(){

    }

}

@Target(value = {ElementType.TYPE,ElementType.METHOD}) //规定这个注解只能在类和方法上使用
@Retention(RetentionPolicy.RUNTIME) //表示注解在运行时还有效，源码，字节码class文件或者运行时
@interface MyAnnotation2{
    //注解的参数：参数类型+参数名();
    //String name();
    //String name() default ""; 参数默认为空
    String name () default "";
    int age() default 0;
    int id() default -1; //如果默认值为-1，代表不存在

    String[] schools() default {"北京大学","清华大学"};
}

@Target(value = {ElementType.TYPE,ElementType.METHOD}) //规定这个注解只能在类和方法上使用
@Retention(RetentionPolicy.RUNTIME) //表示注解在运行时还有效，源码，字节码class文件或者运行时
@interface MyAnnotation3{
    String value(); //使用value在赋值时不需要写出来value="";
}