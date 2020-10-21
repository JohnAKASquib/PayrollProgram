package GUI;

import java.awt.event.*;
import javax.swing.*;

public class ConfirmDialog extends JFrame implements ActionListener {
    JLabel confirmation;
    JButton ok;
    JDialog cd;

    ConfirmDialog() {
        cd = new JDialog(this, "Success", true);
        confirmation = new JLabel("Operation Successfull");
        ok = new JButton("OK");
        ok.addActionListener(this);
        cd.setLayout(null);
        cd.setSize(300, 150);
        cd.add(ok);
        cd.add(confirmation);
        confirmation.setBounds(50, 25, 150, 15);
        ok.setBounds(75, 65, 100, 30);
    }

    public JFrame getThis() {
        return this;
    }

    public void makeVisible() {
        cd.setVisible(true);
    }

    public void makeNotVisible() {
        cd.setVisible(false);
    }

    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == ok) {
            makeNotVisible();
        }
    }

    public static void main(String args[]) {
        new ConfirmDialog();
    }

}
