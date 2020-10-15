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
        logscreen.setSize(500, 325);
    }

    public void addActionListeners() {
        logscreen.getHRLogin().addActionListener(this);
        screen.getLogout().addActionListener(this);
        // logscreen.getEMPLogin().addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == logscreen.getHRLogin()) {
            screen.setVisible(true);
            logscreen.setVisible(false);
        } else if (source == screen.getLogout()) {
            logscreen.setVisible(true);
            screen.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new PayrollProgram();
    }
}
