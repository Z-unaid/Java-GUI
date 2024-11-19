package AWT.LoginPage;

import java.awt.*;
import java.awt.event.*;

public class Login {
    private Frame frame = null;

    private Panel loginPanel = null;
    private Panel registerPanel = null;
    private Panel successLogin = null;

    private TextField loginUsernameField = null;
    private TextField loginPasswordField = null;

    private TextField registerUsernameField = null;
    private TextField registerPasswordField = null;

    private Label loginWrongUsername = null;
    private Label loginWrongPassword = null;

    private Label registerWrongUsername = null;
    private Label registerWrongPassword = null;

    // Registration Panel Components
    private TextField firstnameField = null;
    private TextField lastnameField = null;
    private TextField emailField = null;

    private Label wrongFirstname = null;
    private Label wrongEmail = null;

    private final Label inst1 = new Label("* Must be at least 8 characters long.");
    private final Label inst2 = new Label("* Include at least one uppercase letter (A-Z).");
    private final Label inst3 = new Label("* Include at least one lowercase letter (a-z).");
    private final Label inst4 = new Label("* Include at least one number (0-9).");
    private final Label inst5 = new Label("* Include at least one special character.");
    private final Label inst6 = new Label("* Avoid using spaces.");

    private final Cursor pointer = new Cursor(Cursor.HAND_CURSOR);
    private final CardLayout cardLayout = new CardLayout();

    Login() {
        frame = new Frame();
        frame.setSize(320, 450);
        frame.setLayout(cardLayout);
        frame.setBackground(Color.decode("#1A3636"));

        loginForm();
        register();
        loggedIn();

        frame.add(loginPanel);
        frame.add(registerPanel);
        frame.add(successLogin);

        frame.setVisible(true);
    }

