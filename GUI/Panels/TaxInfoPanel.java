package GUI.Panels;

import java.awt.Color;

import javax.swing.*;
import javax.swing.table.JTableHeader;

public class TaxInfoPanel extends JPanel {
    JTableHeader th;
    JTable taxInfo;
    JLabel info;
    String columnHeader[] = { "Tax Type", "Percentage" };
    String data[][] = { { "Federal Income", "14.03%" }, { "State Income", "5.07%" }, { "Local Income", "3.48%" },
            { "Medicare", "1.45%" }, { "Social Security", "6.2%" } };

    public TaxInfoPanel() {
        setLayout(null);
        setupLabels();
        setupTable();
        setupTableHeader();
        setBoundsForAll();
        addToThis();
    }

    private void setupLabels() {
        info = new JLabel("*Tax Rate Information for NY State");
    }

    private void setupTable() {
        taxInfo = new JTable(data, columnHeader);
        taxInfo.setBackground(Color.LIGHT_GRAY);
    }

    private void setupTableHeader() {
        th = taxInfo.getTableHeader();
    }

    private void setBoundsForAll() {
        info.setBounds(10, 10, 450, 20);
        th.setBounds(250, 125, 700, 25);
        taxInfo.setBounds(250, 150, 700, 87);
    }

    private void addToThis() {
        add(info);
        add(th);
        add(taxInfo);
    }
}
