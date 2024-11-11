package AWT;

import java.awt.*;
import java.awt.event.*;

public class sample {
    public static void main(String[] args) {
        // Create a new Frame
        Frame frame = new Frame("AWT Components Demo");

        // Set layout manager to null for custom positioning
        frame.setLayout(null);
        frame.setBackground(Color.decode("#112D4E"));

        // Create and position a Label
        Label label = new Label("Hello World");
        label.setBounds(20, 40, 100, 20);
        frame.add(label);
        label.setBackground(Color.decode("#DBE2EF"));

        // Create and position a Button
        Button button = new Button("Click Me");
        button.setBounds(200, 80, 80, 30);
        frame.add(button);

        // Create and position a Checkbox
        Checkbox checkbox = new Checkbox("I agree");
        checkbox.setBounds(20, 120, 100, 30);
        frame.add(checkbox);

        // Create and position Radio Buttons using CheckboxGroup
        CheckboxGroup group = new CheckboxGroup();
        Checkbox radio1 = new Checkbox("Option 1", group, false);
        radio1.setBounds(20, 160, 100, 30);
        Checkbox radio2 = new Checkbox("Option 2", group, false);
        radio2.setBounds(20, 200, 100, 30);
        frame.add(radio1);
        frame.add(radio2);

        // Create and position a Choice (dropdown menu)
        Choice choice = new Choice();
        choice.add("Choice 1");
        choice.add("Choice 2");
        choice.add("Choice 3");
        choice.setBounds(20, 240, 100, 30);
        frame.add(choice);

        // Create and position a List
        List list = new List(3);  // Display 3 items at a time
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        list.add("Item 4");
        list.setBounds(20, 280, 100, 60);
        frame.add(list);

        // Create and position a TextArea
        TextArea textArea = new TextArea("Type here...");
        textArea.setBounds(150, 40, 200, 50);
        frame.add(textArea);

        // Create and position a TextField
        TextField textField = new TextField("Enter text");
        textField.setBounds(150, 160, 200, 30);
        frame.add(textField);

        // Customize frame settings
        frame.setSize(400, 400);
        frame.setVisible(true);

        // Add window listener to close the application
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

//    public boolean startApp(){
//        Frame frame
//    }
}
