package pers.ylw.lesson04;

import javax.swing.*;
import java.awt.*;

//图标、需要实现类、Frame继承
public class IconDemo extends JFrame implements Icon {

    private int width;
    private int height;

    public IconDemo(){ //无参构造

    }

    public IconDemo(int width,int height){
        this.width = width;
        this.height = height;
    }

    //初始化
    public void init(){
        IconDemo iconDemo = new IconDemo(15, 15);
        //图标可以放在标签上，也可以放在按钮上
        JLabel jLabel = new JLabel("icon图标测试", iconDemo, SwingConstants.CENTER);

        Container container = getContentPane();
        container.add(jLabel);

        this.setBounds(100,100,200,200);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new IconDemo().init();
    }

    //画一个图标
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.fillOval(x,y,width,height);
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public int getIconHeight() {
        return this.height;
    }
}
