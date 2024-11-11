package AWT;

import java.awt.*;

public class Components {
    public static void main(String[] args) {
        Frame frame = new Frame("JAVA Application");
        frame.setSize(500, 500);
        frame.setBackground(Color.decode("#EEEEEE"));
        frame.setLayout(new FlowLayout());

        Panel panel = new Panel(new FlowLayout());
        panel.setBackground(Color.decode("#1E3E62"));

        Button button = new Button("Button 1");
        panel.add(button);
        panel.add(button);

        Label label = new Label("Label");

        Checkbox checkbox = new Checkbox("Check Box");

        frame.add(panel);
        frame.add(checkbox);
        frame.add(checkbox);

        frame.setVisible(true);
    }
}