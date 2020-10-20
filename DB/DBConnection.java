package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import Classes.*;

public class DBConnection {
	static Connection connection = null;
	static String url = "jdbc:mysql://localhost:3306/PayrollProgDB"; // ?useSSL=false"
	static String databaseName = "PayrollProgDB";
	static String user = "root";
	static String pass = "root";

	public void insertIntoEmployee() {
		// ---------------------------------Table of "employee"----------------------
		int IDNumber1 = 210, SSNumber1 = 222883398, hoursWorkedLastPayPeriod1 = 10;
		String firstName1 = "xxxx", lastName1 = "aaaa", Address1 = "2138 dhjsdf", homePhoneNumber1 = "34828992",
				MobilePhoneNumber1 = "23415123", emailAddress1 = "234@outlook.com", fullTime1 = "yes";
		String dateOfBirth1 = "1932/23/2";
		String emlopyeeSince1 = "23/23/1111", Field1 = "tastmananger";
		String query = " insert into employee (IDNumber, firstName, lastName, SSNumber, Address, dateOfBirth, homePhoneNumber, MobilePhoneNumber, emailAddress,employedSince, hoursWorkedLastPayPeriod, fullTime, Field1)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,? ,? ,?)";
		try {
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
		} catch (SQLException e) {
			System.out.println("SQL Exception!");
			e.printStackTrace();
		}
		// ----------------------------------end of
		// table--------------------------------
	}

