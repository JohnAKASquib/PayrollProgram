package GUI.DialogBoxes;

import javax.swing.*;
import java.awt.event.*;
import GUI.HRScreen;
import GUI.Panels.*;

public class DeleteDialog extends JFrame implements ActionListener {
    JDialog dd;
    JButton delete;
    JLabel enter;
    JTextField idfield;
    String del = "Delete";

    public DeleteDialog() {
        dd = new JDialog(this, "ID Delete", true);
        delete = new JButton(del);
        enter = new JLabel("Enter ID Number:");
        idfield = new JTextField();
        delete.addActionListener(this);
        dd.setLayout(null);
        dd.setSize(300, 150);
        dd.add(delete);
        dd.add(enter);
        dd.add(idfield);
        enter.setBounds(25, 25, 150, 15);
        idfield.setBounds(150, 25, 120, 22);
        delete.setBounds(85, 70, 100, 25);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Object source = ae.getSource();
            if (source == delete && delete.getText() == del) {
                makeNotVisible();
                HRScreen.deleteEmployee(Integer.parseInt(idfield.getText()));
            }
        } catch (NumberFormatException e) {
            makeNotVisible();
            HRScreen.getED().makeVisible("Error: ID Number must be an Integer");
        }
    }

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