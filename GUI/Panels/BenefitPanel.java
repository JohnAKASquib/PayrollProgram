package GUI.Panels;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import DB.DBConnection;
import GUI.HRScreen;

public class BenefitPanel extends JPanel implements ActionListener {
    static JLabel id, fn, ln, employee, current, pack;
    JTableHeader th;
    JButton details;
    String packages[] = { "Bronze", "Silver", "Gold" };
    String columnNames[] = { "Name", "Cost", "Includes Family" };
    String goldInfo[][] = { { "Health Insurance", "12000", "Yes" }, { "Life Insurance", "10000", "No" },
            { "Legal Insurance", "5000", "No" }, { "Disability Protection", "3000", "Yes" },
            { "Daycare", "8000", "Yes" }, { "Paternal Leave", "8000", "Yes" }, { "Education", "6000", "Yes" },
            { "Transportation", "1000", "No" }, { "Housing", "12000", "Yes" }, { "Paid Vacation", "2000", "No" },
            { "Dental Care", "500", "Yes" }, { "Vision Care", "200", "Yes" } };
    String silverInfo[][] = { { "Dental Care", "500", "Yes" }, { "Disability Protection", "3000", "Yes" },
            { "Health Insurance", "12000", "Yes" }, { "Housing", "12000", "Yes" }, { "Legal Insurance", "5000", "No" },
            { "Paid Vacation", "2000", "No" }, { "Transportation", "1000", "No" }, { "Vision Care", "200", "Yes" } };
    String bronzeInfo[][] = { { "Dental Care", "500", "Yes" }, { "Disability Protection", "3000", "Yes" },
            { "Health Insurance", "12000", "Yes" }, { "Paid Vacation", "2000", "No" },
            { "Vision Care", "200", "Yes" } };
    JTable goldPackage, silverPackage, bronzePackage;
    static JComboBox options;

    public BenefitPanel() {
        setupLabels();
        setupTables();
        setupComboBoxAndTableHeader();
        setupButtons();
        addActionListeners();
        setBoundsForAll();
        addToThis();
        setLayout(null);
        setVisible(true);
    }

    public void makeVisible() {
        setVisible(true);
    }

    private void setBoundsForAll() {
        employee.setBounds(275, 50, 110, 25);
        fn.setBounds(425, 50, 150, 25);
        ln.setBounds(500, 50, 150, 25);
        id.setBounds(600, 57, 250, 15);
        current.setBounds(350, 100, 200, 25);
        pack.setBounds(525, 100, 150, 25);
        options.setBounds(290, 150, 150, 25);
        th.setBounds(250, 240, 1000, 25);
        details.setBounds(500, 150, 200, 25);
        bronzePackage.setBounds(250, 265, 500, 80);
        silverPackage.setBounds(250, 265, 500, 133);
        goldPackage.setBounds(250, 265, 500, 192);
    }

    private void addActionListeners() {
        details.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.details) {
            switchTable();
        }
    }

    public void resetFields() {
        id.setText("No ID Selected");
        fn.setText("N/A");
        ln.setText("N/A");
        pack.setText("None");
    }

    public static void removeBenefits() {
        try {
            DBConnection.removeBenPackage(Integer.valueOf(id.getText()));
            getBenefit(Integer.valueOf(id.getText()));
            HRScreen.getCD().makeVisible();
        } catch (SQLException e) {
            System.out.println("Error removing benefits package");
            e.printStackTrace();
            HRScreen.getED().makeVisible("Error occured while removing benefits");
        }
    }

    public static void updateBenefit() {
        try {
            DBConnection.updateBenPackage(Integer.valueOf(id.getText()),
                    options.getItemAt(options.getSelectedIndex()).toString());
            getBenefit(Integer.valueOf(id.getText()));
            HRScreen.getCD().makeVisible();
        } catch (SQLException e) {
            System.out.println("Error ocurred updating employees benefit package");
            e.printStackTrace();
            HRScreen.getED().makeVisible("Error occured updating benefit package");
        }
    }

    public static void getBenefit(int id) throws SQLException {
        try {
            String[] s = DBConnection.retrieveEmployeeBenPackage(id);
            fn.setText(s[0]);
            ln.setText(s[1]);
            BenefitPanel.id.setText(Integer.toString(id));
            switch (s[2]) {
                case "Bronze":
                    pack.setText("Bronze");
                    pack.setForeground(Color.RED);
                    break;
                case "Silver":
                    pack.setText("Silver");
                    pack.setForeground(Color.LIGHT_GRAY);
                    break;
                case "Gold":
                    pack.setText("Gold");
                    pack.setForeground(Color.YELLOW);
                    break;
                case "NULL":
                    pack.setText("None");
                    pack.setForeground(Color.BLACK);
                default:
                    return;
            }

        } catch (SQLException e) {
            System.out.println("Error when retrieving benefit package");
            throw e;
        }
    }

    private void switchTable() {
        if (bronzePackage.isVisible())
            bronzePackage.setVisible(false);
        else if (silverPackage.isVisible())
            silverPackage.setVisible(false);
        else if (goldPackage.isVisible())
            goldPackage.setVisible(false);
        String choice = options.getItemAt(options.getSelectedIndex()).toString();
        switch (choice) {
            case "Bronze":
                bronzePackage.setVisible(true);
                break;
            case "Silver":
                silverPackage.setVisible(true);
                break;
            case "Gold":
                goldPackage.setVisible(true);
                break;
            default:
                return;
        }
    }

    private void setupLabels() {
        Font f = new Font("Dialog", Font.BOLD, 18);
        id = new JLabel("No ID Selected");
        id.setFont(f);
        employee = new JLabel("Employee: ");
        employee.setFont(f);
        fn = new JLabel("N/A");
        fn.setFont(f);
        ln = new JLabel("N/A");
        ln.setFont(f);
        current = new JLabel("Current Package: ");
        current.setFont(f);
        pack = new JLabel("None");
        pack.setFont(f);
    }

    private void setupButtons() {
        details = new JButton("Show Package Details");
    }

    private void setupComboBoxAndTableHeader() {
        options = new JComboBox(packages);
        th = bronzePackage.getTableHeader();
    }

    private void setupTables() {
        goldPackage = new JTable(goldInfo, columnNames);
        silverPackage = new JTable(silverInfo, columnNames);
        bronzePackage = new JTable(bronzeInfo, columnNames);
        goldPackage.setVisible(false);
        silverPackage.setVisible(false);
        bronzePackage.setVisible(true);
        goldPackage.setEnabled(false);
        silverPackage.setEnabled(false);
        bronzePackage.setEnabled(false);
        goldPackage.setBackground(Color.LIGHT_GRAY);
        silverPackage.setBackground(Color.LIGHT_GRAY);
        bronzePackage.setBackground(Color.LIGHT_GRAY);
    }

    private void addToThis() {
        add(employee);
        add(fn);
        add(ln);
        add(id);
        add(current);
        add(pack);
        add(options);
        add(th);
        add(details);
        add(bronzePackage);
        add(silverPackage);
        add(goldPackage);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setLayout(null);
        f.add(new BenefitPanel());
        f.setSize(1000, 650);
        f.setVisible(true);
    }
}
