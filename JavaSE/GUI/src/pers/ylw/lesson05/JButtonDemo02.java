package pers.ylw.lesson05;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo02 extends JFrame {

    public JButtonDemo02(){
        Container container = this.getContentPane();

        //单选框
        JRadioButton jRadioButton01 = new JRadioButton("JRadioButton01");
        JRadioButton jRadioButton02 = new JRadioButton("JRadioButton02");
        JRadioButton jRadioButton03 = new JRadioButton("JRadioButton03");
        //由于单选框只能选择一个，所以要分到一组里，一组里只能选一个
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton01);
        buttonGroup.add(jRadioButton02);
        buttonGroup.add(jRadioButton03);

        container.add(jRadioButton01,BorderLayout.NORTH);
        container.add(jRadioButton02,BorderLayout.CENTER);
        container.add(jRadioButton03,BorderLayout.SOUTH);

        this.setVisible(true);
        this.setSize(300,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new JButtonDemo02();
    }
}
