package AWT;

import java.awt.*;

public class Layout{
    public static void main(String[] args) {
        cl();
    }

    public static void bl(){
        Frame frame = new Frame();
        frame.setSize(200,200);

        Button btn1 = new Button("North");
        btn1.setSize(10,10);
        Button btn2 = new Button("South");
        Button btn3 = new Button("West");
        Button btn4 = new Button("East");
        Button btn5 = new Button("Center");

        frame.add(btn1, BorderLayout.NORTH);
        frame.add(btn2, BorderLayout.SOUTH);
        frame.add(btn3, BorderLayout.WEST);
        frame.add(btn4, BorderLayout.EAST);
        frame.add(btn5, BorderLayout.CENTER);

        frame.setVisible(true);
    }
    static void cl(){
        CardLayout card = new CardLayout();

        Frame frame =new Frame();
        frame.setSize(200, 300);
        frame.setLayout(card);

        Button b1 = new Button("Card 1");
        Button b2 = new Button("Card 2");
        Button b3 = new Button("Card 3");
        Button b4 = new Button("Card 4");
        Button b5 = new Button("Card 5");

        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);

//        card.next(frame);
        frame.setVisible(true);
    }

}