package GUI.Panels;

import java.awt.Font;
import java.sql.SQLException;
import java.util.Map;
import java.awt.font.TextAttribute;
import GUI.HRScreen;
import javax.swing.*;
import DB.DBConnection;

public class NetPanel extends JPanel {
    static JLabel name, id;
    JLabel info, dollar, benPack, taxes, fed, state, loc, med, socsec;
    static JLabel pack, packDeduction, fedTax, stateTax, locTax, medTax, socsecTax;
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
        pack.setText("None");
        packDeduction.setText("$0");
        fedTax.setText("$0");
        stateTax.setText("$0");
        locTax.setText("$0");
        medTax.setText("$0");
        socsecTax.setText("$0");
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
        benPack = new JLabel("Benefit Package: ");
        pack = new JLabel("None");
        packDeduction = new JLabel("$0");
        taxes = new JLabel("NYC Taxes");
        Font uline = taxes.getFont();
        Map attributes = uline.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        taxes.setFont(uline.deriveFont(attributes));
        fed = new JLabel("Federal Tax: ");
        state = new JLabel("State Tax: ");
        loc = new JLabel("Local Tax: ");
        med = new JLabel("Medicare: ");
        socsec = new JLabel("Social Security: ");
        fedTax = new JLabel("$0");
        stateTax = new JLabel("$0");
        locTax = new JLabel("$0");
        medTax = new JLabel("$0");
        socsecTax = new JLabel("$0");
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
        benPack.setBounds(60, 300, 190, 17);
        pack.setBounds(190, 300, 100, 17);
        packDeduction.setBounds(270, 300, 100, 17);
        taxes.setBounds(515, 300, 120, 17);
        fed.setBounds(495, 315, 130, 17);
        state.setBounds(495, 330, 130, 17);
        loc.setBounds(495, 345, 130, 17);
        med.setBounds(495, 360, 130, 17);
        socsec.setBounds(495, 375, 130, 17);
        fedTax.setBounds(595, 315, 130, 17);
        stateTax.setBounds(595, 330, 130, 17);
        locTax.setBounds(595, 345, 130, 17);
        medTax.setBounds(595, 360, 130, 17);
        socsecTax.setBounds(595, 375, 130, 17);
    }

    private void addToThis() {
        add(name);
        add(id);
        add(info);
        add(dollar);
        add(income);
        add(benPack);
        add(pack);
        add(packDeduction);
        add(taxes);
        add(fed);
        add(state);
        add(loc);
        add(med);
        add(socsec);
        add(fedTax);
        add(stateTax);
        add(locTax);
        add(medTax);
        add(socsecTax);
    }

    public static void getNetPay(int idNo) {
        String arr[];
        int grossPay;
        double fTax, sTax, lTax, mTax, socTax;
        try {
            // set taxes first
            arr = DBConnection.getPay(idNo, "grossIncome");
            grossPay = Integer.parseInt(arr[0]);
            fTax = grossPay * .14;
            sTax = grossPay * .05;
            lTax = grossPay * .034;
            mTax = grossPay * .014;
            socTax = grossPay * .062;
            fedTax.setText("$" + Integer.toString((int) fTax));
            stateTax.setText("$" + Integer.toString((int) sTax));
            locTax.setText("$" + Integer.toString((int) lTax));
            medTax.setText("$" + Integer.toString((int) mTax));
            socsecTax.setText("$" + Integer.toString((int) socTax));
            // then do the usual stuff
            arr = DBConnection.getPay(idNo, "netIncome");
            income.setText(arr[0]);
            name.setText(arr[1] + "  " + arr[2]);
            id.setText(Integer.toString(idNo));
            // then benefits
            arr = DBConnection.retrieveEmployeeBenPackage(idNo);
            pack.setText(arr[2]);
            switch (arr[2]) {
                case "Bronze":
                    packDeduction.setText("$1200");
                    break;
                case "Silver":
                    packDeduction.setText("$4400");
                    break;
                case "Gold":
                    packDeduction.setText("$9100");
                    break;
                case "NULL":
                    pack.setText("None");
                    packDeduction.setText("$0");
                    break;
                default:
                    pack.setText("None");
                    packDeduction.setText("$0");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            HRScreen.getED().makeVisible("Error retrieving Net Pay");
        }
    }
}