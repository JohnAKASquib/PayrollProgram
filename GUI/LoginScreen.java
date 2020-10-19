package GUI;

import javax.swing.*;

public class LoginScreen extends JFrame {
    JFrame f;
    JButton empLogin, hrLogin;
    JTextField userID;
    JPasswordField passphrase;
    JLabel username, password;

    public LoginScreen() {
        setupFrame();
        setupLabels();
        setupTextFields();
        setupButtons();
        addToFrame();
        setLayout(null);
        setVisible(true);
    }

    public void setupFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setupLabels() {
        username = new JLabel("ID Number:");
        password = new JLabel("Password:");
        username.setBounds(50, 100, 70, 15);
        password.setBounds(50, 150, 70, 15);
    }

    public void setupTextFields() {
        userID = new JTextField();
        passphrase = new JPasswordField();
        userID.setBounds(150, 100, 200, 30);
        passphrase.setBounds(150, 150, 200, 30);
    }

    public void setupButtons() {
        empLogin = new JButton("Employee Login");
        hrLogin = new JButton("HR Login");
        empLogin.setBounds(50, 200, 120, 30);
        hrLogin.setBounds(220, 200, 120, 30);
    }

    public void addToFrame() {
        add(username);
        add(userID);
        add(password);
        add(passphrase);
        add(empLogin);
        add(hrLogin);
    }

    public JButton getHRLogin() {
        return this.hrLogin;
    }

    public JButton getEMPLogin() {
        return this.empLogin;
    }

    public JTextField getUserField() {
        return this.userID;
    }

    public JPasswordField getPassField() {
        return this.passphrase;
    }

    public static void main(String[] args) {
        new LoginScreen();
    }
}