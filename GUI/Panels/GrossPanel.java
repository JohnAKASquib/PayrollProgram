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
    String gross = "Employee's Pay Before Deductions from Benefits/Tax";

    public GrossPanel() {
        setLayout(null);
        setupLabels();
        setupTextFields();
        setBoundsForAll();
        addToThis();
    }

    public static void disableIncomeEditing() {
        income.setEditable(false);
    }

    public static void enableIncomeEditing() {
        income.setEditable(true);
    }

    public void resetFields() {
        name.setText("N/A");
        id.setText("N/A");
        income.setText(null);
    }

    private void setupLabels() {
        Font f = new Font("Monospaced", Font.BOLD, 20);
        name = new JLabel("N/A");
        name.setFont(f);
        id = new JLabel("N/A");
        id.setFont(f);
        dollar = new JLabel("$");
        dollar.setFont(f);
        info = new JLabel(gross);
    }

    private void setupTextFields() {
        income = new JTextField();
    }

    private void setBoundsForAll() {
        name.setBounds(80, 250, 300, 25);
        id.setBounds(345, 250, 200, 25);
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
            arr = DBConnection.getPay(idNo, "grossIncome");
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
            NetPanel.getNetPay(Integer.parseInt(id.getText()));
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
