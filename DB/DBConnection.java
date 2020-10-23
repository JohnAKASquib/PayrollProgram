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

	public static Boolean getHRPassword(int IDNo, String enteredPass) {
		try {
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected to " + databaseName);
			String query = "SELECT Password FROM hr WHERE IDNumber=" + Integer.toString(IDNo);
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery(query);
			while (res.next()) {
				if (res.getString("Password").equals(enteredPass)) {
					connection.close();
					return true;
				} else {
					connection.close();
					return false;
				}
			}
		} catch (SQLException e) {
			System.out.println("Database not found!");
			e.printStackTrace();
		}
		return false;
	}

	public static Boolean addEmployee(Employee emp) {
		try {
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected to " + databaseName);
			String query = "INSERT INTO employee (IDNumber, firstname, lastname, SSNumber, Address, dateOfBirth, homePhoneNumber, MobilePhoneNumber, emailAddress, employedSince, hoursWorkedLastPayPeriod, fullTime, Password)"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			statement.setString(13, emp.getPassword());
			if (statement.executeUpdate() > 0) {
				System.out.println("A row was inserted into the employee table.");
			}
			statement.close();
			connection.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Database related error!");
			e.printStackTrace();
			return false;
		}
	}

	public static Employee retrieveEmployeeInfo(int IDNo) throws SQLException {
		Employee temp = new Employee();
		try {
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected to " + databaseName);
			String query = "SELECT * FROM employee WHERE IDNumber=" + Integer.toString(IDNo);
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery(query);
			res.next();
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
			temp.setPassword(res.getString(16));

			connection.close();
		} catch (SQLException e) {
			System.out.println("IDNumber not found!");
			e.printStackTrace();
			throw e;
		}
		return temp;
	}

	private static void updateAttribute(String attr, String value, int IDNo) {
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

	private static void updateAttribute(String attr, int value, int IDNo) {
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

	private static void updateAttribute(String attr, Boolean value, int IDNo) {
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

	public static void updateEmployee(Employee emp, int prevID) throws SQLException {
		try {
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected to " + databaseName);
			// retrieve the right info from DB
			String query = "SELECT * FROM employee WHERE IDNumber=" + Integer.toString(prevID);
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery(query);
			res.next();
			// check each attribute to see if its different, if it is update it with a SQL
			// command
			if (!(emp.getFirstName() == res.getString(2))) {
				updateAttribute("firstname", emp.getFirstName(), res.getInt(1));
			}
			if (!(emp.getLastName() == res.getString(3))) {
				updateAttribute("lastname", emp.getLastName(), res.getInt(1));
			}
			if (!(emp.getSSNumber() == res.getString(4))) {
				updateAttribute("SSNumber", emp.getSSNumber(), res.getInt(1));
			}
			if (!(emp.getAddress() == res.getString(5))) {
				updateAttribute("Address", emp.getAddress(), res.getInt(1));
			}
			if (!(emp.getDateOfBirth() == res.getString(6))) {
				updateAttribute("dateOfBirth", emp.getDateOfBirth(), res.getInt(1));
			}
			if (!(emp.getHomePhoneNumber() == res.getString(7))) {
				updateAttribute("homePhoneNumber", emp.getHomePhoneNumber(), res.getInt(1));
			}
			if (!(emp.getMobilePhoneNumber() == res.getString(8))) {
				updateAttribute("MobilePhoneNumber", emp.getMobilePhoneNumber(), res.getInt(1));
			}
			if (!(emp.getEmailAddress() == res.getString(9))) {
				updateAttribute("emailAddress", emp.getEmailAddress(), res.getInt(1));
			}
			if (!(emp.getEmployedSince() == res.getString(10))) {
				updateAttribute("employedSince", emp.getEmployedSince(), res.getInt(1));
			}
			if (!(emp.getHoursWorkedLastPayPeriod() == res.getInt(11))) {
				updateAttribute("hoursWorkedLastPayPeriod", emp.getHoursWorkedLastPayPeriod(), res.getInt(1));
			}
			if (!(emp.isFullTime() == res.getBoolean(12))) {
				updateAttribute("fullTime", emp.isFullTime(), res.getInt(1));
			}
			if (!(emp.getPassword() == res.getString(16))) {
				updateAttribute("Password", emp.getPassword(), res.getInt(1));
			}
			if (!(emp.getIDNumber() == prevID)) {
				updateAttribute("IDNumber", emp.getIDNumber(), prevID);
			}
			connection.close();
		} catch (

		SQLException e) {
			System.out.println("Error occured while updating");
			e.printStackTrace();
			throw e;
		}
	}

	public static void deleteEmployee(int IDNo) throws SQLException {
		try {
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected to " + databaseName);
			String query = "DELETE FROM employee WHERE IDNumber=" + Integer.toString(IDNo);
			PreparedStatement statement = connection.prepareStatement(query);
			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("ID Number not found!");
			e.printStackTrace();
			throw e;
		}
	}

	public static String[] retrieveEmployeeBenPackage(int id) throws SQLException {
		try {
			String data[] = { "", "", "" };
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected to " + databaseName);
			String query = "SELECT FirstName, Lastname, BenefitPackage FROM employee WHERE IDNumber="
					+ Integer.toString(id);
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery(query);
			res.next();
			data[0] = res.getString(1);
			data[1] = res.getString(2);
			data[2] = res.getString(3);
			return data;
		} catch (SQLException e) {
			System.out.println("Error retrieving BenefitPackage");
			e.printStackTrace();
			throw e;
		} finally {
			connection.close();
		}
	}

	public static void removeBenPackage(int id) throws SQLException {
		try {
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected to " + databaseName);
			String sql = "UPDATE employee set BenefitPackage=? WHERE IDNumber=?";
			PreparedStatement pstate = connection.prepareStatement(sql);
			pstate.setString(1, "NULL");
			pstate.setString(2, Integer.toString(id));
			pstate.executeUpdate();
			pstate.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error removing BenefitPackage");
			throw e;
		}
	}

	public static void updateBenPackage(int id, String p) throws SQLException {
		try {
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected to " + databaseName);
			String sql = "UPDATE employee set BenefitPackage=? WHERE IDNumber=?";
			PreparedStatement pstate = connection.prepareStatement(sql);
			pstate.setString(1, p);
			pstate.setInt(2, id);
			pstate.executeUpdate();
			pstate.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error updating BenefitPackage");
			throw e;
		}
	}

	public static String[] getPay(int id, String inc) throws SQLException {
		try {
			String s[] = { "", "", "" };
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected to " + databaseName);
			String sql = "SELECT " + inc + ", firstname, lastname FROM employee WHERE IDNumber=" + Integer.toString(id);
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery(sql);
			res.next();
			s[0] = Integer.toString(res.getInt(1));
			s[1] = res.getString(2);
			s[2] = res.getString(3);
			return s;
		} catch (SQLException e) {
			System.out.println("Error retrieving Pay from DB");
			e.printStackTrace();
			throw e;
		}
	}

	public static void updatePay(int id, int gross) throws SQLException {
		try {
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected to " + databaseName);
			String sql = "UPDATE employee set grossIncome=? WHERE IDNumber=?";
			PreparedStatement pstate = connection.prepareStatement(sql);
			pstate.setInt(1, gross);
			pstate.setInt(2, id);
			pstate.executeUpdate();
			pstate.close();
			updateNetPay(id);
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error Updating Pay");
			e.printStackTrace();
			throw e;
		}
	}

	private static void updateNetPay(int id) throws SQLException {
		int benCost, gross;
		double net;
		String arr[];
		try {
			String bPackage = getBenefitPackage(id);
			switch (bPackage) {
				case "Bronze":
					benCost = 7000;// 17000;
					break;
				case "Silver":
					benCost = 11000;// 35700;
					break;
				case "Gold":
					benCost = 20000;// 67700;
					break;
				case "NULL":
					benCost = 0;
					break;
				default:
					benCost = 0;
			}
			arr = getPay(id, "grossIncome");
			gross = Integer.parseInt(arr[0]);
			net = gross - benCost;
			net = net - (net * .3);
			if (net < 0)
				net = 0;
			connection = DriverManager.getConnection(url, user, pass);
			String query = "UPDATE employee set netIncome=? WHERE IDNumber=?";
			PreparedStatement pstate = connection.prepareStatement(query);
			pstate.setInt(1, (int) net);
			pstate.setInt(2, id);
			pstate.executeUpdate();
			pstate.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error updating Net Income");
			e.printStackTrace();
			throw e;
		}
	}

	private static String getBenefitPackage(int id) throws SQLException {
		try {
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected to " + databaseName);
			String query = "SELECT BenefitPackage FROM employee WHERE IDNumber=" + Integer.toString(id);
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery(query);
			res.next();
			return res.getString(1);
		} catch (SQLException e) {
			System.out.println("Error retrieving BenefitPackage");
			e.printStackTrace();
			throw e;
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