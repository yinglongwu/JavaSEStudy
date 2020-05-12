package pers.ylw.lambda;

//推导lambda表达式
//每一步都是对上一步的简化，直到jdk1.8有了lambda表达式
public class TestLambda1 {

    //第3步 静态内部类
    static class Like2 implements ILike{
        //重写接口方法
        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }

    public static void main(String[] args) {

        //正常调用2
        ILike like = new Like();
        like.lambda();

        //调用3静态内部类
        like = new Like2();
        like.lambda();

        //第4步 局部内部类
        class Like3 implements ILike{
            //重写接口方法
            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }

        //调用4局部内部类
        like = new Like3();
        like.lambda();

        //5匿名内部类，没有类的名称，必须借助接口或者父类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };
        like.lambda();

        //6.用lambda表达式简化
        like = () ->{
            System.out.println("I like lambda5");
        };
        like.lambda();

    }
}

//第1步 定义一个函数式接口
interface ILike{
    void lambda();
}

//第2步 实现类
class Like implements ILike{
    //重写接口方法
    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}
