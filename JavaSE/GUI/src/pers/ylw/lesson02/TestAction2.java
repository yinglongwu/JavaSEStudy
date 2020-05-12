package pers.ylw.lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//两个按钮，共享一个监听类
public class TestAction2 {
    public static void main(String[] args) {

        Frame frame = new Frame("开始-停止");
        Button button1 = new Button("start");
        Button button2 = new Button("stop");

        //设置按钮触发时返回的命令，不设置默认为button的label
        //可以多个按钮只写一个监听类，在类里根据返回的命令判断执行什么
        button2.setActionCommand("button2-stop");

        MyMonitor myMonitor = new MyMonitor();
        button1.addActionListener(myMonitor);
        button2.addActionListener(myMonitor);

        frame.add(button1,BorderLayout.NORTH);
        frame.add(button2,BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}

class MyMonitor implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        //getActionCommand()获取前面的setActionCommand(), 可以与if结合使用来进行不同的操作
        System.out.println("按钮被点击了：msg=>" + e.getActionCommand());
    }
}
