package AWT;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HelloWorld {
    public static void main(String[] args) {
        Frame frame = new Frame("Basic Frame");
        Label label = new Label("Hello World");

        frame.add(label);
        frame.setSize(300, 300);
        frame.setBackground(Color.black);

        label.setAlignment(Label.CENTER);
        frame.setVisible(true);

        WindowAdapter wa = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };

        frame.addWindowListener(wa);
    }
}