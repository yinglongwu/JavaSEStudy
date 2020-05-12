package pers.ylw.lesson03;

import java.awt.*;

public class TestPaint {
    public static void main(String[] args) {
        new MyPaint().loadFrame();
    }
}

class MyPaint extends Frame{

    public void loadFrame(){
        setBounds(200,200,600,500);
        setVisible(true);
    }

    //重写Frame自带的画笔paint方法
    @Override
    public void paint(Graphics g) {
        //画笔，需要颜色，可以画画
        g.setColor(Color.red);
        g.drawOval(100,100,100,100); //空心圆
        g.fillOval(200,100,100,100); //实心圆

        g.setColor(Color.blue);
        g.fillRect(100,200,200,200); //实心矩形

        //养成习惯，画笔用完要还原最初的颜色
    }
}