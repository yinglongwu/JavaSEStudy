package pers.ylw.lesson01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//panel可以看成是一个空间，但是不能单独存在
public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame();
        //panel 有布局的概念
        Panel panel = new Panel();

        //设置布局
        frame.setLayout(null);

        //坐标和颜色
        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(213, 11, 11));

        //panel设置坐标，相对于frame
        panel.setBounds(50,50,400,400);
        panel.setBackground(new Color(137, 77, 220));

        //在frame里添加panel
        frame.add(panel);//查看panel源码可以看到它继承了Component所以可以添加

        //设置可见性
        frame.setVisible(true);

        //监听事件，监听窗口关闭事件
        //如果new WindowListener,需要重写很多方法
        //所以使用适配器模式new WidowAdapter，只需要重写自己想使用的方法就可以了
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //窗口点击关闭的时候需要做的事情
                System.exit(0);
            }
        });

    }
}
