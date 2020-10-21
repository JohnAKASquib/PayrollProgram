package GUI.DialogBoxes;

import javax.swing.*;
import java.awt.event.*;
import GUI.HRScreen;

public class SearchDialog extends JFrame implements ActionListener {
    JDialog sd;
    JButton submit;
    JLabel enter;
    JTextField idfield;

    public SearchDialog() {
        sd = new JDialog(this, "ID Search", true);
        submit = new JButton("Search");
        enter = new JLabel("Enter ID Number:");
        idfield = new JTextField();
        submit.addActionListener(this);
        sd.setLayout(null);
        sd.setSize(300, 150);
        sd.add(submit);
        sd.add(enter);
        sd.add(idfield);
        enter.setBounds(25, 25, 150, 15);
        idfield.setBounds(150, 25, 120, 22);
        submit.setBounds(85, 70, 100, 25);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Object source = ae.getSource();
            if (source == submit) {
                makeNotVisible();
                HRScreen.retrieveEmployee(Integer.parseInt(idfield.getText()));
            }
        } catch (NumberFormatException e) {
            makeNotVisible();
            HRScreen.getED().makeVisible("Error: ID Number must be an Integer");
        }
    }

    public void makeVisible() {
        sd.setVisible(true);
    }

    public void makeNotVisible() {
        sd.setVisible(false);
    }

    public static void main(String args[]) {
        new SearchDialog();
    }
}
