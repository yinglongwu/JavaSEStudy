package pers.ylw.lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestActionEvent {

    public static void main(String[] args) {
        Frame frame = new Frame();
        Button button = new Button();

        //按下按钮，触发事件
        //因为addActionListener()需要一个ActionListener,所以我们需要构造一个ActionListener
        MyActionListener0 myActionListener0 = new MyActionListener0();
        button.addActionListener(myActionListener0);

        frame.add(button,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        windowClose(frame); //关闭窗口，自定义方法

    }

    //关闭窗体事件
    private static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

//事件监听，自己写一个类实现接口
class MyActionListener0 implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}
