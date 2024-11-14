package AWT;

import java.awt.*;
import java.awt.event.*;

public class sample extends Frame implements ActionListener {

    // Create components
    Label usernameLabel, passwordLabel;
    TextField usernameField, passwordField;
    Button loginButton;

    public sample() {
        // Create Frame
        setTitle("Login Page");
        setSize(300, 200);
        setLayout(new FlowLayout());

        // Initialize components
        usernameLabel = new Label("Username:");
        usernameField = new TextField(20);
        passwordLabel = new Label("Password:");
        passwordField = new TextField(20);
        passwordField.setEchoChar('*'); // Hide password input
        loginButton = new Button("Login");

        // Add components to the frame
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);

        // Add action listener to the button
        loginButton.addActionListener(this);

        // Set window to close on close
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Set the window visibility
        setVisible(true);
    }

    // Action performed when login button is clicked
    public void actionPerformed(ActionEvent ae) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Here, you can check username and password with your database or predefined values
        if (username.equals("admin") && password.equals("1234")) {
            System.out.println("Login Successful");
            // You can add further actions here like opening a new window
        } else {
            System.out.println("Invalid Username or Password");
        }
    }

    // Main method to create the login page
    public static void main(String[] args) {
        new sample();
    }
}
