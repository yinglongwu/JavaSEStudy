package pers.ylw.lesson01;

import java.awt.*;

public class TestFrame2 {
    public static void main(String[] args) {
        //展示多个窗口
        MyFrame myFrame1 = new MyFrame(100, 100, 200, 200, Color.blue);
        MyFrame myFrame2 = new MyFrame(300, 100, 200, 200, Color.yellow);
        MyFrame myFrame3 = new MyFrame(100, 300, 200, 200, Color.red);
        MyFrame myFrame4 = new MyFrame(300, 300, 200, 200, Color.black);
    }
}

class MyFrame extends Frame{
    static int id = 0; //可能存在多个窗口，需要一个计数器

    //封装TextFrame类,x和y是窗口初始位置，w和h是宽高
    public MyFrame(int x,int y,int w,int h,Color color){
        super("我的Frame"+(++id));
        //设置窗口在屏幕的位置和窗口的宽高
        setBounds(x, y, w, h);
        //设置Frame窗口可见性
        setVisible(true);
        //设置颜色
        setBackground(color);
    }
}
