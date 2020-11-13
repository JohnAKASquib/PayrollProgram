package GUI.Panels;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.*;
import DB.DBConnection;
import GUI.HRScreen;

public class OtherEmpsPanel extends JPanel {
  JLabel firstname, lastname, mobilePhone, emailAddress, IDNumber;
  JTextField fn, ln, mob, email, idNo;
  
  public OtherEmpsPanel(){
   setupLabels();
   setupTextFields();
   setBoundsForAll();
   addToThis();
  }
  
  private void setupLabels(){
    firstname=new JLabel("First Name: ");
    lastname=new JLabel("Last Name: ");
    mobilePhone=new JLabel("Cell Phone #: ");
    emailAddress=new JLabel("Email: ");
    IDNumber=new JLabel("ID Number: ");
  }
  private void setupTextFields(){
    fn=new JTextField();
    ln=new JTextField();
    mob=new JTextField();
    email=new JTextField();
    idNo=new JTextField();
  }
  
  private void setBoundsForAll(){
    //labels
    
  }
  
  private void addToThis(){
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
}