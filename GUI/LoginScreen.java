package GUI;

import javax.swing.*;

public class LoginScreen {
    JFrame f;

    LoginScreen() {
        f = new JFrame();
        JButton empLogin = new JButton("Employee Login");
        empLogin.setBounds(50, 200, 120, 30);
        JButton hrLogin = new JButton("HR Login");
        hrLogin.setBounds(220, 200, 120, 30);
        JTextField userID = new JTextField();
        userID.setBounds(150, 100, 200, 30);
        JTextField passphrase = new JTextField();
        passphrase.setBounds(150, 150, 200, 30);
        JLabel username = new JLabel("ID Number:");
        username.setBounds(50, 100, 70, 15);
        JLabel password = new JLabel("Password:");
        password.setBounds(50, 150, 70, 15);
        f.add(username);
        f.add(userID);
        f.add(password);
        f.add(passphrase);
        f.add(empLogin);
        f.add(hrLogin);
        f.setSize(500, 325);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginScreen();
    }
}