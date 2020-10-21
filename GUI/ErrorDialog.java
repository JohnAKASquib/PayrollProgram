package GUI;

import javax.swing.*;
import java.awt.event.*;

public class ErrorDialog extends JFrame implements ActionListener {
    String basic_error = "Encountered an error occurred during operation";
    JLabel error;
    JButton close;
    JDialog ed;

    ErrorDialog() {
        ed = new JDialog(this, "Error", true);
        error = new JLabel(basic_error);
        close = new JButton("Close");
        close.addActionListener(this);
        ed.setLayout(null);
        ed.setSize(300, 150);
        ed.add(close);
        ed.add(error);
        error.setBounds(5, 25, 290, 15);
        close.setBounds(75, 65, 100, 30);
    }

    public void makeVisible() {
        ed.setVisible(true);
    }

    public void makeVisible(String error) {
        this.error.setText(error);
        ed.setVisible(true);
    }

    public void makeNotVisible() {
        ed.setVisible(false);
        this.error.setText(basic_error);
    }

    public JFrame getThis() {
        return this;
    }

    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == close) {
            makeNotVisible();
        }
    }

    public static void main(String args[]) {
        new ErrorDialog();
    }
}