package GUI.Panels;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.*;
import DB.DBConnection;
import GUI.HRScreen;

public class GrossPanel extends JPanel {
    static JLabel name, id;
    JLabel info, dollar;
    static JTextField income;

    public GrossPanel() {
        setLayout(null);
        setupLabels();
        setupTextFields();
        setBoundsForAll();
        addToThis();
    }

    private void setupLabels() {
        Font f = new Font("Monospaced", Font.BOLD, 20);
        name = new JLabel("N/A");
        name.setFont(f);
        id = new JLabel("N/A");
        id.setFont(f);
        dollar = new JLabel("$");
        dollar.setFont(f);
        info = new JLabel("Employee's Pay Before Deductions from Benefits/Tax");
    }

    private void setupTextFields() {
        income = new JTextField();
    }

    private void setBoundsForAll() {
        name.setBounds(80, 250, 180, 25);
        id.setBounds(345, 250, 100, 25);
        info.setBounds(280, 170, 500, 17);
        dollar.setBounds(480, 250, 15, 17);
        income.setBounds(500, 250, 275, 28);
    }

    private void addToThis() {
        add(name);
        add(id);
        add(info);
        add(dollar);
        add(income);
    }

    public static void getGrossPay(int idNo) {
        String arr[];
        try {
            arr = DBConnection.getGrossPay(idNo);
            income.setText(arr[0]);
            name.setText(arr[1] + "  " + arr[2]);
            id.setText(Integer.toString(idNo));
            HRScreen.getCD().makeVisible();
        } catch (SQLException e) {
            e.printStackTrace();
            HRScreen.getED().makeVisible("Error retrieving Gross Pay");
        }
    }

    public static void updatePay() {
        try {
            DBConnection.updatePay(Integer.parseInt(id.getText()), Integer.parseInt(income.getText()));
            HRScreen.getCD().makeVisible();
        } catch (SQLException e) {
            e.printStackTrace();
            HRScreen.getED().makeVisible("Error updating Gross/Net Pay");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            HRScreen.getED().makeVisible("Pay must be an Integer!");
        }
    }
}
