package AWT.LoginPage;
import java.awt.*;
import java.awt.event.*;

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

    Login(){
        CardLayout cardLayout = new CardLayout();
        Cursor pointer = new Cursor(Cursor.HAND_CURSOR);

        frame = new Frame();
        frame.setSize(320,450);
        frame.setLayout(cardLayout);
        frame.setBackground(Color.decode("#1A3636"));

        loginPanel = new Panel(null);
        loginPanel.setSize(320,450);
//        loginPanel.setBackground(Color.red);

        title = new Label("Login");
        title.setBounds(125,30,200,30);
        title.setForeground(Color.decode("#ffffff"));
        title.setFont(new Font("Courier", Font.BOLD, 20));

        usernameField = new TextField();
        usernameField.setBounds(60,90,200,30);
        usernameField.setBackground(Color.decode("#ffffff"));
        usernameField.setForeground(Color.decode("#0B192C"));
        usernameField.setFont(new Font("Courier", Font.PLAIN, 15));

        passwordField = new TextField();
        passwordField.setBounds(60,160,200,30);
        passwordField.setBackground(Color.decode("#ffffff"));
        passwordField.setForeground(Color.decode("#0B192C"));
        passwordField.setFont(new Font("Courier", Font.PLAIN, 15));

        usernameLabel = new Label("Enter username");
        usernameLabel.setBounds(usernameField.getX(),usernameField.getY() - 20,100,18);
        usernameLabel.setForeground(Color.decode("#ffffff"));

        passwordLabel = new Label("Enter password");
        passwordLabel.setBounds(passwordField.getX(),passwordField.getY() - 20,100,18);
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
        loginButton.setBounds(60,220,200,30);
        loginButton.setBackground(Color.decode("#ffffff"));
        loginButton.setForeground(Color.decode("#000000"));
        loginButton.setCursor(pointer);

        label = new Label("click here to register");
        label.setBounds(105,260,110,15);
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

        loginButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                loginButton.setBackground(Color.decode("#e0dede"));
            }

            @Override
            public void mouseExited(MouseEvent e){
                loginButton.setBackground(Color.decode("#ffffff"));
            }
        });

        // Registration Panel
        registerPanel = new Panel(null);
        frame.add(loginPanel);
    }

    public void start() {
        frame.setVisible(true);
    }
}