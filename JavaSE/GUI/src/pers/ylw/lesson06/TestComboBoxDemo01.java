package pers.ylw.lesson06;

import javax.swing.*;
import java.awt.*;

public class TestComboBoxDemo01 extends JFrame {

    public TestComboBoxDemo01(){
        Container container = this.getContentPane();

        JComboBox status = new JComboBox(); //status状态

        status.addItem(null);
        status.addItem("正在热映");
        status.addItem("已下架");
        status.addItem("即将上映");

        container.add(status);

        this.setSize(200,100);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestComboBoxDemo01();
    }
}
