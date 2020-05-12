package pers.ylw.lesson03;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestWindow {
    public static void main(String[] args) {
        new WindowFrame();
    }
}

//自己的窗口类
class WindowFrame extends Frame{
    public WindowFrame(){
        setBackground(Color.blue);
        setBounds(100,100,400,200);
        setVisible(true);
        //addWindowListener(new MyWindowListener());

        //使用内部类，这里重写常用方法测试一下，平时Adapter只需要重写需要的方法就可以了
        this.addWindowListener(new WindowAdapter() {
            //关闭窗口时,就是点击X时
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0); //正常退出，窗口关闭，程序退出
                System.out.println("windowClosing");
            }

            //窗口激活，就是选中时
            @Override
            public void windowActivated(WindowEvent e) {
                WindowFrame windowFrame = (WindowFrame) e.getSource();
                windowFrame.setTitle("被激活了");
                //上面两行可以简写为
                //setTitle("被激活了");
                System.out.println("windowActivated");
            }

            //不好获取状态，不常用
//            @Override
//            public void windowOpened(WindowEvent e) {
//                System.out.println("windowOpened");
//            }

            //关闭掉之后，不好获取状态，不常用
//            @Override
//            public void windowClosed(WindowEvent e) {
//                System.out.println("windowClosed");
//            }

            //下面两个方法跟图标相关的
//            @Override
//            public void windowIconified(WindowEvent e) {
//                System.out.println("windowIconified");
//            }
//            @Override
//            public void windowDeiconified(WindowEvent e) {
//                System.out.println("windowDeiconified");
//            }
            //状态改变
//            @Override
//            public void windowStateChanged(WindowEvent e) {
//                System.out.println("windowStateChanged");
//            }

        });

    }

    //使用内部类就不需要这个了
    //窗口的监听器，继承适配器，就不需要重写全部的方法了
    class MyWindowListener extends WindowAdapter{
        //点击窗口的X
        @Override
        public void windowClosing(WindowEvent e) {
            //setVisible(false); //窗口隐藏，不是关闭，还存在进程里
            System.exit(0); //正常退出，窗口关闭，程序退出
        }
    }
}