    private void loginForm() {
        Label usernameLabel = new Label("Enter username");
        Label passwordLabel = new Label("Enter password");

        Label title = new Label("Login");

        Checkbox showPass = new Checkbox("show password");

        Button loginButton = new Button("Login");

        Label label = new Label("click here to register");

        loginPanel = new Panel(null);
        loginPanel.setSize(320, 450);

        title.setBounds(125, 30, 200, 30);
        title.setForeground(Color.decode("#ffffff"));
        title.setFont(new Font("Courier", Font.BOLD, 20));

        loginUsernameField = new TextField();
        loginUsernameField.setBounds(60, 90, 200, 30);
        loginUsernameField.setBackground(Color.decode("#ffffff"));
        loginUsernameField.setForeground(Color.decode("#0B192C"));
        loginUsernameField.setFont(new Font("Courier", Font.PLAIN, 15));

        loginPasswordField = new TextField();
        loginPasswordField.setBounds(60, 160, 200, 30);
        loginPasswordField.setBackground(Color.decode("#ffffff"));
        loginPasswordField.setForeground(Color.decode("#0B192C"));
        loginPasswordField.setFont(new Font("Courier", Font.PLAIN, 15));
        loginPasswordField.setEchoChar('*');

        usernameLabel.setBounds(loginUsernameField.getX(), loginUsernameField.getY() - 20, 100, 18);
        usernameLabel.setForeground(Color.decode("#ffffff"));

        passwordLabel.setBounds(loginPasswordField.getX(), loginPasswordField.getY() - 20, 100, 18);
        passwordLabel.setForeground(Color.decode("#ffffff"));

        loginWrongUsername = new Label("*wrong username");
        loginWrongUsername.setBounds(loginUsernameField.getX(), loginUsernameField.getY() + 28, 130, 20);
        loginWrongUsername.setForeground(Color.red);
        loginWrongUsername.setVisible(false);

        loginWrongPassword = new Label("*wrong password");
        loginWrongPassword.setBounds(loginPasswordField.getX(), loginPasswordField.getY() + 28, 130, 20);
        loginWrongPassword.setForeground(Color.red);
        loginWrongPassword.setVisible(false);

        showPass.setBounds(loginPasswordField.getX(), loginPasswordField.getY() + 45, 130, 20);
        showPass.setForeground(Color.decode("#ffffff"));

        loginButton.setBounds(60, 250, 200, 30);
        loginButton.setBackground(Color.decode("#ffffff"));
        loginButton.setForeground(Color.decode("#000000"));
        loginButton.setCursor(pointer);

        label.setBounds(105, 290, 110, 15);
        label.setForeground(Color.decode("#ffffff"));
        label.setCursor(pointer);

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeFrameSize(false);
                cardLayout.next(frame);
                System.out.println("Clicked");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setForeground(Color.decode("#0000EE"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setForeground(Color.decode("#ffffff"));
            }
        });

        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeFrameSize(true);
                cardLayout.last(frame);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(Color.decode("#e0dede"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                loginButton.setBackground(Color.decode("#ffffff"));
            }
        });

        showPass.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (showPass.getState()) {
                    loginPasswordField.setEchoChar('\0');
                } else {
                    loginPasswordField.setEchoChar('*');
                }
            }
        });

        loginPanel.add(title);
        loginPanel.add(usernameLabel);
        loginPanel.add(loginUsernameField);
        loginPanel.add(loginWrongUsername);
        loginPanel.add(passwordLabel);
        loginPanel.add(loginPasswordField);
        loginPanel.add(loginWrongPassword);
        loginPanel.add(showPass);
        loginPanel.add(loginButton);
        loginPanel.add(label);
    }

    private void register() {
        Label title = new Label("Register");

        Label firstnameLabel = new Label("First name");
        Label lastnameLabel = new Label("last name");
        Label emailLabel = new Label("Email");
        Label usernameLabel = new Label("Create username");
        Label passwordLabel = new Label("Create password");

        Label label = new Label("go back to login page");

        registerPanel = new Panel(null);
        frame.add(registerPanel);

        title.setBounds(125, 30, 200, 30);
        title.setForeground(Color.decode("#ffffff"));
        title.setFont(new Font("Courier", Font.BOLD, 20));

        firstnameField = new TextField();
        firstnameField.setBounds(30, 90, 120, 30);
        firstnameField.setBackground(Color.decode("#ffffff"));
        firstnameField.setForeground(Color.decode("#0B192C"));
        firstnameField.setFont(new Font("Courier", Font.PLAIN, 15));

        lastnameField = new TextField();
        lastnameField.setBounds(170, firstnameField.getY(), 120, 30);
        lastnameField.setBackground(Color.decode("#ffffff"));
        lastnameField.setForeground(Color.decode("#0B192C"));
        lastnameField.setFont(new Font("Courier", Font.PLAIN, 15));

        firstnameLabel.setBounds(firstnameField.getX(), firstnameField.getY() - 20, 100, 20);
        firstnameLabel.setForeground(Color.decode("#ffffff"));

        lastnameLabel.setBounds(lastnameField.getX(), lastnameField.getY() - 20, 100, 20);
        lastnameLabel.setForeground(Color.decode("#ffffff"));

        wrongFirstname = new Label("*first name can't be empty");
        wrongFirstname.setBounds(firstnameField.getX(), firstnameField.getY() + 28, 130, 20);
        wrongFirstname.setForeground(Color.red);

        emailField = new TextField();
        emailField.setBounds(firstnameField.getX(), firstnameField.getY() + 70, 260, 30);
        emailField.setBackground(Color.decode("#ffffff"));
        emailField.setForeground(Color.decode("#0B192C"));
        emailField.setFont(new Font("Courier", Font.PLAIN, 15));

        emailLabel.setBounds(emailField.getX(), emailField.getY() - 20, 100, 20);
        emailLabel.setForeground(Color.decode("#ffffff"));

        wrongEmail = new Label("*invalid email");
        wrongEmail.setBounds(emailField.getX(), emailField.getY() + 28, 130, 20);
        wrongEmail.setForeground(Color.red);

        registerUsernameField = new TextField();
        registerUsernameField.setBounds(emailField.getX(), emailField.getY() + 70, 260, 30);
        registerUsernameField.setBackground(Color.decode("#ffffff"));
        registerUsernameField.setForeground(Color.decode("#0B192C"));
        registerUsernameField.setFont(new Font("Courier", Font.PLAIN, 15));

        registerPasswordField = new TextField();
        registerPasswordField.setBounds(registerUsernameField.getX(), registerUsernameField.getY() + 70, 200, 30);
        registerPasswordField.setBackground(Color.decode("#ffffff"));
        registerPasswordField.setForeground(Color.decode("#0B192C"));
        registerPasswordField.setFont(new Font("Courier", Font.PLAIN, 15));
        registerPasswordField.setEchoChar('*');

        usernameLabel.setBounds(registerUsernameField.getX(), registerUsernameField.getY() - 20, 100, 18);
        usernameLabel.setForeground(Color.decode("#ffffff"));

        passwordLabel.setBounds(registerPasswordField.getX(), registerPasswordField.getY() - 20, 100, 18);
        passwordLabel.setForeground(Color.decode("#ffffff"));

        registerWrongUsername = new Label("*invalid username");
        registerWrongUsername.setBounds(registerUsernameField.getX(), registerUsernameField.getY() + 28, 130, 20);
        registerWrongUsername.setForeground(Color.red);
        registerWrongUsername.setVisible(true);

        registerWrongPassword = new Label("Create Password");
        registerWrongPassword.setBounds(registerPasswordField.getX(), registerPasswordField.getY() + 28, 130, 20);
        registerWrongPassword.setForeground(Color.red);
        registerWrongPassword.setVisible(true);

        inst1.setBounds(registerPasswordField.getX(), registerPasswordField.getY() + 50, 250, 18);
        inst1.setForeground(Color.decode("#ffffff"));

        inst2.setBounds(registerPasswordField.getX(), registerPasswordField.getY() + 65, 250, 18);
        inst2.setForeground(Color.decode("#ffffff"));

        inst3.setBounds(registerPasswordField.getX(), registerPasswordField.getY() + 80, 250, 18);
        inst3.setForeground(Color.decode("#ffffff"));

        inst4.setBounds(registerPasswordField.getX(), registerPasswordField.getY() + 95, 250, 18);
        inst4.setForeground(Color.decode("#ffffff"));

        inst5.setBounds(registerPasswordField.getX(), registerPasswordField.getY() + 110, 250, 18);
        inst5.setForeground(Color.decode("#ffffff"));

        inst6.setBounds(registerPasswordField.getX(), registerPasswordField.getY() + 125, 250, 18);
        inst6.setForeground(Color.decode("#ffffff"));

        Button registerButton = new Button("Register");
        registerButton.setBounds(registerPasswordField.getX(), inst6.getY() + 40, 260, 30);
        registerButton.setBackground(Color.decode("#003161"));
        registerButton.setForeground(Color.decode("#ffffff"));
        registerButton.setCursor(pointer);

        label.setBounds(registerButton.getX() + 80, registerButton.getY() + 30, 110, 17);
        label.setForeground(Color.decode("#ffffff"));
        label.setAlignment(Label.CENTER);
        label.setCursor(pointer);

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeFrameSize(true);
                cardLayout.previous(frame);
                System.out.println("Clicked");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setForeground(Color.decode("#0000EE"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setForeground(Color.decode("#ffffff"));
            }
        });

        registerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Login Button Clicked");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                registerButton.setBackground(Color.decode("#014587"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                registerButton.setBackground(Color.decode("#003161"));
            }
        });

        registerPanel.add(title);
        registerPanel.add(firstnameField);
        registerPanel.add(firstnameLabel);
        registerPanel.add(wrongFirstname);
        registerPanel.add(lastnameField);
        registerPanel.add(lastnameLabel);
        registerPanel.add(emailField);
        registerPanel.add(emailLabel);
        registerPanel.add(wrongEmail);
        registerPanel.add(registerUsernameField);
        registerPanel.add(usernameLabel);
        registerPanel.add(registerWrongUsername);
        registerPanel.add(registerPasswordField);
        registerPanel.add(passwordLabel);
        registerPanel.add(registerWrongPassword);
        registerPanel.add(inst1);
        registerPanel.add(inst2);
        registerPanel.add(inst3);
        registerPanel.add(inst4);
        registerPanel.add(inst5);
        registerPanel.add(inst6);
        registerPanel.add(registerButton);
        registerPanel.add(label);
    }

    private void loggedIn() {
        successLogin = new Panel(new BorderLayout());

        Label loginLabel = new Label("Login Success");
        loginLabel.setFont(new Font("Courier", Font.BOLD, 30));
        loginLabel.setAlignment(Label.CENTER);
        loginLabel.setForeground(Color.GREEN);

        successLogin.add(loginLabel, BorderLayout.CENTER);
    }

    private void changeFrameSize(Boolean isTrue) {
        if (isTrue) {
            frame.setTitle("Login Form");
            frame.setSize(320, 450);
        } else {
            frame.setTitle("Registration Form");
            frame.setSize(320, 600);
        }
    }

    private String getLoginUsername() {
        return loginUsernameField.getText();
    }

    private String getLoginPassword() {
        return loginPasswordField.getText();
    }

    private String getFirstname() {
        return firstnameField.getText();
    }

    private String getLastname() {
        return lastnameField.getText();
    }

    private String getEmail() {
        return emailField.getText();
    }

    private String getRegisterUsername() {
        return registerUsernameField.getText();
    }

    private String getRegisterPassword() {
        return registerPasswordField.getText();
    }

    // Verifications

}