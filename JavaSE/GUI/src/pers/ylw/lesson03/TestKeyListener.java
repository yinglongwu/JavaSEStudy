package pers.ylw.lesson03;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//键盘监听
public class TestKeyListener {
    public static void main(String[] args) {
        new KeyFrame();
    }
}

//自己的窗口类
class KeyFrame extends Frame{
    public KeyFrame(){
        setBounds(1,2,300,400);
        setVisible(true);

        this.addKeyListener(new KeyAdapter() {
            //获取键盘按下的键
            @Override
            public void keyPressed(KeyEvent e) {
                //获取键盘按下的键,返回键的码值
                int keyCode = e.getKeyCode();
                System.out.println(keyCode); //输出键的码值
                //根据按下的键不同，进行不同的处理
                if (keyCode == KeyEvent.VK_UP){ //如果键的码值等于上键
                    System.out.println("你按下了上键"); //在控制台可以看到
                }
            }
        });
    }
}