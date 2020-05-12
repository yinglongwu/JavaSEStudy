package pers.ylw.lesson05;

import javax.swing.*;
import java.awt.*;

public class JButtonDemo03 extends JFrame {

    public JButtonDemo03(){
        Container container = this.getContentPane();

        //多选框
        JCheckBox jCheckBox01 = new JCheckBox("jCheckBox01");
        JCheckBox jCheckBox02 = new JCheckBox("jCheckBox02");

        container.add(jCheckBox01,BorderLayout.NORTH);
        container.add(jCheckBox02,BorderLayout.SOUTH);

        this.setVisible(true);
        this.setSize(300,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new JButtonDemo03();
    }
}
