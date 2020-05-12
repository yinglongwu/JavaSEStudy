package pers.ylw.lesson06;

import javax.swing.*;
import java.awt.*;

public class TestTextDemo02 extends JFrame{
    public TestTextDemo02() {
        Container container = this.getContentPane();

        //密码框
        JPasswordField jPasswordField = new JPasswordField(); //默认显示为···
        //jPasswordField.setEchoChar('*');//设置替换字符

        container.add(jPasswordField);

        this.setSize(400,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestTextDemo02();
    }
}
