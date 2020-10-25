package GUI.DialogBoxes;

import javax.swing.*;
import java.awt.event.*;
import DB.*;
import GUI.Panels.*;

public class UnlockDialog extends JFrame implements ActionListener {
    JDialog ud;
    JButton Unlock;
    JLabel enter;
    JTextField idfield;
    String unl = "Unlock";

    public UnlockDialog() {
        ud = new JDialog(this, "ID Unlock", true);
        Unlock = new JButton(unl);
        enter = new JLabel("Enter ID Number:");
        idfield = new JTextField();
        Unlock.addActionListener(this);
        ud.setLayout(null);
        ud.setSize(300, 150);
        ud.add(Unlock);
        ud.add(enter);
        ud.add(idfield);
        enter.setBounds(25, 25, 150, 15);
        idfield.setBounds(150, 25, 120, 22);
        Unlock.setBounds(85, 70, 100, 25);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Object source = ae.getSource();
            if (source == Unlock && Unlock.getText() == unl) {
                DBConnection.resetFailedAttempts(Integer.parseInt(idfield.getText()));
            }
        } catch (NumberFormatException e) {
            HRScreen.getED().makeVisible("Error: ID Number must be an Integer");
        } catch (SQLException e){
          HRScreen.getED().makeVisible("Error unlocking ser with tgat ID");
        } finally{
          makeNotVisible();
        }
    }

    public void makeVisible() {
        ud.setVisible(true);
    }

    public void makeNotVisible() {
        ud.setVisible(false);
    }

    public static void main(String args[]) {
        new UnlockDialog();
    }
}