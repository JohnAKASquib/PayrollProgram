package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import Classes.*;

public class FormerEmpConnection {
  static Connection connection = null;
	static String url = "jdbc:mysql://localhost:3306/PayrollProgDB"; // ?useSSL=false"
	static String databaseName = "PayrollProgDB";
	static String user = "root";
	static String pass = "root";
	
	public static FormerEmployee getFormerEmployee(int idNo) throws SQLException{
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
	} catch (SQLException e){
	  System.out.println("Error retrieving former employee");
	  e.printStackTrace();
	  throw e;
	}
	
	public static void addFormerEmployee (FormerEmployee fe, String reasonForLeaving) throws SQLException{
	  try {
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected to " + databaseName);
			String query = "INSERT INTO formeremployee (IDNumber, firstname, lastname, datehired, dateleft, Address, emailAddress, MobilePhoneNumber, reasonforleaving)"
					+ "VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query)
	}
}