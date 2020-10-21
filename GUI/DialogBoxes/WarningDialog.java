package GUI.DialogBoxes;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

import GUI.HRScreen;

public class WarningDialog extends JFrame implements ActionListener {
    JLabel sure, id;
    JButton confirm, cancel;
    JDialog wd;

    public WarningDialog() {
        wd = new JDialog(this, "WARNING", true);
        sure = new JLabel("Are you sure you want to overwrite user ID: ");
        id = new JLabel();
        confirm = new JButton("CONFIRM");
        cancel = new JButton("CANCEL");
        confirm.addActionListener(this);
        cancel.addActionListener(this);
        id.setForeground(Color.MAGENTA);
        wd.setLayout(null);
        wd.setSize(350, 150);
        wd.add(confirm);
        wd.add(sure);
        wd.add(cancel);
        wd.add(id);
        sure.setBounds(50, 25, 250, 15);
        id.setBounds(160, 41, 100, 15);
        confirm.setBounds(25, 65, 100, 30);
        cancel.setBounds(200, 65, 100, 30);
    }

    public void makeVisible(String s) {
        id.setText(s);
        wd.setVisible(true);
    }

    public void makeNotVisible() {
        id.setText("");
        wd.setVisible(false);
    }

    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == confirm) {
            makeNotVisible();
            HRScreen.updateEmployee();
        } else if (source == cancel) {
            makeNotVisible();
        }
    }

    public static void main(String args[]) {
        new WarningDialog();
    }
}
