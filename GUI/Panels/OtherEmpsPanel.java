package GUI.Panels;

import Classes.Employee;

import java.sql.SQLException;

import javax.swing.*;
import DB.DBConnection;
import GUI.HRScreen;

public class OtherEmpsPanel extends JPanel {
  JLabel firstname, lastname, mobilePhone, emailAddress, IDNumber;
  static JTextField fn, ln, mob, email, idNo;

  public OtherEmpsPanel() {
    setLayout(null);
    setupLabels();
    setupTextFields();
    setBoundsForAll();
    addToThis();
  }

  private void setupLabels() {
    firstname = new JLabel("First Name: ");
    lastname = new JLabel("Last Name: ");
    mobilePhone = new JLabel("Cell Phone #: ");
    emailAddress = new JLabel("Email: ");
    IDNumber = new JLabel("ID Number: ");
  }

  private void setupTextFields() {
    fn = new JTextField();
    ln = new JTextField();
    mob = new JTextField();
    email = new JTextField();
    idNo = new JTextField();
    fn.setEditable(false);
    ln.setEditable(false);
    mob.setEditable(false);
    email.setEditable(false);
    idNo.setEditable(false);
  }

  private void setBoundsForAll() {
    // labels
    firstname.setBounds(200, 50, 190, 22);
    lastname.setBounds(200, 90, 190, 22);
    IDNumber.setBounds(200, 130, 190, 22);
    mobilePhone.setBounds(200, 170, 190, 22);
    emailAddress.setBounds(200, 210, 190, 22);
    // text fields
    fn.setBounds(410, 50, 160, 22);
    ln.setBounds(410, 90, 160, 22);
    idNo.setBounds(410, 130, 160, 22);
    mob.setBounds(410, 170, 160, 22);
    email.setBounds(410, 210, 160, 22);
  }

  private void addToThis() {
    add(firstname);
    add(lastname);
    add(emailAddress);
    add(mobilePhone);
    add(IDNumber);
    add(fn);
    add(ln);
    add(email);
    add(mob);
    add(idNo);
  }

  public static void retrieveOtherEmployee(int id) {
    try {
      Employee temp = DBConnection.retrieveEmployeeInfo(id);
      fn.setText(temp.getFirstName());
      ln.setText(temp.getLastName());
      idNo.setText(Integer.toString(temp.getIDNumber()));
      mob.setText(temp.getMobilePhoneNumber());
      email.setText(temp.getEmailAddress());
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Error retrieving other employee");
      HRScreen.getED().makeVisible("Error retrieving employee info");
    }
  }
}