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

	public void addEmployee(Employee emp) {
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
			temp.setPassword(res.getString(16));

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
			} else if (!(emp.getPassword() == res.getString(16))) {
				updateAttribute("Password", emp.getPassword(), res.getInt(1));
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