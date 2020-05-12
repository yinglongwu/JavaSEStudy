package pers.ylw.lesson05;

import javax.swing.*;
import java.awt.*;

public class JPanelDemo extends JFrame {

    public JPanelDemo(){
        Container container = this.getContentPane();
        //设置网格布局，前两个参数是行和列，后面两个参数是上下间距和左右间距
        container.setLayout(new GridLayout(2,1,10,10));

        JPanel jPanel = new JPanel(new GridLayout(1,3));
        JPanel jPane2 = new JPanel(new GridLayout(1,2));
        JPanel jPane3 = new JPanel(new GridLayout(2,1));
        JPanel jPane4 = new JPanel(new GridLayout(3,2));

        jPanel.add(new JButton("1"));
        jPanel.add(new JButton("1"));
        jPanel.add(new JButton("1"));
        jPane2.add(new JButton("2"));
        jPane2.add(new JButton("2"));
        jPane3.add(new JButton("3"));
        jPane3.add(new JButton("3"));
        jPane4.add(new JButton("4"));
        jPane4.add(new JButton("4"));
        jPane4.add(new JButton("4"));

        container.add(jPanel);
        container.add(jPane2);
        container.add(jPane3);
        container.add(jPane4);

        this.setVisible(true);
        this.setBounds(100,100,500,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JPanelDemo();
    }

}
