package pers.ylw.lesson06;

import javax.swing.*;
import java.awt.*;

public class TestComboBoxDemo02 extends JFrame {
    public TestComboBoxDemo02() {
        Container container = this.getContentPane();

        //生成列表的内容
        String[] contents = {"1","2","3"};
        //列表中需要放入内容
        JList jList = new JList(contents);

        container.add(jList);

        this.setSize(200,200);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestComboBoxDemo02();
    }
}
