package AWT.LoginPage;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class Login extends Frame {
    private final HashMap<String, String> data = new HashMap<>();

    private TextField idField = null;
    private TextField passwordField = null;
    private Label responseLabel = null;

    public Login(){
        setSize(300, 400);
        setBackground(Color.decode("#EEEEEE"));

        Panel loginPanel = new Panel(new FlowLayout(FlowLayout.CENTER));

        Label usernameLabel = new Label("Username: ");
        usernameLabel.setForeground(Color.decode("#1A1A1D"));
        Label passwordLabel = new Label("Password: ");
        passwordLabel.setForeground(Color.decode("#1A1A1D"));

        idField = new TextField(20);

        passwordField = new TextField(20);
        passwordField.setEchoChar('*');

        Button loginBtn = new Button("Login");
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                check();
            }
        });

        Button registerBtn = new Button("Register");
        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });

        responseLabel = new Label("           Default text written here             ");

        loginPanel.add(usernameLabel);
        loginPanel.add(idField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginBtn);
        loginPanel.add(registerBtn);
        loginPanel.add(registerBtn);
        loginPanel.add(responseLabel);

        add(loginPanel);
        setVisible(true);
    }

    public void check(){
        String userName = idField.getText().toLowerCase();
        String password = passwordField.getText();

        if(data.containsKey(userName)){
            if(password.equals(data.get(userName))){
                show("Success Login");
            } else {
                show("Wrong Password");
            }
        } else {
            show("Wrong Username");
        }
    }

    public void register(){
        String userName = idField.getText().trim().toLowerCase();
        String password = passwordField.getText().trim();

        if(userName.isEmpty() || password.isEmpty()){
            show("Invalid Username or password!");
            return;
        }
        data.put(userName, password);
        idField.setText("");
        passwordField.setText("");
        show("Registered Successfully");
    }

    public void show(String text){
        responseLabel.setText(text);
    }

    public static void main(String[] args) {
            new Login();
    }
}
