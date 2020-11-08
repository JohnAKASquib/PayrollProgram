package GUI.Panels;

import javax.swing.*;
import java.awt.event.*;

public class FormerEmpPanel extends JPanel implements ActionListener {
    JLabel firstname, lastname, idNumber, dateHired, dateLeft, address, emailaddress, mobPhone, reasonForLeaving;
    JTextField fn, ln, idNo, hired, left, addr, email, mobile, reason;
    JButton select;
    JComboBox reasons;
    String reasonsWhy[] = { "TERMINATED", "QUIT", "DECEASED", "DISABLED" };

    public FormerEmpPanel() {
        setupLabels();
        setupTextFields();
        setupComboBoxAndButton();
        addActionListeners();
        addToThis();
        setBoundsForAll();
    }

    private void setupLabels() {
        firstname = new JLabel("First Name: ");
        lastname = new JLabel("Last Name: ");
        idNumber = new JLabel("ID Number: ");
        dateHired = new JLabel("Date Hired: ");
        dateLeft = new JLabel("Date Left: ");
        address = new JLabel("Address: ");
        emailaddress = new JLabel("Email: ");
        mobPhone = new JLabel("Cell Phone #: ");
        reasonForLeaving = new JLabel("Reason of Leaving: ");
    }

    private void setupTextFields() {
        fn = new JTextField();
        ln = new JTextField();
        idNo = new JTextField();
        hired = new JTextField();
        left = new JTextField();
        addr = new JTextField();
        email = new JTextField();
        mobile = new JTextField();
        reason = new JTextField();
        reason.setEditable(false);
    }

    private void setupComboBoxAndButton() {
        reasons = new JComboBox(reasonsWhy);
        select = new JButton("Update Reason");
    }

    private void setBoundsForAll() {
        // labels
        firstname.setBounds(200, 50, 190, 22);
        lastname.setBounds(200, 90, 190, 22);
        idNumber.setBounds(200, 130, 190, 22);
        dateHired.setBounds(200, 170, 190, 22);
        dateLeft.setBounds(200, 210, 190, 22);
        address.setBounds(200, 250, 190, 22);
        emailaddress.setBounds(200, 290, 190, 22);
        mobPhone.setBounds(200, 330, 190, 22);
        reasonForLeaving.setBounds(200, 370, 190, 22);
        // text fields
        fn.setBounds(410, 50, 160, 22);
        ln.setBounds(410, 90, 160, 22);
        idNo.setBounds(410, 130, 160, 22);
        hired.setBounds(410, 170, 160, 22);
        left.setBounds(410, 210, 160, 22);
        addr.setBounds(410, 250, 160, 22);
        email.setBounds(410, 290, 160, 22);
        mobPhone.setBounds(410, 330, 160, 22);
        reason.setBounds(410, 370, 160, 22);
        // combo box with button
        reasons.setBounds(580, 370, 195, 30);
        select.setBounds(795, 370, 190, 25);
    }

    private void addActionListeners() {
        select.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == select) {
            reason.setText(reasons.getItemAt(reasons.getSelectedIndex()).toString());
        }
    }

    private void addToThis() {
        // labels
        add(firstname);
        add(lastname);
        add(idNumber);
        add(dateHired);
        add(dateLeft);
        add(address);
        add(emailaddress);
        add(mobPhone);
        add(reasonForLeaving);
        // text fields
        add(fn);
        add(ln);
        add(idNo);
        add(hired);
        add(left);
        add(addr);
        add(email);
        add(mobile);
        add(reason);
        // combo box and button
        add(reasons);
        add(select);
    }
    
    
}
