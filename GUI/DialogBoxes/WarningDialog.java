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
            updateBen = "Update the Benefit Package for this Employee?", removeBen = "Remove this employee's benefits?",
            updatePay = "Update this employee's pay?";
            updateFormer="Update info for this former employee?";

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
        if (code == 1)
            sure.setText(removeBen);
        else if (code == 2)
            sure.setText(updatePay);
        else if (code==3)
            sure.setText(updateFormer);
        id.setText(null);
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
            if (sure.getText() == updateEmp) {
                HRScreen.updateEmployee();
            } else if (sure.getText() == updateBen) {
                BenefitPanel.updateBenefit();
            } else if (sure.getText() == removeBen) {
                BenefitPanel.removeBenefits();
            } else if (sure.getText() == updatePay) {
                GrossPanel.updatePay();
            } else if (sure.getText() == updateFormer){
              FormerEmpPanel.updateFormerEmployee();
            }
        } else if (source == cancel) {
            makeNotVisible();
        }
    }

    public static void main(String args[]) {
        new WarningDialog();
    }
}
