package pers.ylw.lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//简易计算器
public class TestCalc {
    public static void main(String[] args) {
        new Calculator().loadFrame();
    }
}

//计算器类
class Calculator extends Frame{

    //属性
    TextField num1,num2,num3;

    //方法
    public void loadFrame(){
        //组件
        //3个文本框
        num1 = new TextField(10);//字符数
        num2 = new TextField(10);//字符数
        num3 = new TextField(20);//字符数
        //1个按钮
        Button button = new Button("=");
        //1个标签
        Label label = new Label("+");

        //组件需要的监听器
        button.addActionListener(new MyCalculatorListener());

        //布局
        setLayout(new FlowLayout());
        add(num1);
        add(label);
        add(num2);
        add(button);
        add(num3);

        pack();
        setVisible(true);
    }

    //监听器类
    //内部类的最大好处就是可以畅通无阻的访问外部类的属性和方法
    private class MyCalculatorListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //获得加数和被加数(使用了String转int)
            int n1 = Integer.parseInt(num1.getText());
            int n2 = Integer.parseInt(num2.getText());
            //执行+运算后放到num3中(使用了String转int)
            num3.setText(String.valueOf(n1+n2));
            //清除前两个num中的内容
            num1.setText("");
            num2.setText("");

        }
    }

}