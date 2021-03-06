import GUI.*;
import java.awt.event.*;

public class PayrollProgram implements ActionListener {
    HRScreen screen;
    LoginScreen logscreen;

    PayrollProgram() {
        setupScreens();
        addActionListeners();
    }

    public void setupScreens() {
        screen = new HRScreen();
        logscreen = new LoginScreen();
        screen.setVisible(false);
    }

    public void addActionListeners() {
        logscreen.getHRLogin().addActionListener(this);
        logscreen.getEMPLogin().addActionListener(this);
        screen.getLogout().addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == logscreen.getHRLogin()) {
            login(false);
        } else if (source == logscreen.getEMPLogin()) {
            login(true);

        } else if (source == screen.getLogout()) {
            logout();
        }
    }

    private void EMPLogin() {
        if (logscreen.EMPPasswordMatch() == true) {
            logscreen.setVisible(false);
            screen.setVisible(true);
            screen.empLoggedIn(Integer.parseInt(logscreen.getUserField().getText()));
        } else
            return;
    }

    private void HRLogin() {
        if (logscreen.HRPasswordMatch() == true) {
            logscreen.setVisible(false);
            screen.setVisible(true);
        } else {
            return;
        }
    }

    public void login(boolean employee) {
        if (employee == true) {
            EMPLogin();
        } else {
            HRLogin();
        }
        logscreen.getUserField().setText(null);
        logscreen.getPassField().setText(null);
    }

    public void logout() {
        logscreen.setVisible(true);
        screen.setVisible(false);
        screen.empLoggedOut();
        screen.clearFields();
    }

    public static void main(String[] args) {
        new PayrollProgram();
    }
}
