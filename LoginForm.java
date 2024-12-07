package AWT;

import java.awt.*;
import java.awt.event.*;


public class LoginForm {
    public static void main(String[] args) {
        Frame frame = new Frame("Login Form");

        Label lblUsername = new Label("Username:");
        lblUsername.setBounds(50, 100, 80, 30);

        Label lblPassword = new Label("Password:");
        lblPassword.setBounds(50, 150, 80, 30);

        Label lblMessage = new Label();
        lblMessage.setBounds(50, 250, 300, 30);
        lblMessage.setForeground(Color.RED);

        TextField txtUsername = new TextField();
        txtUsername.setBounds(150, 100, 150, 30);

        TextField txtPassword = new TextField();
        txtPassword.setBounds(150, 150, 150, 30);
        txtPassword.setEchoChar('*');

        Button btnLogin = new Button("Login");
        btnLogin.setBounds(150, 200, 80, 30);

        // Add event listener for the button
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = txtPassword.getText();

                // Dummy check for demonstration
                if (username.equals("admin") && password.equals("1234")) {
                    lblMessage.setText("Login successful!");
                    lblMessage.setForeground(Color.GREEN);
                } else {
                    lblMessage.setText("Invalid username or password!");
                    lblMessage.setForeground(Color.RED);
                }
            }
        });

        frame.add(lblUsername);
        frame.add(lblPassword);
        frame.add(txtUsername);
        frame.add(txtPassword);
        frame.add(btnLogin);
        frame.add(lblMessage);

        frame.setSize(400, 350);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }
}
