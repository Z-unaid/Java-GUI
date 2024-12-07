package AWT;

import java.awt.*;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Working");
        Frame f = new Frame("Java app");
        f.setSize(600,600);

        Button btn1 = new Button("bt1");
        Button btn2 = new Button("bt2");
        Button btn3 = new Button("bt3`");
        Button btn4 = new Button("bt4");

        btn1.setPreferredSize(new Dimension(200,200));

        f.add(btn1,BorderLayout.NORTH);
        f.add(btn2,BorderLayout.SOUTH);
        f.add(btn3,BorderLayout.EAST);
        f.add(btn4,BorderLayout.WEST);

//        f.setBackground(Color.red);
        f.setVisible(true);
    }
}