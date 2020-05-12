package pers.ylw.lesson04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//主窗口
public class JDialogDemo extends JFrame {

    public JDialogDemo(){
        this.setVisible(true);
        this.setBounds(100,100,500,500); //设置起始位置和宽高
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置关闭事件

        //JFrame 要获得他自己（他自己是个容器）
        Container container = this.getContentPane();
        //绝对布局，就是null，自己给组件定位然后摆放
        container.setLayout(null);

        //按钮
        JButton jbutton = new JButton("点击弹出一个对话框");
        jbutton.setBounds(30,30,200,50);
        //监听点击事件
        jbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹出弹窗
                new MyJDialog();
            }
        });


        container.add(jbutton);
    }

    public static void main(String[] args) {
        new JDialogDemo();
    }
}

//弹窗的窗口
class MyJDialog extends JDialog{
    public MyJDialog() {
        this.setVisible(true);
        this.setBounds(200,200,200,200);
        //不写EXIT_ON_CLOSE，可以关闭，
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //报错：defaultCloseOperation must be one of: DO_NOTHING_ON_CLOSE, HIDE_ON_CLOSE, or DISPOSE_ON_CLOSE

        Container container = this.getContentPane();
        container.setLayout(null);

        JLabel jLabel = new JLabel("这是弹窗");
        jLabel.setSize(100,50);
        container.add(jLabel);
    }
}
