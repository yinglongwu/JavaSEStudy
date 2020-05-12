package pers.ylw.reflection;

public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父类加载器-->扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取扩展类加载器的父亲加载器-->根加载器(c/c++)
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1); //这个类加载器无法直接获取，所以会得到null

        //测试当前类是哪个加载器加载的
        ClassLoader classLoader = Class.forName("pers.ylw.reflection.Test07").getClassLoader();
        System.out.println(classLoader);

        //测试JDK内置的类是谁加载的
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader); //这个类加载器无法直接获取，所以会得到null

        //如何获取系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
    }
}
