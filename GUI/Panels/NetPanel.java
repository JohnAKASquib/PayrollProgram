package GUI.Panels;

import java.awt.Font;
import java.sql.SQLException;
import GUI.HRScreen;
import javax.swing.*;
import DB.DBConnection;

public class NetPanel extends JPanel {
    static JLabel name, id;
    JLabel info, dollar, benPack, pack, packDeduction, taxes,fed,state,loc,med,socsec,fedTax,stateTax,locTax,medTax,socsecTax;
    static JTextField income;
    String Net = "Net Income cannot be edited, it will be updated when Gross Income is.";

    public NetPanel() {
        setLayout(null);
        setupLabels();
        setupTextFields();
        setBoundsForAll();
        addToThis();
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
        info = new JLabel(Net);
        benPack=new JLabel("Benefit Package: ");
        pack=new JLabel("None");
        packDeduction=new JLabel("$0");
        taxes=new JLabel("NYC Taxes");
        fed=new JLabel("Federal Tax: ");
        state=new JLabel("State Tax: ");
        loc=new JLabel("Local Tax: ");
        med=new JLabel("Medicare: ");
        socsec=new JLabel("Social Security: ");
        fedTax=new JLabel("$");
        stateTax=new JLabel("$");
        locTax=new JLabel("$");
        medTax=new JLabel("$");
        socsecTax=new JLabel("$");
    }

    private void setupTextFields() {
        income = new JTextField();
        income.setEditable(false);
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

    public static void getNetPay(int idNo) {
        String arr[];
        try {
            arr = DBConnection.getPay(idNo, "netIncome");
            income.setText(arr[0]);
            name.setText(arr[1] + "  " + arr[2]);
            id.setText(Integer.toString(idNo));
        } catch (SQLException e) {
            e.printStackTrace();
            HRScreen.getED().makeVisible("Error retrieving Net Pay");
        }
    }
}