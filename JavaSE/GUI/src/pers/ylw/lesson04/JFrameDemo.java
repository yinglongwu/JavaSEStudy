package pers.ylw.lesson04;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo {

    //init() 初始化
    public void init(){
        JFrame jFrame = new JFrame("这是一个JFrame窗口");
        jFrame.setVisible(true);
        jFrame.setBounds(100,100,300,300);

        //设置文字标签
        JLabel jLabel = new JLabel("文字");
        jLabel.setHorizontalAlignment(SwingConstants.CENTER); //设置水平对齐,SwingConstants.CENTER居中
        jFrame.add(jLabel);

        //获得容器,在这里面设置颜色之类的才有效
        Container container = jFrame.getContentPane();
        container.setBackground(Color.YELLOW);


        //关闭事件,和AWT不同的是，这里已经帮我们写好了关闭事件
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //默认关闭事件,EXIT_ON_CLOSE是程序关闭，窗口关闭
    }

    public static void main(String[] args) {
        new JFrameDemo().init();
    }
}
