package AWT.LoginPage;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

public class Login {
    private final Frame frame;

    private Panel loginPanel = null;
    private Panel registerPanel = null;
    private Panel userCard = null;

    private TextField loginUsernameField = null;
    private TextField loginPasswordField = null;

    private TextField registerUsernameField = null;
    private TextField registerPasswordField = null;

    private Label loginWrongUsername = null;
    private Label loginWrongPassword = null;

    private Label registerInvalidUsername = null;

    // Registration Panel Components
    private TextField firstnameField = null;
    private TextField lastnameField = null;
    private TextField emailField = null;

    private Label invalidFirstname = null;
    private Label invalidEmail = null;

    // userCard panel components
    private Label cardName = null;
    private Label cardUsername = null;
    private Label cardEmail = null;
    private Label cardPass = null;

    private final Label inst1 = new Label("* Must be at least 8 characters long.");
    private final Label inst2 = new Label("* Include at least one uppercase letter (A-Z).");
    private final Label inst3 = new Label("* Include at least one lowercase letter (a-z).");
    private final Label inst4 = new Label("* Include at least one number (0-9).");
    private final Label inst5 = new Label("* Include at least one special character.");
    private final Label inst6 = new Label("* Avoid using spaces.");

    private final Cursor pointer = new Cursor(Cursor.HAND_CURSOR);
    private final CardLayout cardLayout = new CardLayout();

    private final DataBase db = new DataBase();

    private final Color WHITE = Color.decode("#FFFFFF");
    private final Color skyBlue = Color.decode("#B3C8CF");

    Login() {
        frame = new Frame();
        frame.setBounds(100, 100, 320, 450);
        frame.setLayout(cardLayout);
        frame.setBackground(Color.decode("#1A3636"));

        loginForm();
        register();
        loggedIn();

        frame.add(loginPanel);
        frame.add(registerPanel);
        frame.add(userCard);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                db.close();
                System.exit(0);
            }

