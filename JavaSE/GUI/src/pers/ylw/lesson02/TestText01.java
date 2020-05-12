package pers.ylw.lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestText01 {
    public static void main(String[] args) {
        //编程思想: 主方法只放一个启动程序
        new MyFrame();
    }
}

class MyFrame extends Frame{
    public MyFrame(){
        //TextArea, 文本域，可以写多行文本
        TextField textField = new TextField();//单行文本
        //因为继承了Frame, 直接add就行
        add(textField);

        //监听文本框
        MyActionListener myActionListener = new MyActionListener();
        //按下enter触发事件
        textField.addActionListener(myActionListener);
        //设置输入文本的替换编码
        textField.setEchoChar('*'); //如密码用*替代

        pack();
        setVisible(true);
    }
}

class MyActionListener implements ActionListener{

    //敲回车出发文本框事件
    @Override
    public void actionPerformed(ActionEvent e) {
       TextField field = (TextField)e.getSource(); //获得资源，返回一个对象，强转为TextField类
        System.out.println(field.getText());//获取输入框中的文本(显示在控制台)
        field.setText("");//设置为空
    }
}