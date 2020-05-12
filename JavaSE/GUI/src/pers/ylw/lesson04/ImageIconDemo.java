package pers.ylw.lesson04;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageIconDemo extends JFrame {

    public ImageIconDemo(){
        //获取图片的地址
        URL url = ImageIconDemo.class.getResource("tx.jpg");//获取当前类同一文件夹下的资源
        ImageIcon imageIcon = new ImageIcon(url);

        JLabel jLabel = new JLabel("ImageIcon");
        jLabel.setIcon(imageIcon); //把图片放到标签上
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);//设置居中

        Container container = getContentPane();
        container.add(jLabel);

        setBounds(100,100,300,300);
        setVisible(true); //设置可见
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //点击关闭
    }

    public static void main(String[] args) {
       new ImageIconDemo();
    }
}
