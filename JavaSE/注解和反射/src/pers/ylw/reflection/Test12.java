package pers.ylw.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

//练习反射操作注解
public class Test12 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("pers.ylw.reflection.Student2");

        //通过反射获取注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        //获得注解的value的值
        Tableylw tableylw = (Tableylw)c1.getAnnotation(Tableylw.class);
        String value = tableylw.value();
        System.out.println(value);

        //获得类的指定注解
        Field f = c1.getDeclaredField("name");
        Fieldylw annotation = f.getAnnotation(Fieldylw.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());

    }
}

@Tableylw("db_student")
class Student2{

    @Fieldylw(columnName = "db_id",type = "int",length = 10)
    private int id;
    @Fieldylw(columnName = "db_age",type = "int",length = 10)
    private int age;
    @Fieldylw(columnName = "db_name",type = "varchar",length = 3)
    private String name;

    public Student2() {
    }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Tableylw{
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Fieldylw{
    String columnName();
    String type();
    int length();
}
