package GUI.DialogBoxes;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

import GUI.HRScreen;
import GUI.Panels.*;

public class WarningDialog extends JFrame implements ActionListener {
    JLabel sure, id;
    JButton confirm, cancel;
    JDialog wd;
    String updateEmp = "Are you sure you want to overwrite user ID: ",
            updateBen = "Update the Benefit Package for this Employee?", removeBen = "Remove this employee's benefits?";

    public WarningDialog() {
        wd = new JDialog(this, "WARNING", true);
        sure = new JLabel(updateEmp);
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
        sure.setBounds(50, 25, 300, 15);
        id.setBounds(160, 41, 100, 15);
        confirm.setBounds(25, 65, 100, 30);
        cancel.setBounds(200, 65, 100, 30);
    }

    public void makeVisible(String s) {
        sure.setText(updateEmp);
        id.setText(s);
        wd.setVisible(true);
    }

    public void makeVisible() {
        sure.setText(updateBen);
        id.setText(null);
        wd.setVisible(true);
    }

    public void makeVisible(int code) {
        sure.setText(removeBen);
        id.setText(null);
        wd.setVisible(true);
    }

    public void makeNotVisible() {
        id.setText("");
        wd.setVisible(false);
    }

    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == confirm && sure.getText() == updateEmp) {
            makeNotVisible();
            HRScreen.updateEmployee();
        } else if (source == confirm && sure.getText() == updateBen) {
            makeNotVisible();
            BenefitPanel.updateBenefit();
        } else if (source == confirm && sure.getText() == removeBen) {
            makeNotVisible();
            BenefitPanel.removeBenefits();
        } else if (source == cancel) {
            makeNotVisible();
        }
    }

    public static void main(String args[]) {
        new WarningDialog();
    }
}
