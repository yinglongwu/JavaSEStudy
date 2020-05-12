package pers.ylw.lesson01;

import java.awt.*;

public class ExDemo {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setVisible(true);
        frame.setSize(400,200);
        frame.setLocation(300,400);
        //frame.setBackground(new Color(1,1,1));
        //两行一列
        frame.setLayout(new GridLayout(2,1));

        //4个面板
        Panel pl = new Panel(new BorderLayout());
        Panel p2 = new Panel(new GridLayout(2,1));
        Panel p3 = new Panel(new BorderLayout());
        Panel p4 = new Panel(new GridLayout(2,2));

        //上半部分的左右两个按钮
        pl.add(new Button("East-1"),BorderLayout.EAST);
        pl.add(new Button("West-1"),BorderLayout.WEST);
        //上半部分的中间两个按钮
        p2.add(new Button("p2-btn-1"));
        p2.add(new Button("p2-btn-2"));
        //p2装到p1的中间部分
        pl.add(p2,BorderLayout.CENTER);

        //下半部分的左右两个按钮
        p3.add(new Button("East-2"),BorderLayout.EAST);
        p3.add(new Button("West-2"),BorderLayout.WEST);
        //下半部分的中间4个按钮
        for (int i = 0; i < 4; i++) {
            p4.add(new Button("p4-bnt-" + i));
        }
        //p4装到p3的中间部分
        p3.add(p4,BorderLayout.CENTER);

        //把面板放到frame里
        frame.add(pl);
        frame.add(p3);

    }
}
