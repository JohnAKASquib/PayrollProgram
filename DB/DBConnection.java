package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
	static Connection connection = null;
	static String databaseName = "PayrollProgDB";
	static String user = "root";
	static String pass = "root";

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb?useSSL=false", user, pass);

		// ---------------------------------Table of "employee"----------------------
		int IDNumber1 = 210, SSNumber1 = 222883398, hoursWorkedLastPayPeriod1 = 10;
		String firstName1 = "xxxx", lastName1 = "aaaa", Address1 = "2138 dhjsdf", homePhoneNumber1 = "34828992",
				MobilePhoneNumber1 = "23415123", emailAddress1 = "234@outlook.com", fullTime1 = "yes";
		String dateOfBirth1 = "1932/23/2";
		String emlopyeeSince1 = "23/23/1111", Field1 = "tastmananger";
		String query = " insert into employee (IDNumber, firstName, lastName, SSNumber, Address, dateOfBirth, homePhoneNumber, MobilePhoneNumber, emailAddress,employedSince, hoursWorkedLastPayPeriod, fullTime, Field1)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,? ,? ,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, IDNumber1);
		ps.setString(2, firstName1);
		ps.setString(3, lastName1);
		ps.setInt(4, SSNumber1);
		ps.setString(5, Address1);
		ps.setString(6, dateOfBirth1);
		ps.setString(7, homePhoneNumber1);
		ps.setString(8, MobilePhoneNumber1);
		ps.setString(9, emailAddress1);
		ps.setString(10, emlopyeeSince1);
		ps.setInt(11, hoursWorkedLastPayPeriod1);
		ps.setString(12, fullTime1);
		ps.setString(13, Field1);
		int status = ps.executeUpdate();
		if (status != 0) {
			System.out.println("Employee Table connected");
			System.out.println("Employee record was inseted");
		}
		// ----------------------------------end of
		// table--------------------------------
		// ----------------------------------table of HR-------------------------------
		int IDNumber2 = 531, numEmployee2 = 1;
		String password2 = "232323";
		// connecting to table of HR and it accept 3 value
		String query2 = " insert into hr (IDNumber, password, numEmployee)" + " values (? ,? ,?)";
		PreparedStatement ps2 = connection.prepareStatement(query2);
		ps2.setInt(1, IDNumber2); // <--------this is the input value of IDNumber in table HR
		ps2.setString(2, password2);// <-------this is the input value of Password in table HR
		ps2.setInt(3, numEmployee2);
		int status2 = ps2.executeUpdate();
		if (status2 != 0) {
			System.out.println("HR Table connected");
			System.out.println("HR record was inseted");
		}
		// --------------------------------end of
		// table-----------------------------------
		// --------------------------------Table of
		// Benefit---------------------------------
		int BenefitID3 = 623, amountGiven3 = 6;
		String Name3 = "dfs", AmountRespondsibleFor3 = "daa", includesFamily3 = "d1ff";
		String query3 = " insert into benefit (BenefitID, Name, AmountResponsibleFor, amountGiven, includesFamily)"
				+ " values (? ,? ,?, ?, ?)";
		PreparedStatement ps3 = connection.prepareStatement(query3);
		ps3.setInt(1, BenefitID3);
		ps3.setString(2, Name3);
		ps3.setString(3, AmountRespondsibleFor3);
		ps3.setInt(4, amountGiven3);
		ps3.setString(5, includesFamily3);
		int status3 = ps3.executeUpdate();
		if (status3 != 0) {
			System.out.println("Benefit Table connected");
			System.out.println("Benefit record was inseted");
		}
		// --------------------------------end of
		// table---------------------------------------------
		// --------------------------------Table of
		// Bronzepackage-----------------------------------
		int BenefitID4 = 20;
		String query4 = " insert into bronzepackage (BenefitsID)" + " values (?)";
		PreparedStatement ps4 = connection.prepareStatement(query4);
		ps4.setInt(1, BenefitID4);
		int status4 = ps4.executeUpdate();
		if (status4 != 0) {
			System.out.println("BP Table connected");
			System.out.println("BP record was inseted");
		}
		// ---------------------------------end of
		// table----------------------------------------------
		// ---------------------------------table of
		// silverPackage------------------------------------
		int BenefitID5 = 20;
		String query5 = " insert into silverPackage (BenefitsID)" + " values (?)";
		PreparedStatement ps5 = connection.prepareStatement(query5);
		ps5.setInt(1, BenefitID5);
		int status5 = ps5.executeUpdate();
		if (status5 != 0) {
			System.out.println("SP Table connected");
			System.out.println("SP record was inseted");
		}
		// ---------------------------------end of
		// table------------------------------------------------
		// ---------------------------------table of
		// goldPackage---------------------------------------
		int BenefitID6 = 20;
		String query6 = " insert into goldPackage (BenefitsID)" + " values (?)";
		PreparedStatement ps6 = connection.prepareStatement(query6);
		ps6.setInt(1, BenefitID6);
		int status6 = ps6.executeUpdate();
		if (status6 != 0) {
			System.out.println("GP Table connected");
			System.out.println("GP record was inseted");
		}
		// ---------------------------------end of
		// table-------------------------------------
	}
}