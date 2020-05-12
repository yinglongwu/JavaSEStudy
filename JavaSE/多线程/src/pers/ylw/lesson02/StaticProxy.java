package pers.ylw.lesson02;

//静态代理
//举例：婚庆服务就可以看做代理
public class StaticProxy {
    public static void main(String[] args) {
        //多线程
        You you = new You(); //你要结婚
        new Thread(()-> System.out.println("我爱你")).start();//lambda表达式
        new WeddingCompany(new You()).HappyMarry();

        //正常写
        //WeddingCompany weddingCompany = new WeddingCompany(new You());
        //weddingCompany.HappyMarry();
    }
}

interface Marry{
    void HappyMarry();
}

//真实角色，你去结婚
class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("xxx结婚了！");
    }
}

//代理角色，婚庆公司提供婚庆服务帮助你结婚
class WeddingCompany implements Marry{

    //代理谁
    private Marry target; //婚庆公司的目标对象，真实对象

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚之后，结尾款");
    }

    private void before() {
        System.out.println("结婚之前，布置现场");
    }
}
