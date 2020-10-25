package GUI;

import java.awt.Color;
import javax.swing.*;
import DB.*;

public class LoginScreen extends JFrame {
    JFrame f;
    JButton empLogin, hrLogin;
    JTextField userID;
    JPasswordField passphrase;
    JLabel username, password, incorrect, locked;

    public LoginScreen() {
        super("Payroll Program");
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
        setSize(500, 325);
    }

    public void setupLabels() {
        username = new JLabel("ID Number:");
        password = new JLabel("Password:");
        incorrect = new JLabel("Password/UserID Incorrect");
        locked=new JLabel("User locked due to failed attempts");
        username.setBounds(50, 50, 70, 15);
        password.setBounds(50, 100, 70, 15);
        incorrect.setBounds(110, 150, 200, 15);
        incorrect.setForeground(Color.RED);
        incorrect.setVisible(false);
        locked.setBounds(110,150,200,15);
        locked.setForeground(Color.RED);
        locked.setVisible(false);
    }

    public void setupTextFields() {
        userID = new JTextField();
        passphrase = new JPasswordField();
        userID.setBounds(150, 50, 200, 30);
        passphrase.setBounds(150, 100, 200, 30);
    }

    public void setupButtons() {
        empLogin = new JButton("Employee Login");
        hrLogin = new JButton("HR Login");
        empLogin.setBounds(50, 200, 170, 30);
        hrLogin.setBounds(270, 200, 120, 30);
    }

    public void addToFrame() {
        add(username);
        add(userID);
        add(password);
        add(passphrase);
        add(empLogin);
        add(hrLogin);
        add(incorrect);
    }

    public Boolean HRPasswordMatch() {
      if(locked.isVisible()){
        locked.setVisible(false);
      }
        if (DBConnection.getPassword(Integer.parseInt(userID.getText()), String.valueOf(passphrase.getPassword()),
                "hr") == false) {
            incorrect.setVisible(true);
            return false;
        } else {
            incorrect.setVisible(false);
            return true;
        }
    }

    public Boolean EMPPasswordMatch() {
      if(DBConnection.retrieveFailedAttempts(Integer.parseInt(userID.getText()))>=3){
        if(incorrect.isVisible()){
          incorrect.setVisible(false);
        }
        locked.setVisible(true);
        return false;
      }
       else if (DBConnection.getPassword(Integer.parseInt(userID.getText()), String.valueOf(passphrase.getPassword()),
                "employee") == false) {
            if (locked.isVisible()){
              locked.setVisible(false);
            }
            DBConnection.incrementFailedAttempts(Integer.parseInt(userID.getText()))
            incorrect.setVisible(true);
            return false;
        } else {
            locked.setVisible(false);
            incorrect.setVisible(false);
            return true;
        }

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