            @Override
            public void windowStateChanged(WindowEvent e) {
                System.out.println("changed");
            }
        });

        frame.setVisible(true);
    }

    private void loginForm() {
        Label usernameLabel = new Label("username");
        Label passwordLabel = new Label("password");

        Label title = new Label("Login");

        Checkbox showPass = new Checkbox("show password");

        Button loginButton = new Button("Login");

        Label label = new Label("click here to register");

        loginPanel = new Panel(null);
        loginPanel.setSize(320, 450);

        title.setBounds(125, 30, 200, 30);
        title.setForeground(WHITE);
        title.setFont(new Font("Courier", Font.BOLD, 20));

        loginUsernameField = new TextField();
        loginUsernameField.setBounds(60, 90, 200, 30);
        loginUsernameField.setBackground(WHITE);
        loginUsernameField.setForeground(Color.decode("#0B192C"));
        loginUsernameField.setFont(new Font("Courier", Font.PLAIN, 15));

        loginPasswordField = new TextField();
        loginPasswordField.setBounds(60, 160, 200, 30);
        loginPasswordField.setBackground(WHITE);
        loginPasswordField.setForeground(Color.decode("#0B192C"));
        loginPasswordField.setFont(new Font("Courier", Font.PLAIN, 15));
        loginPasswordField.setEchoChar('*');

        usernameLabel.setBounds(loginUsernameField.getX(), loginUsernameField.getY() - 20, 100, 18);
        usernameLabel.setForeground(WHITE);

        passwordLabel.setBounds(loginPasswordField.getX(), loginPasswordField.getY() - 20, 100, 18);
        passwordLabel.setForeground(WHITE);

        loginWrongUsername = new Label("*wrong username");
        loginWrongUsername.setBounds(loginUsernameField.getX(), loginUsernameField.getY() + 28, 130, 20);
        loginWrongUsername.setForeground(Color.red);
        loginWrongUsername.setVisible(false);

        loginWrongPassword = new Label("*wrong password");
        loginWrongPassword.setBounds(loginPasswordField.getX(), loginPasswordField.getY() + 28, 130, 20);
        loginWrongPassword.setForeground(Color.red);
        loginWrongPassword.setVisible(false);

        showPass.setBounds(loginPasswordField.getX(), loginPasswordField.getY() + 45, 130, 20);
        showPass.setForeground(WHITE);

        loginButton.setBounds(60, 250, 200, 30);
        loginButton.setBackground(WHITE);
        loginButton.setForeground(Color.decode("#000000"));
        loginButton.setCursor(pointer);

        label.setBounds(105, 290, 110, 15);
        label.setForeground(WHITE);
        label.setCursor(pointer);

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeFrameSize(false);
                cardLayout.next(frame);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setForeground(Color.decode("#0000EE"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setForeground(WHITE);
            }
        });

        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("login button clicked");

                Status status = db.verify(getLoginUsername(), getLoginPassword());

                System.out.println("Status: " + status);
                System.out.println("Username: " + getLoginUsername());
                System.out.println("Password: " + getLoginPassword());

                if (status.equals(Status.valid)) {
                    setUserInfo(db.getInfo(getLoginUsername()));
                    cardLayout.last(frame);
                    return;
                }

                loginWrongUsername.setVisible(status.equals(Status.invalidUsername));
                loginWrongPassword.setVisible(status.equals(Status.invalidPassword));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(Color.decode("#e0dede"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                loginButton.setBackground(WHITE);
            }
        });

        showPass.addItemListener(_ -> {
            if (showPass.getState())
                loginPasswordField.setEchoChar('\0');
            else
                loginPasswordField.setEchoChar('*');
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

        Checkbox showPass = new Checkbox("show password");

        Label registerSuccess = new Label("NM");

        registerPanel = new Panel(null);
        frame.add(registerPanel);

        title.setBounds(30, 30, 260, 30);
        title.setAlignment(Label.CENTER);
        title.setForeground(WHITE);
        title.setFont(new Font("Courier", Font.BOLD, 20));

        firstnameField = new TextField();
        firstnameField.setBounds(30, 90, 120, 30);
        firstnameField.setBackground(WHITE);
        firstnameField.setForeground(Color.decode("#0B192C"));
        firstnameField.setFont(new Font("Courier", Font.PLAIN, 15));

        lastnameField = new TextField();
        lastnameField.setBounds(170, firstnameField.getY(), 120, 30);
        lastnameField.setBackground(WHITE);
        lastnameField.setForeground(Color.decode("#0B192C"));
        lastnameField.setFont(new Font("Courier", Font.PLAIN, 15));

        firstnameLabel.setBounds(firstnameField.getX(), firstnameField.getY() - 20, 100, 20);
        firstnameLabel.setForeground(WHITE);

        lastnameLabel.setBounds(lastnameField.getX(), lastnameField.getY() - 20, 100, 20);
        lastnameLabel.setForeground(WHITE);

        invalidFirstname = new Label("*first name can't be empty");
        invalidFirstname.setBounds(firstnameField.getX(), firstnameField.getY() + 28, 130, 20);
        invalidFirstname.setForeground(Color.red);
        invalidFirstname.setVisible(false);

        emailField = new TextField();
        emailField.setBounds(firstnameField.getX(), firstnameField.getY() + 70, 260, 30);
        emailField.setBackground(WHITE);
        emailField.setForeground(Color.decode("#0B192C"));
        emailField.setFont(new Font("Courier", Font.PLAIN, 15));

        emailLabel.setBounds(emailField.getX(), emailField.getY() - 20, 100, 20);
        emailLabel.setForeground(WHITE);

        invalidEmail = new Label("*invalid email");
        invalidEmail.setBounds(emailField.getX(), emailField.getY() + 28, 130, 20);
        invalidEmail.setForeground(Color.red);
        invalidEmail.setVisible(false);

        registerUsernameField = new TextField();
        registerUsernameField.setBounds(emailField.getX(), emailField.getY() + 70, 260, 30);
        registerUsernameField.setBackground(WHITE);
        registerUsernameField.setForeground(Color.decode("#0B192C"));
        registerUsernameField.setFont(new Font("Courier", Font.PLAIN, 15));

        registerPasswordField = new TextField();
        registerPasswordField.setBounds(registerUsernameField.getX(), registerUsernameField.getY() + 70, 260, 30);
        registerPasswordField.setBackground(WHITE);
        registerPasswordField.setForeground(Color.decode("#0B192C"));
        registerPasswordField.setFont(new Font("Courier", Font.PLAIN, 15));
        registerPasswordField.setEchoChar('*');

        usernameLabel.setBounds(registerUsernameField.getX(), registerUsernameField.getY() - 20, 100, 18);
        usernameLabel.setForeground(WHITE);

        passwordLabel.setBounds(registerPasswordField.getX(), registerPasswordField.getY() - 20, 100, 18);
        passwordLabel.setForeground(WHITE);

        registerInvalidUsername = new Label("*invalid username");
        registerInvalidUsername.setBounds(registerUsernameField.getX(), registerUsernameField.getY() + 28, 200, 20);
        registerInvalidUsername.setForeground(Color.red);
        registerInvalidUsername.setVisible(false);

        showPass.setBounds(registerPasswordField.getX(), registerPasswordField.getY() + 28, 130, 20);
        showPass.setForeground(WHITE);
        showPass.addItemListener(_ -> {
            if (showPass.getState())
                registerPasswordField.setEchoChar('\0');
            else
                registerPasswordField.setEchoChar('*');
        });

        inst1.setBounds(registerPasswordField.getX(), registerPasswordField.getY() + 50, 250, 18);
        inst1.setForeground(WHITE);

        inst2.setBounds(registerPasswordField.getX(), registerPasswordField.getY() + 65, 250, 18);
        inst2.setForeground(WHITE);

        inst3.setBounds(registerPasswordField.getX(), registerPasswordField.getY() + 80, 250, 18);
        inst3.setForeground(WHITE);

        inst4.setBounds(registerPasswordField.getX(), registerPasswordField.getY() + 95, 250, 18);
        inst4.setForeground(WHITE);

        inst5.setBounds(registerPasswordField.getX(), registerPasswordField.getY() + 110, 250, 18);
        inst5.setForeground(WHITE);

        inst6.setBounds(registerPasswordField.getX(), registerPasswordField.getY() + 125, 250, 18);
        inst6.setForeground(WHITE);

        Button registerButton = new Button("Register");
        registerButton.setBounds(registerPasswordField.getX(), inst6.getY() + 40, 260, 30);
        registerButton.setBackground(Color.decode("#003161"));
        registerButton.setForeground(WHITE);
        registerButton.setCursor(pointer);

        label.setBounds(registerButton.getX() + 80, registerButton.getY() + 30, 110, 17);
        label.setForeground(WHITE);
        label.setAlignment(Label.CENTER);
        label.setCursor(pointer);

        registerSuccess.setBounds(title.getX(), label.getY() + 30, 260, 17);
        registerSuccess.setForeground(Color.GREEN);
        registerSuccess.setAlignment(Label.CENTER);
        registerSuccess.setVisible(false);

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
                label.setForeground(WHITE);
            }
        });

        registerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                registerButton.setBackground(Color.decode("#014587"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                registerButton.setBackground(Color.decode("#003161"));
            }
        });

        registerButton.addActionListener(_ -> {
            System.out.println("process started......");

            if (isValidFirstname() && isValidEmail() && isValidUsername() && isValidPass()) {
                if (db.insertData(getName(), getRegisterUsername(), getEmail(), getRegisterPassword())) {
                    registerSuccess.setText("Registered go back to login page");
                } else {
                    registerSuccess.setText("We apologize an error occurred at server side");
                }

                registerSuccess.setVisible(true);
            } else {
                System.out.println("Failed");
                registerSuccess.setVisible(false);
            }
        });

        registerPanel.add(title);
        registerPanel.add(firstnameField);
        registerPanel.add(firstnameLabel);
        registerPanel.add(invalidFirstname);
        registerPanel.add(lastnameField);
        registerPanel.add(lastnameLabel);
        registerPanel.add(emailField);
        registerPanel.add(emailLabel);
        registerPanel.add(invalidEmail);
        registerPanel.add(registerUsernameField);
        registerPanel.add(usernameLabel);
        registerPanel.add(registerInvalidUsername);
        registerPanel.add(registerPasswordField);
        registerPanel.add(passwordLabel);
        registerPanel.add(showPass);
        registerPanel.add(inst1);
        registerPanel.add(inst2);
        registerPanel.add(inst3);
        registerPanel.add(inst4);
        registerPanel.add(inst5);
        registerPanel.add(inst6);
        registerPanel.add(registerButton);
        registerPanel.add(label);
        registerPanel.add(registerSuccess);
    }

    private void loggedIn() {
        Label name = new Label("Name:");
        Label username = new Label("Username:");
        Label email = new Label("Email:");
        Label pass = new Label("Password: ");


        Font bold = new Font("Courier", Font.BOLD, 15);
        Font normal = new Font("Courier", Font.PLAIN, 15);

        userCard = new Panel(null);

        name.setBounds(20, 100, 60, 30);
        name.setForeground(skyBlue);
        name.setFont(bold);

        cardName = new Label("NM");
        cardName.setBounds(name.getX() + 60, name.getY(), 200, 30);
        cardName.setForeground(WHITE);
        cardName.setFont(normal);

        username.setBounds(name.getX(), name.getY() + 50, 80, 30);
        username.setForeground(skyBlue);
        username.setFont(bold);

        cardUsername = new Label("NM");
        cardUsername.setBounds(username.getX() + 90, username.getY(), 200, 30);
        cardUsername.setForeground(WHITE);
        cardUsername.setFont(normal);

        email.setBounds(username.getX(), username.getY() + 50, 50, 30);
        email.setForeground(skyBlue);
        email.setFont(bold);

        cardEmail = new Label("NM");
        cardEmail.setBounds(email.getX() + 60, email.getY(), 200, 30);
        cardEmail.setForeground(WHITE);
        cardEmail.setFont(normal);

        pass.setBounds(email.getX(), email.getY() + 50, 80, 30);
        pass.setForeground(skyBlue);
        pass.setFont(bold);

        cardPass = new Label("NM");
        cardPass.setBounds(pass.getX() + 90, pass.getY(), 200, 30);
        cardPass.setForeground(WHITE);
        cardPass.setFont(normal);

        userCard.add(name);
        userCard.add(cardName);
        userCard.add(username);
        userCard.add(cardUsername);
        userCard.add(email);
        userCard.add(cardEmail);
        userCard.add(pass);
        userCard.add(cardPass);
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
        return loginUsernameField.getText().trim().toLowerCase();
    }

    private String getLoginPassword() {
        return loginPasswordField.getText();
    }

    private String getFirstname() {
        return firstnameField.getText().trim().toLowerCase();
    }

    private String getLastname() {
        return lastnameField.getText().trim().toLowerCase();
    }

    private String getName() {
        return capitalize(getFirstname() + " " + getLastname());
    }

    private String getEmail() {
        return emailField.getText().toLowerCase().trim();
    }

    private String getRegisterUsername() {
        return registerUsernameField.getText().toLowerCase().trim();
    }

    private String getRegisterPassword() {
        return registerPasswordField.getText();
    }

    private void setUserInfo(String[] data) {
        cardName.setText(data[0]);
        cardUsername.setText(data[1]);
        cardEmail.setText(data[2]);
        cardPass.setText(data[3]);
    }

    private String capitalize(String str) {
        if (str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    //check validity
    private Boolean isValidFirstname() {
        if (getFirstname().isEmpty()) {
            invalidFirstname.setText("*required");
            invalidFirstname.setVisible(true);
            return false;
        } else if (getFirstname().length() > 50) {
            invalidFirstname.setText("*first name is too long");
            invalidFirstname.setVisible(true);
            return false;
        } else if (getFirstname().length() < 3) {
            invalidFirstname.setText("*Must contain 3 characters");
            invalidFirstname.setVisible(true);
            return false;
        }

        invalidFirstname.setText("");
        invalidFirstname.setVisible(false);
        return true;
    }

    private boolean isValidEmail() {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);

        if (pattern.matcher(getEmail()).matches()) {
            invalidEmail.setVisible(false);
            return true;
        }

        invalidEmail.setVisible(true);
        return false;
    }

    private boolean isValidUsername() {
        String username = getRegisterUsername();
        String usernameRegex = "^(?![_.])[a-zA-Z0-9._]{3,15}(?<![_.])$";
        Pattern pattern = Pattern.compile(usernameRegex);

        if (username.isEmpty()) {
            registerInvalidUsername.setText("*required");
            registerInvalidUsername.setVisible(true);
            return false;
        }

        if (!pattern.matcher(username).matches()) {
            registerInvalidUsername.setText("*Invalid username");
            registerInvalidUsername.setVisible(true);
            return false;
        }

        if (db.isExist(username)) {
            registerInvalidUsername.setText("*already taken by another user");
            registerInvalidUsername.setVisible(true);
            return false;
        }


        registerInvalidUsername.setVisible(false);
        return true;
    }

    private boolean isValidPass() {
        String pass = getRegisterPassword();
        boolean isTrue = true;

        if (pass.length() < 8) {
            inst1.setForeground(Color.RED);
            isTrue = false;
        } else {
            inst1.setForeground(Color.WHITE);
        }

        if (!Pattern.matches("^(?=.*[A-Z]).*$", pass)) {
            inst2.setForeground(Color.RED);
            isTrue = false;
        } else {
            inst2.setForeground(Color.WHITE);
        }

        if (!Pattern.matches("^(?=.*[a-z]).*$", pass)) {
            inst3.setForeground(Color.RED);
            isTrue = false;
        } else {
            inst3.setForeground(Color.WHITE);
        }

        if (!Pattern.matches("^(?=.*[0-9]).*$", pass)) {
            inst4.setForeground(Color.RED);
            isTrue = false;
        } else {
            inst4.setForeground(Color.WHITE);
        }

        if (!Pattern.matches("^(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).*$", pass)) {
            inst5.setForeground(Color.RED);
            isTrue = false;
        } else {
            inst5.setForeground(Color.WHITE);
        }

        return isTrue;
    }
}