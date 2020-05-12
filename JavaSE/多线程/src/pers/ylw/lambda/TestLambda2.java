package pers.ylw.lambda;

public class TestLambda2 {
    public static void main(String[] args) {

        //普通的lambda表达式
//        Ilove love = (int a)->{ //带参数的lambda表达式
//            System.out.println("I love you-->" + a);
//        };

        //lambda表达式简化1，省略参数类型(多个参数也可以去掉参数类型，要去掉就都去掉，必须加上括号)
//        Ilove love = (a)->{
//            System.out.println("I love you-->" + a);
//        };

        //lambda表达式简化2，简化参数括号(多个参数无法简化括号)
//        Ilove love = a ->{
//            System.out.println("I love you-->" + a);
//        };

        //lambda表达式简化3，简化花括号(多行代码无法简化)
        Ilove love = a -> System.out.println("I love you-->" + a);

        love.love(1);
    }
}

interface Ilove{
    void love(int a);
}