	public void insertIntoHR() {
		// ----------------------------------table of HR-------------------------------
		int IDNumber2 = 531, numEmployee2 = 1;
		String password2 = "232323";
		// connecting to table of HR and it accept 3 value
		String query2 = " insert into hr (IDNumber, password, numEmployee)" + " values (? ,? ,?)";
		try {
			PreparedStatement ps2 = connection.prepareStatement(query2);
			ps2.setInt(1, IDNumber2); // <--------this is the input value of IDNumber in table HR
			ps2.setString(2, password2);// <-------this is the input value of Password in table HR
			ps2.setInt(3, numEmployee2);
			int status2 = ps2.executeUpdate();
			if (status2 != 0) {
				System.out.println("HR Table connected");
				System.out.println("HR record was inseted");
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception!");
			e.printStackTrace();
		}
		// --------------------------------end of
		// table-----------------------------------
	}

	public void insertIntoBenefit() {
		// --------------------------------Table of
		// Benefit---------------------------------
		int BenefitID3 = 623, amountGiven3 = 6;
		String Name3 = "dfs", AmountRespondsibleFor3 = "daa", includesFamily3 = "d1ff";
		String query3 = " insert into benefit (BenefitID, Name, AmountResponsibleFor, amountGiven, includesFamily)"
				+ " values (? ,? ,?, ?, ?)";
		try {
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
		} catch (SQLException e) {
			System.out.println("SQL Exception!");
			e.printStackTrace();
		}
		// --------------------------------end of
		// table---------------------------------------------
	}

	public void insertIntoBronze() {
		// --------------------------------Table of
		// Bronzepackage-----------------------------------
		int BenefitID4 = 20;
		String query4 = " insert into bronzepackage (BenefitsID)" + " values (?)";
		try {
			PreparedStatement ps4 = connection.prepareStatement(query4);
			ps4.setInt(1, BenefitID4);
			int status4 = ps4.executeUpdate();
			if (status4 != 0) {
				System.out.println("BP Table connected");
				System.out.println("BP record was inseted");
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception!");
			e.printStackTrace();
		}
		// ---------------------------------end of
		// table----------------------------------------------
	}

	public void insertIntoSilver() {
		// ---------------------------------table of
		// silverPackage------------------------------------
		int BenefitID5 = 20;
		String query5 = " insert into silverPackage (BenefitsID)" + " values (?)";
		try {
			PreparedStatement ps5 = connection.prepareStatement(query5);
			ps5.setInt(1, BenefitID5);
			int status5 = ps5.executeUpdate();
			if (status5 != 0) {
				System.out.println("SP Table connected");
				System.out.println("SP record was inseted");
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception!");
			e.printStackTrace();
		}
		// ---------------------------------end of
		// table------------------------------------------------
	}

	public void insertIntoGold() {
		// ---------------------------------table of
		// goldPackage---------------------------------------
		int BenefitID6 = 20;
		String query6 = " insert into goldPackage (BenefitsID)" + " values (?)";
		try {
			PreparedStatement ps6 = connection.prepareStatement(query6);
			ps6.setInt(1, BenefitID6);
			int status6 = ps6.executeUpdate();
			if (status6 != 0) {
				System.out.println("GP Table connected");
				System.out.println("GP record was inseted");
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception!");
			e.printStackTrace();
		}
		// ---------------------------------end of
		// table-------------------------------------
	}

	public void connectToDB() throws SQLException {
		try {
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected to " + databaseName);
		} catch (SQLException e) {
			System.out.println("Database not found!");
			e.printStackTrace();
		}
	}

	public void addEmployee(Employee emp) {
		try {
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected to " + databaseName);
			String query = "INSERT INTO employee (IDNumber, firstname, lastname, SSNumber, Address, dateOfBirth, homePhoneNumber, MobilePhoneNumber, emailAddress, employedSince, hoursWorkedLastPayPeriod, fullTime)"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, emp.getIDNumber());
			statement.setString(2, emp.getFirstName());
			statement.setString(3, emp.getLastName());
			statement.setString(4, emp.getSSNumber());
			statement.setString(5, emp.getAddress());
			statement.setString(6, emp.getDateOfBirth());
			statement.setString(7, emp.getHomePhoneNumber());
			statement.setString(8, emp.getMobilePhoneNumber());
			statement.setString(9, emp.getEmailAddress());
			statement.setString(10, emp.getEmployedSince());
			statement.setInt(11, emp.getHoursWorkedLastPayPeriod());
			statement.setBoolean(12, emp.isFullTime());
			if (statement.executeUpdate() > 0) {
				System.out.println("A row was inserted into the employee table.");
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Database not found!");
			e.printStackTrace();
		}
	}

	public Employee retrieveEmployeeInfo(int IDNo) {
		Employee temp = new Employee();
		try {
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected to " + databaseName);
			String query = "SELECT * FROM employee WHERE IDNumber=" + Integer.toString(IDNo);
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery(query);

			temp.setIDNumber(res.getInt(1));
			temp.setFirstName(res.getString(2));
			temp.setLastName(res.getString(3));
			temp.setSSNumber(res.getString(4));
			temp.setAddress(res.getString(5));
			temp.setDateOfBirth(res.getString(6));
			temp.setHomePhoneNumber(res.getString(7));
			temp.setMobilePhoneNumber(res.getString(8));
			temp.setEmailAddress(res.getString(9));
			temp.setEmployedSince(res.getString(10));
			temp.setHoursWorkedLastPayPeriod(res.getInt(11));
			temp.setFullTime(res.getBoolean(12));

			connection.close();
		} catch (SQLException e) {
			System.out.println("Database not found!");
			e.printStackTrace();
		}
		return temp;
	}

	private void updateAttribute(String attr, String value, int IDNo) {
		try {
			connection = DriverManager.getConnection(url, user, pass);
			String sql = "UPDATE employee set " + attr + "=? WHERE IDNumber=?";
			PreparedStatement pstate = connection.prepareStatement(sql);
			pstate.setString(1, value);
			pstate.setInt(2, IDNo);
			pstate.executeUpdate();
			pstate.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Database not found!");
			e.printStackTrace();
		}
	}

	private void updateAttribute(String attr, int value, int IDNo) {
		try {
			connection = DriverManager.getConnection(url, user, pass);
			String sql = "UPDATE employee set " + attr + "=? WHERE IDNumber=?";
			PreparedStatement pstate = connection.prepareStatement(sql);
			pstate.setInt(1, value);
			pstate.setInt(2, IDNo);
			pstate.executeUpdate();
			pstate.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Database not found!");
			e.printStackTrace();
		}
	}

	private void updateAttribute(String attr, Boolean value, int IDNo) {
		try {
			connection = DriverManager.getConnection(url, user, pass);
			String sql = "UPDATE employee set " + attr + "=? WHERE IDNumber=?";
			PreparedStatement pstate = connection.prepareStatement(sql);
			pstate.setBoolean(1, value);
			pstate.setInt(2, IDNo);
			pstate.executeUpdate();
			pstate.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Database not found!");
			e.printStackTrace();
		}
	}

	public void updateEmployee(Employee emp) {
		try {
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected to " + databaseName);
			// retrieve the right info from DB
			String query = "SELECT * FROM employee WHERE IDNumber=" + Integer.toString(emp.getIDNumber());
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery(query);
			// check each attribute to see if its different, if it is update it with a SQL
			// command
			if (!(emp.getFirstName() == res.getString(2))) {
				updateAttribute("firstname", emp.getFirstName(), res.getInt(1));
			} else if (!(emp.getLastName() == res.getString(3))) {
				updateAttribute("lastname", emp.getLastName(), res.getInt(1));
			} else if (!(emp.getSSNumber() == res.getString(4))) {
				updateAttribute("SSNumber", emp.getSSNumber(), res.getInt(1));
			} else if (!(emp.getAddress() == res.getString(5))) {
				updateAttribute("Address", emp.getAddress(), res.getInt(1));
			} else if (!(emp.getDateOfBirth() == res.getString(6))) {
				updateAttribute("dateOfBirth", emp.getDateOfBirth(), res.getInt(1));
			} else if (!(emp.getHomePhoneNumber() == res.getString(7))) {
				updateAttribute("homePhoneNumber", emp.getHomePhoneNumber(), res.getInt(1));
			} else if (!(emp.getMobilePhoneNumber() == res.getString(8))) {
				updateAttribute("MobilePhoneNumber", emp.getMobilePhoneNumber(), res.getInt(1));
			} else if (!(emp.getEmailAddress() == res.getString(9))) {
				updateAttribute("emailAddress", emp.getEmailAddress(), res.getInt(1));
			} else if (!(emp.getEmployedSince() == res.getString(10))) {
				updateAttribute("employedSince", emp.getEmployedSince(), res.getInt(1));
			} else if (!(emp.getHoursWorkedLastPayPeriod() == res.getInt(11))) {
				updateAttribute("hoursWorkedLastPayPeriod", emp.getHoursWorkedLastPayPeriod(), res.getInt(1));
			} else if (!(emp.isFullTime() == res.getBoolean(12))) {
				updateAttribute("fullTime", emp.isFullTime(), res.getInt(1));
			} else if (!(emp.getIDNumber() == res.getInt(1))) {
				updateAttribute("IDNumber", emp.getIDNumber(), res.getInt(1));
			}
			connection.close();
		} catch (

		SQLException e) {
			System.out.println("Database not found!");
			e.printStackTrace();
		}
	}

	public void deleteEmployee(int IDNo) {
		try {
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected to " + databaseName);
			String query = "DELETE FROM employee WHERE IDNumber=" + Integer.toString(IDNo);
			PreparedStatement statement = connection.prepareStatement(query);
			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Database not found!");
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		try {
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected to " + databaseName);
		} catch (SQLException e) {
			System.out.println("Database not found!");
			e.printStackTrace();
		}
	}
}