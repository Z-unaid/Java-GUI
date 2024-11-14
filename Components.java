package AWT;

import java.awt.*;

public class Components {
    public static void main(String[] args) {
        Frame frame = new Frame("JAVA Application");
        frame.setSize(300, 300);
        frame.setBackground(Color.decode("#EEEEEE"));
        frame.setLayout(new FlowLayout());

        Panel panel = new Panel(new FlowLayout());
        panel.setBackground(Color.decode("#1E3E62"));

        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        panel.add(button1);
        panel.add(button2);

        Label label = new Label("Label");

        Checkbox checkbox = new Checkbox("Check Box");

        CheckboxGroup checkboxes = new CheckboxGroup();
        Checkbox opt1 = new Checkbox("Option 1", checkboxes , false);
        Checkbox opt2 = new Checkbox("Option 2", checkboxes, true);
        Checkbox opt3 = new Checkbox("Option 3", checkboxes , true);

        Choice choice = new Choice();
        choice.add("item 1");
        choice.add("item 2");
        choice.add("item 3");
        choice.add("item 4");
        choice.add("item 5");

        List list = new List(4);
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        list.add("Item 4");
        list.add("Item 5");

        TextField input = new TextField("Type to start");

        frame.add(panel);
        frame.add(label);
        frame.add(opt3);
        frame.add(choice);
        frame.add(opt1);
        frame.add(opt2);
        frame.add(opt3);
        frame.add(input);
        frame.add(list);

        frame.setVisible(true);
    }
}