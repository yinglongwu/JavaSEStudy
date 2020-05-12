package pers.ylw.lesson05;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo01 extends JFrame {

    public JButtonDemo01(){
        Container container = this.getContentPane();
        //根据当前类的位置获取资源
        URL url = JButtonDemo01.class.getResource("tx.jpg");
        //将图片变为图标
        ImageIcon imageIcon = new ImageIcon(url);

        //把这个图标放在按钮上
        JButton jButton = new JButton();
        jButton.setIcon(imageIcon);
        jButton.setToolTipText("图片按钮"); //鼠标悬停提示

        container.add(jButton);

        this.setVisible(true);
        this.setSize(500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new JButtonDemo01();
    }
}
