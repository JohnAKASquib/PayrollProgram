package GUI.DialogBoxes;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

import GUI.HRScreen;
import GUI.Panels.*;

public class SearchDialog extends JFrame implements ActionListener {
    JDialog sd;
    JButton submit;
    JLabel enter;
    JTextField idfield;

    public SearchDialog() {
        sd = new JDialog(this, "ID Search", true);
        submit = new JButton("Search");
        enter = new JLabel("Enter ID Number:");
        idfield = new JTextField();
        submit.addActionListener(this);
        sd.setLayout(null);
        sd.setSize(300, 150);
        sd.add(submit);
        sd.add(enter);
        sd.add(idfield);
        enter.setBounds(25, 25, 150, 15);
        idfield.setBounds(150, 25, 120, 22);
        submit.setBounds(85, 70, 100, 25);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Object source = ae.getSource();
            if (source == submit) {
                makeNotVisible();
                if (HRScreen.getChoice().getText() == "Employee Info") {
                    HRScreen.retrieveEmployee(Integer.parseInt(idfield.getText()));
                } else if (HRScreen.getChoice().getText() == "Former Employees") {
                    FormerEmpPanel.retrieveFormerEmployee(Integer.parseInt(idfield.getText()));
                } else if (HRScreen.getChoice().getText() == "Employee Benefits") {
                    BenefitPanel.getBenefit(Integer.parseInt(idfield.getText()));
                } else if (HRScreen.getChoice().getText() == "Employee Gross Pay"
                        || HRScreen.getChoice().getText() == "Employee Net Pay") {
                    NetPanel.getNetPay(Integer.parseInt(idfield.getText()));
                    GrossPanel.getGrossPay(Integer.parseInt(idfield.getText()));
                } else if (HRScreen.getChoice().getText() == "Other Employees") {
                    OtherEmpsPanel.retrieveOtherEmployee(Integer.parseInt(idfield.getText()));
                } else {
                    HRScreen.getED().makeVisible("Can't search with this panel");
                }
            }
        } catch (NumberFormatException e) {
            makeNotVisible();
            HRScreen.getED().makeVisible("Error: ID Number must be an Integer");
        } catch (SQLException e) {
            makeNotVisible();
            HRScreen.getED().makeVisible("Error: No match for that ID");
        }
    }

    public void makeVisible() {
        sd.setVisible(true);
    }

    public void makeNotVisible() {
        sd.setVisible(false);
    }

    public static void main(String args[]) {
        new SearchDialog();
    }
}
