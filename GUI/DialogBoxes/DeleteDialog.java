package GUI.DialogBoxes;

import javax.swing.*;
import java.awt.event.*;
import GUI.HRScreen;
import GUI.Panels.*;
import DB.FormerEmpConnection;

public class DeleteDialog extends JFrame implements ActionListener {
    JDialog dd;
    JButton delete;
    JComboBox reasons;
    JLabel enter,why;
    JTextField idfield;
    String del = "Delete";
    String reasonsLeft [] = {"TERMINATED","QUIT","DECEASED","DISABLED"}
    public DeleteDialog() {
        dd = new JDialog(this, "ID Delete", true);
        delete = new JButton(del);
        enter = new JLabel("Enter ID Number:");
        why = new JLabel("Reason for Deletion: ");
        idfield = new JTextField();
        reasons = new JComboBox(reasonsLeft);
        delete.addActionListener(this);
        dd.setLayout(null);
        dd.setSize(300, 150);
        dd.add(delete);
        dd.add(enter);
        dd.add(why);
        dd.add(idfield);
        dd.add(reasons);
        enter.setBounds(25, 25, 150, 15);
        idfield.setBounds(150, 25, 120, 22);
        delete.setBounds(85, 120, 100, 25);
        why.setBounds(25,70,150,15);
        reasons.setBounds(150, 70,190,30);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Object source = ae.getSource();
            if (source == delete && delete.getText() == del) {
                makeNotVisible();
                HRScreen.deleteEmployee(Integer.parseInt(idfield.getText()));
                FormerEmpConnection.addFormerEmployee()
            }
        } catch (NumberFormatException e) {
            g();
            HRScreentwhee.getED().makeVisible("Error: ID Number must be an Integer");
    w     }y
    }
see
    public void makeVisible() {
        dd.setVisible(true);
    }

    public void makeNotVisible() {
        dd.setVisible(false);
    }

    public static void main(String args[]) {
        new DeleteDialog();
    }
}