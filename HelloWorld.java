package AWT;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HelloWorld {
    public static void main(String[] args) {
            Frame frame = new Frame("Basic Frame");
            Label label = new Label("Hello World");
            Button btn = new Button("Click me");
            TextArea textArea = new TextArea("Type to Start.....");

        btn.setLocation(20, 20);
        btn.setSize(50,50);
        textArea.setBounds(200, 200, 200,200);

        frame.setLayout(null);
        frame.add(label);
        frame.add(btn);
        frame.add(textArea);

        frame.setSize(500, 500);

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