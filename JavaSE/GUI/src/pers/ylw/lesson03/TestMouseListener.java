package pers.ylw.lesson03;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

//鼠标监听事件
public class TestMouseListener {
    public static void main(String[] args) {
        new MyFrame("画图");
    }
}

//自己的类
class MyFrame extends Frame{
    //画画需要画笔，需要监听鼠标当前的位置，需要集合来存储这个点
    ArrayList points;

    public MyFrame(String title){ //title是窗口的名字
        super(title);
        setBounds(200,200,400,400);
        //存放鼠标点击的点
        points = new ArrayList();
        //鼠标监听事件，针对这个窗口啊
        this.addMouseListener(new MyMouseListener());

        setVisible(true);
    }

    //画笔,根据集合里存储的鼠标位置画点
    @Override
    public void paint(Graphics g) {
        //画画，监听鼠标事件
        Iterator iterator = points.iterator(); //获取集合的迭代器
        while(iterator.hasNext()){
           Point point = (Point) iterator.next(); //获取当前集合存储的位置，如果迭代器有下一个，迭代器移动到下一个
            g.setColor(Color.BLUE); //设置画笔颜色
            //画一个实心圆，把获取到的鼠标的位置传进去，作为圆的位置，后两个参数是圆的直径
            g.fillOval(point.x,point.y,10,10);
        }

    }

    //继承适配器，不需要重写全部方法
    private class MyMouseListener extends MouseAdapter{
        //鼠标：按下，按住不放，弹起

        //这里是按住不放的监听
        @Override
        public void mousePressed(MouseEvent e) {
            //MyFrame myFrame = (MyFrame) e.getSource();//e.getSource()返回当前对象，然后强转

            //e代表当前的鼠标，获取其坐标，添加到集合里
            points.add(new Point(e.getX(),e.getY()));

            //调用画点,刷新画板
            //myFrame.repaint(); //就是每点一下调用paint()方法
            repaint();
        }
    }
}