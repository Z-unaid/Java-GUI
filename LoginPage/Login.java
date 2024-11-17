package AWT.LoginPage;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {
    private Frame frame = null;
    private Label title = null;

    private Panel loginPanel = null;
    private Panel registerPanel = null;
    private Panel resPanel = null;

    private TextField usernameField = null;
    private TextField passwordField = null;

    private Label usernameLabel = null;
    private Label passwordLabel = null;

    private Label wrongUsername = null;
    private Label wrongPassword = null;

    private Button loginButton = null;
    private Label label = null;

    // Registration Panel Components
    private TextField firstnameField = null;
    private TextField lastnameField = null;
    private TextField emailField = null;

    private Label firstnameLabel = null;
    private Label lastnameLabel = null;
    private Label emailLabel = null;

    private Label wrongFirstname = null;
    private Label wrongLastname = null;
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
        frame.setSize(320, 600);
        frame.setLayout(cardLayout);
        frame.setBackground(Color.decode("#1A3636"));

        loginPanel = new Panel(null);
        loginPanel.setSize(320, 450);
//        loginPanel.setBackground(Color.red);

        title = new Label("Login");
        title.setBounds(125, 30, 200, 30);
        title.setForeground(Color.decode("#ffffff"));
        title.setFont(new Font("Courier", Font.BOLD, 20));

        usernameField = new TextField();
        usernameField.setBounds(60, 90, 200, 30);
        usernameField.setBackground(Color.decode("#ffffff"));
        usernameField.setForeground(Color.decode("#0B192C"));
        usernameField.setFont(new Font("Courier", Font.PLAIN, 15));

        passwordField = new TextField();
        passwordField.setBounds(60, 160, 200, 30);
        passwordField.setBackground(Color.decode("#ffffff"));
        passwordField.setForeground(Color.decode("#0B192C"));
        passwordField.setFont(new Font("Courier", Font.PLAIN, 15));

        usernameLabel = new Label("Enter username");
        usernameLabel.setBounds(usernameField.getX(), usernameField.getY() - 20, 100, 18);
        usernameLabel.setForeground(Color.decode("#ffffff"));

        passwordLabel = new Label("Enter password");
        passwordLabel.setBounds(passwordField.getX(), passwordField.getY() - 20, 100, 18);
        passwordLabel.setForeground(Color.decode("#ffffff"));

        wrongUsername = new Label("*wrong username");
        wrongUsername.setBounds(usernameField.getX(), usernameField.getY() + 28, 130, 20);
        wrongUsername.setForeground(Color.red);
        wrongUsername.setVisible(false);

        wrongPassword = new Label("*wrong password");
        wrongPassword.setBounds(passwordField.getX(), passwordField.getY() + 28, 130, 20);
        wrongPassword.setForeground(Color.red);
        wrongPassword.setVisible(false);

        loginButton = new Button("Login");
        loginButton.setBounds(60, 220, 200, 30);
        loginButton.setBackground(Color.decode("#ffffff"));
        loginButton.setForeground(Color.decode("#000000"));
        loginButton.setCursor(pointer);

        label = new Label("click here to register");
        label.setBounds(105, 260, 110, 15);
        label.setForeground(Color.decode("#ffffff"));
        label.setCursor(pointer);

        loginPanel.add(title);
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(wrongUsername);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(wrongPassword);
        loginPanel.add(loginButton);
        loginPanel.add(label);

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setForeground(Color.decode("#0000EE"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setForeground(Color.decode("#ffffff"));
            }
        });

        label.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                System.out.println("clicked");
            }
        });

        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(Color.decode("#e0dede"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                loginButton.setBackground(Color.decode("#ffffff"));
            }
        });
    }

    private void register() {
        registerPanel = new Panel(null);
        frame.add(registerPanel);

        title.setText("Register");
        title.setLocation(110, 30);

        firstnameField = new TextField();
        firstnameField.setBounds(30, 90, 120, 30);
        firstnameField.setBackground(Color.decode("#ffffff"));
        firstnameField.setForeground(Color.decode("#0B192C"));
        firstnameField.setFont(new Font("Courier", Font.PLAIN, 15));

        lastnameField = new TextField();
        lastnameField.setBounds(170, 90, 120, 30);
        lastnameField.setBackground(Color.decode("#ffffff"));
        lastnameField.setForeground(Color.decode("#0B192C"));
        lastnameField.setFont(new Font("Courier", Font.PLAIN, 15));

        firstnameLabel = new Label("First name");
        firstnameLabel.setBounds(firstnameField.getX(), firstnameField.getY() - 20, 100, 20);
        firstnameLabel.setForeground(Color.decode("#ffffff"));

        lastnameLabel = new Label("Last name");
        lastnameLabel.setBounds(lastnameField.getX(), lastnameField.getY() - 20, 100, 20);
        lastnameLabel.setForeground(Color.decode("#ffffff"));

        wrongFirstname = new Label("*first name can't be empty");
        wrongFirstname.setBounds(firstnameField.getX(), firstnameField.getY() + 28, 130, 20);
        wrongFirstname.setForeground(Color.red);

        emailField = new TextField();
        emailField.setBounds(30, 170, 260, 30);
        emailField.setBackground(Color.decode("#ffffff"));
        emailField.setForeground(Color.decode("#0B192C"));
        emailField.setFont(new Font("Courier", Font.PLAIN, 15));

        emailLabel = new Label("Enter email");
        emailLabel.setBounds(emailField.getX(), emailField.getY() - 20, 100, 20);
        emailLabel.setForeground(Color.decode("#ffffff"));

        wrongEmail = new Label("*invalid email");
        wrongEmail.setBounds(emailField.getX(), emailField.getY() + 28, 130, 20);
        wrongEmail.setForeground(Color.red);

        usernameField.setBounds(30, 240, 260, 30);

        usernameLabel.setBounds(usernameField.getX(), usernameField.getY() - 20, 100, 18);
        usernameLabel.setForeground(Color.decode("#ffffff"));

        wrongUsername.setBounds(usernameField.getX(), usernameField.getY() + 28, 130, 20);
        wrongUsername.setForeground(Color.red);
        wrongUsername.setVisible(true);

        passwordField.setBounds(30, 310, 260, 30);

        passwordLabel.setBounds(passwordField.getX(), passwordField.getY() - 20, 100, 18);
        passwordLabel.setForeground(Color.decode("#ffffff"));

        inst1.setBounds(passwordField.getX(), passwordField.getY() + 30, 250, 18);
        inst1.setForeground(Color.decode("#ffffff"));

        inst2.setBounds(passwordField.getX(), passwordField.getY() + 45, 250, 18);
        inst2.setForeground(Color.decode("#ffffff"));

        inst3.setBounds(passwordField.getX(), passwordField.getY() + 60, 250, 18);
        inst3.setForeground(Color.decode("#ffffff"));

        inst4.setBounds(passwordField.getX(), passwordField.getY() + 75, 250, 18);
        inst4.setForeground(Color.decode("#ffffff"));

        inst5.setBounds(passwordField.getX(), passwordField.getY() + 90, 250, 18);
        inst5.setForeground(Color.decode("#ffffff"));

        inst6.setBounds(passwordField.getX(), passwordField.getY() + 105, 250, 18);
        inst6.setForeground(Color.decode("#ffffff"));

        Button registerButton = new Button("Register");
        registerButton.setBounds(passwordField.getX(), passwordField.getY() + 130, 260, 30);
        registerButton.setBackground(Color.decode("#003161"));
        registerButton.setForeground(Color.decode("#ffffff"));
        registerButton.setCursor(pointer);

        registerPanel.add(title);
        registerPanel.add(firstnameField);
        registerPanel.add(firstnameLabel);
        registerPanel.add(wrongFirstname);
        registerPanel.add(lastnameField);
        registerPanel.add(lastnameLabel);
        registerPanel.add(emailField);
        registerPanel.add(emailLabel);
        registerPanel.add(wrongEmail);
        registerPanel.add(usernameField);
        registerPanel.add(usernameLabel);
        registerPanel.add(wrongUsername);
        registerPanel.add(passwordField);
        registerPanel.add(passwordLabel);
        registerPanel.add(inst1);
        registerPanel.add(inst2);
        registerPanel.add(inst3);
        registerPanel.add(inst4);
        registerPanel.add(inst5);
        registerPanel.add(inst6);
        registerPanel.add(registerButton);
    }

    public void start() {
        frame.setVisible(true);
        register();
    }
}