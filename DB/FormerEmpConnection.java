package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import Classes.*;
import DB.DBConnection;

public class FormerEmpConnection {
	static Connection connection = null;
	static String url = "jdbc:mysql://localhost:3306/PayrollProgDB"; // ?useSSL=false"
	static String databaseName = "PayrollProgDB";
	static String user = "root";
	static String pass = "root";
	static DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

	public static FormerEmployee getFormerEmployee(int idNo) throws SQLException {
		FormerEmployee temp = new FormerEmployee();
		try {
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected to " + databaseName);
			String query = "SELECT * FROM formeremployee WHERE IDNumber=" + Integer.toString(idNo);
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery(query);
			res.next();
			temp.setIDNumber(res.getInt(1));
			temp.setFirstName(res.getString(2));
			temp.setLastName(res.getString(3));
			temp.setEmployedSince(res.getString(4));
			temp.setDateLeft(res.getString(5));
			temp.setAddress(res.getString(6));
			temp.setEmailAddress(res.getString(7));
			temp.setMobilePhoneNumber(res.getString(8));
			temp.setReasonForLeaving(res.getString(9));
			connection.close();
			return temp;
		} catch (SQLException e) {
			System.out.println("Error retrieving former employee");
			e.printStackTrace();
			throw e;
		}
	}

	public static void addFormerEmployee(int idNo, String reasonForLeaving) throws SQLException {
		try {
			String date = df.format(new Date());
			Employee temp = DBConnection.retrieveEmployeeInfo(idNo);
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected to " + databaseName);
			String query = "INSERT INTO formeremployee (IDNumber, firstname, lastname, datehired, dateleft, Address, emailAddress, MobilePhoneNumber, reasonforleaving)"
					+ "VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, temp.getIDNumber());
			statement.setString(2, temp.getFirstName());
			statement.setString(3, temp.getLastName());
			statement.setString(4, temp.getEmployedSince());
			statement.setString(5, date);
			statement.setString(6, temp.getAddress());
			statement.setString(7, temp.getEmailAddress());
			statement.setString(8, temp.getMobilePhoneNumber());
			statement.setString(9, reasonForLeaving);
			if (statement.executeUpdate() > 0) {
				System.out.println("A row was inserted into former employee table.");
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error adding former employee");
			e.printStackTrace();
			throw e;
		}
	}
public static void updateFormerEmployee(FormerEmployee fe, int id) throws SQLException{
  try{
    connection = DriverManager.getConnection(url, user, pass);
    System.out.println("Connected to " + databaseName);
			// retrieve the right info from DB
			String query = "SELECT * FROM formeremployee WHERE IDNumber=" + Integer.toString(id);
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery(query);
			res.next();
			//check each attribute to see if its different and update it with a SQL command if it is
			if (!(fe.getFirstName() == res.getString(2))) {
				updateAttribute("firstname", fe.getFirstName(), res.getInt(1));
			}
			if (!(fe.getLastName() == res.getString(3))) {
				updateAttribute("lastname", fe.getLastName(), res.getInt(1));
			}
			if  (!(fe.getEmployedSince()==res.getString(4))) {
			  updateAttribute("datehired",fe.getEmployedSince(),res.getInt(1));
			}
			if  (!(fe.getDateLeft()==res.getString(5))){
			  updateAttribute("dateleft", fe.getDateLeft(), res.getInt(1));
			}
			if  (!(fe.getAddress()==res.getString(6))){
			  updateAttribute("address", fe.getAddress(), res.getInt(1));
			}
			if (!(fe.getEmailAddress()==res.getString(7))){
			  updateAttribute("emailAddress", fe.getEmailAddress(), res.getInt(1));
			}
			if  (!(fe.getMobilePhoneNumber()==res.getString(8))){
			  updateAttribute("MobilePhoneNumber", fe.getMobilePhoneNumber(), res.getInt(1));
			}
			if (!(fe.getReasonForLeaving==res.getString(9))){
			  updateAttribute("reasonforleaving", fe.getReasonForLeaving(), res.getInt(1));
			}
  }
}
private void updateAttribute(String attr, String updated, int id){
  try {
			connection = DriverManager.getConnection(url, user, pass);
			String sql = "UPDATE formeremployee set " + attr + "=? WHERE IDNumber=?";
			PreparedStatement pstate = connection.prepareStatement(sql);
			pstate.setString(1, updated);
			pstate.setInt(2, id);
			pstate.executeUpdate();
			pstate.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error updating attribute");
			e.printStackTrace();
		}
  }
}