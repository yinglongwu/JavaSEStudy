package pers.ylw.lesson01;

import java.awt.*;

public class TestFlowLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();

        //组件-按钮，参数是按钮显示的文字
        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");

        //设置为流式布局, 括号里的参数可以填靠左、靠右等，不写默认居中
        //frame.setLayout(new FlowLayout());
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        frame.setSize(200,200);

        //把按钮放上去
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);

        //设置可见
        frame.setVisible(true);
    }
}
