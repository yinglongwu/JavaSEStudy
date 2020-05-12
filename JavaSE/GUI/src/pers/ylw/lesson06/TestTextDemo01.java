package pers.ylw.lesson06;

import javax.swing.*;
import java.awt.*;

public class TestTextDemo01 extends JFrame{
    public TestTextDemo01() {
        Container container = this.getContentPane();

        //文本框
        JTextField jTextField1 = new JTextField("hello");
        JTextField jTextField2 = new JTextField("world",20);

        container.add(jTextField1,BorderLayout.NORTH);
        container.add(jTextField2,BorderLayout.SOUTH);

        this.setSize(400,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestTextDemo01();
    }
}
