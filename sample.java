package AWT;

import java.awt.*;
import java.awt.event.*;

public class sample {
    public static void main(String[] args) {
        Frame frame = new Frame("Login Page");

        // Set frame properties
        frame.setSize(500, 600);
        frame.setLayout(null);
        frame.setBackground(new Color(55, 55, 65)); // Dark background

        // Create "Create an Account" Label
        Label titleLabel = new Label("Create an account");
        titleLabel.setBounds(150, 50, 200, 30);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(titleLabel);

        // First Name and Last Name Fields
        TextField firstNameField = new TextField("First name");
        firstNameField.setBounds(100, 100, 140, 30);
        frame.add(firstNameField);

        TextField lastNameField = new TextField("Last name");
        lastNameField.setBounds(260, 100, 140, 30);
        frame.add(lastNameField);

        // Email Field
        TextField emailField = new TextField("Email");
        emailField.setBounds(100, 150, 300, 30);
        frame.add(emailField);

        // Password Field
        TextField passwordField = new TextField("Enter your password");
        passwordField.setBounds(100, 200, 300, 30);
        passwordField.setEchoChar('*'); // Mask password input
        frame.add(passwordField);

        // Terms & Conditions Checkbox
        Checkbox termsCheckbox = new Checkbox("I agree to the Terms & Conditions", true);
        termsCheckbox.setBounds(100, 250, 300, 30);
        termsCheckbox.setForeground(Color.LIGHT_GRAY);
        frame.add(termsCheckbox);

        // Create Account Button
        Button createAccountButton = new Button("Create account");
        createAccountButton.setBounds(150, 300, 200, 40);
        createAccountButton.setBackground(new Color(128, 0, 255));
        createAccountButton.setForeground(Color.WHITE);
        frame.add(createAccountButton);

        // Add button event listener
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Basic action for demonstration
                System.out.println("Account Created!");
            }
        });

        // Make frame visible
        frame.setVisible(true);

        // Add window close functionality
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}
