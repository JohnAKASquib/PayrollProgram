package GUI.Panels;

import java.awt.Font;

import javax.swing.*;

public class BenefitPanel extends JPanel {
    JLabel id, fn, ln, employee;
    String packages[] = { "Bronze", "Silver", "Gold" };
    JComboBox options;

    public BenefitPanel() {
        setupLabels();
        setupComboBox();
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
        fn.setBounds(425, 57, 150, 15);
        ln.setBounds(500, 57, 150, 15);
        id.setBounds(600, 57, 250, 15);
        options.setBounds(400, 100, 150, 25);
    }

    private void setupLabels() {
        id = new JLabel("No ID Selected");
        id.setFont(new Font("Dialog", Font.BOLD, 18));
        employee = new JLabel("Employee: ");
        employee.setFont(new Font("Dialog", Font.BOLD, 18));
        fn = new JLabel("N/A");
        fn.setFont(new Font("Dialog", Font.BOLD, 18));
        ln = new JLabel("N/A");
        ln.setFont(new Font("Dialog", Font.BOLD, 18));
    }

    private void setupComboBox() {
        options = new JComboBox(packages);
    }

    private void addToThis() {
        add(employee);
        add(fn);
        add(ln);
        add(id);
        add(options);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setLayout(null);
        f.add(new BenefitPanel());
        f.setSize(1000, 650);
        f.setVisible(true);
    }
}
