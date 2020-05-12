package pers.ylw.lesson05;

import javax.swing.*;
import java.awt.*;

public class JScrollDemo extends JFrame {

    public JScrollDemo(){
        Container container = this.getContentPane();

        //文本域，和文本框不同，支持多行
        JTextArea jtextArea = new JTextArea(20,50);
        jtextArea.setText("我是文字");

        //Scroll面板
        JScrollPane jScrollPane = new JScrollPane(jtextArea);
        container.add(jScrollPane);

        this.setVisible(true);
        this.setBounds(100,100,300,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new JScrollDemo();
    }
}
