package AWT;

import java.awt.*;

public class HelloWorld {
    public static void main(String[] args) {
        Frame frame = new Frame("Java App");
        frame.setSize(500, 500);
        frame.setLayout(new FlowLayout());

        Button btn1 = new Button("btn 1");
        Button btn2 = new Button("btn 2");
        Button btn3 = new Button("btn 3");
        Button btn4 = new Button("btn 4");
        Button btn5 = new Button("btn 5");

        btn1.setPreferredSize(new Dimension(100, 70));

        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(btn4);
        frame.add(btn5);

        frame.setVisible(true);
    }
}