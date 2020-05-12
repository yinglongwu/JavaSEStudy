package pers.ylw.lesson01;

import java.awt.*;

//GUId的第一个界面
public class TestFrame {
    public static void main(String[] args) {

        //Frame对象，这时候new的窗口是在内存里的看不见
        Frame frame = new Frame("我的第一个Java图形界面窗口");

        //设置Frame窗口可见性
        frame.setVisible(true);

        //设置窗口大小
        frame.setSize(400,400);

        //设置弹出的初始位置
        frame.setLocation(200,200);

        //setBounds(x, y, w, h);和上面两行代码效果一样

        //设置窗口背景颜色,需要Color类
        frame.setBackground(new Color(248, 21, 87));

        //设置窗口大小固定(不能使用鼠标拖拽边界使窗口尺寸改变)
        frame.setResizable(false);

    }
}
