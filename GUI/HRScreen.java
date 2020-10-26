package GUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.Border;
import GUI.DialogBoxes.*;
import Classes.*;
import DB.*;
import GUI.Panels.*;

public class HRScreen extends JFrame implements ActionListener {
	static int IDNoBeforeChange;
	static boolean employeeIn;
	CardLayout card = new CardLayout();
	static JCheckBox box;
	static ConfirmDialog cd;
	static WarningDialog wd;
	static ErrorDialog ed;
	SearchDialog sd;
	UnlockDialog ud;
	DeleteDialog dd;
	BenefitPanel empBenefitsView;
	TaxInfoPanel taxInfoView;
	GrossPanel grossView;
	NetPanel netView;
	JPanel left, top, center, empInfoView;
	JButton empInfo, empBenefits, empTax, empGross, empNet, ADD, UPDATE, VIEW, DELETE, UNLOCK, CLEAR, logout;
	JLabel fn, ln, ss, addr, dob, homephone, mobphone, email, employedsince, idNo, hoursworked, pass, fulltime;
	JLabel current;
	static JLabel choice;
	static JTextField firstname, lastname, socialsec, address, DOB, homeNo, mobileNo, emailAddress, dateStarted,
			IDNumber, hoursWorkedLastPayPeriod, password;

	public HRScreen() {
		super("Payroll Program");
		setupFrame();
		setupPanels();
		setupButtons();
		setupLabels();
		setupTextFields();
		setupDialogs();
		addPanelsToFrame();
		addToTop();
		addToLeft();
		addToEmpInfo();
		addToCenter();
		addActionListeners();
		setSize(1250, 700);
		setVisible(true);
	}

	public JButton getLogout() {
		return this.logout;
	}

	public static ErrorDialog getED() {
		return ed;
	}

	public static ConfirmDialog getCD() {
		return cd;
	}

	public static JLabel getChoice() {
		return choice;
	}

	private void addActionListeners() {
		empInfo.addActionListener(this);
		empBenefits.addActionListener(this);
		empTax.addActionListener(this);
		empGross.addActionListener(this);
		empNet.addActionListener(this);
		ADD.addActionListener(this);
		UPDATE.addActionListener(this);
		VIEW.addActionListener(this);
		DELETE.addActionListener(this);
		CLEAR.addActionListener(this);
		UNLOCK.addActionListener(this);
	}

	private static Employee getEmpFromTextFields() throws NumberFormatException {
		try {
			return new Employee(firstname.getText(), lastname.getText(), socialsec.getText(), address.getText(),
					DOB.getText(), homeNo.getText(), mobileNo.getText(), emailAddress.getText(), dateStarted.getText(),
					Integer.parseInt(IDNumber.getText()), 0, Integer.parseInt(hoursWorkedLastPayPeriod.getText()),
					box.isSelected(), password.getText());
		} catch (NumberFormatException e) {
			throw e;
		}
	}

	private void addEmployee() {
		try {
			// make a temporary employee object
			Employee temp = getEmpFromTextFields();
			// call the DBConnection method to insert the employee into the database
			if (DBConnection.addEmployee(temp)) {// depending on whether the operation succeeds or not
				cd.makeVisible();// either the confirm dialog will show
			} else {
				ed.makeVisible("Encountered error while adding employee");// or this one will
			}
		} catch (NumberFormatException e) {
			ed.makeVisible("Error: Some fields can't be empty, others must be an integer");
		}
	}

	public static void retrieveEmployee(int id) {
		try {
			Employee temp = DBConnection.retrieveEmployeeInfo(id);
			firstname.setText(temp.getFirstName());
			lastname.setText(temp.getLastName());
			socialsec.setText(temp.getSSNumber());
			address.setText(temp.getAddress());
			DOB.setText(temp.getDateOfBirth());
			homeNo.setText(temp.getHomePhoneNumber());
			mobileNo.setText(temp.getMobilePhoneNumber());
			emailAddress.setText(temp.getEmailAddress());
			dateStarted.setText(temp.getEmployedSince());
			IDNumber.setText(String.valueOf(temp.getIDNumber()));
			IDNoBeforeChange = temp.getIDNumber();// this is used to prevent the user from causing bugs
			hoursWorkedLastPayPeriod.setText(String.valueOf(temp.getHoursWorkedLastPayPeriod()));
			password.setText(temp.getPassword());
			if (employeeIn)
				box.setEnabled(true);
			if (temp.isFullTime() && !box.isSelected())
				box.doClick();
			else if (!temp.isFullTime() && box.isSelected())
				box.doClick();
			if (employeeIn)
				box.setEnabled(false);
			cd.makeVisible();
		} catch (SQLException e) {
			ed.makeVisible("Error: Could not find employee with that ID");
		}
	}

	public static void updateEmployee() {
		try {
			DBConnection.updateEmployee(getEmpFromTextFields(), IDNoBeforeChange);
			cd.makeVisible();
		} catch (NumberFormatException e) {
			ed.makeVisible("Error: Some fields can't be empty, others must be an integer");
		} catch (SQLException s) {
			ed.makeVisible("Error occured while updating row in DB");
		} finally {

		}
	}

	public static void deleteEmployee(int id) {
		try {
			DBConnection.deleteEmployee(id);
			cd.makeVisible();
		} catch (SQLException e) {
			ed.makeVisible("No employee found with that ID");
		}
	}

	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();

		if (source == this.empInfo) {
			if (employeeIn)
				UPDATE.setEnabled(true);
			choice.setText(empInfo.getText());
			card.show(center, "Emp Info");
		} else if (source == this.empBenefits) {
			if (employeeIn)
				UPDATE.setEnabled(false);
			choice.setText(empBenefits.getText());
			card.show(center, "Emp Benefits");
		} else if (source == this.empTax) {
			if (employeeIn)
				UPDATE.setEnabled(false);
			choice.setText(empTax.getText());
			card.show(center, "Emp Tax");
		} else if (source == this.empGross) {
			if (employeeIn)
				UPDATE.setEnabled(false);
			choice.setText(empGross.getText());
			card.show(center, "Emp Gross");
		} else if (source == this.empNet) {
			if (employeeIn)
				UPDATE.setEnabled(false);
			choice.setText(empNet.getText());
			card.show(center, "Emp Net");
		} else if (source == this.ADD) {
			if (choice.getText() == "Employee Info") {
				addEmployee();
			}
		} else if (source == this.UPDATE) {
			if (choice.getText() == "Employee Info") {
				wd.makeVisible(Integer.toString(IDNoBeforeChange));
			} else if (choice.getText() == "Employee Benefits") {
				wd.makeVisible();
			} else if (choice.getText() == "Employee Gross Pay") {
				wd.makeVisible(2);
			}
		} else if (source == this.VIEW) {
			if (choice.getText() == "Employee Info" || choice.getText() == "Employee Benefits"
					|| choice.getText() == "Employee Gross Pay") {
				sd.makeVisible();
			}
		} else if (source == this.DELETE) {
			if (choice.getText() == "Employee Info") {
				dd.makeVisible();
			} else if (choice.getText() == "Employee Benefits") {
				wd.makeVisible(1);
			}
		} else if (source == this.CLEAR) {
			clearFields();
		} else if (source == this.UNLOCK) {
			ud.makeVisible();
		}
	}

	private void setupDialogs() {
		sd = new SearchDialog();
		ed = new ErrorDialog();
		cd = new ConfirmDialog();
		dd = new DeleteDialog();
		wd = new WarningDialog();
		ud = new UnlockDialog();
		sd.setVisible(false);
		cd.setVisible(false);
		ed.setVisible(false);
		dd.setVisible(false);
		wd.setVisible(false);
		ud.setVisible(false);
	}

	private void setupFrame() {
		// frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// check box will be set up here also
		box = new JCheckBox();
	}

	private void setupPanels() {
		// make a border object
		Border blackline = BorderFactory.createLineBorder(Color.BLACK, 2);
		// give left panel a grid layout
		left = new JPanel(new GridLayout(10, 1, 10, 5));
		// give top panel a flowlayout and a border
		top = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		top.setBorder(blackline);
		// give center panel a card layout
		center = new JPanel(card);
		// other panels have no specific layout manager, they will be added to center
		empInfoView = new JPanel(null);
		empBenefitsView = new BenefitPanel();
		taxInfoView = new TaxInfoPanel();
		grossView = new GrossPanel();
		netView = new NetPanel();
	}

	private void setupButtons() {
		// buttons
		empInfo = new JButton("Employee Info");
		empBenefits = new JButton("Employee Benefits");
		empTax = new JButton("Employee Tax Info");
		empGross = new JButton("Employee Gross Pay");
		empNet = new JButton("Employee Net Pay");
		ADD = new JButton("ADD");
		UPDATE = new JButton("UPDATE");
		VIEW = new JButton("VIEW");
		DELETE = new JButton("DELETE");
		CLEAR = new JButton("CLEAR");
		UNLOCK = new JButton("UNLOCK");
		logout = new JButton("LOGOUT");
	}

	private void setupLabels() {
		// labels
		fn = new JLabel("First Name: ");
		ln = new JLabel("Last Name: ");
		ss = new JLabel("Social Security #: ");
		addr = new JLabel("Address: ");
		dob = new JLabel("Date of Birth: ");
		homephone = new JLabel("Home Phone #: ");
		mobphone = new JLabel("Mobile Phone #: ");
		email = new JLabel("Email Address: ");
		employedsince = new JLabel("Date Hired: ");
		idNo = new JLabel("ID No.: ");
		pass = new JLabel("Password: ");
		hoursworked = new JLabel("Hours Worked Last Pay Period: ");
		fulltime = new JLabel("Full Time? (Y/N): ");
		current = new JLabel("Currently selected: ");
		choice = new JLabel();
		choice.setText(empInfo.getText());
	}

	private void setupTextFields() {
		// text fields
		firstname = new JTextField();
		lastname = new JTextField();
		socialsec = new JTextField();
		address = new JTextField();
		DOB = new JTextField();
		homeNo = new JTextField();
		mobileNo = new JTextField();
		emailAddress = new JTextField();
		dateStarted = new JTextField();
		IDNumber = new JTextField();
		hoursWorkedLastPayPeriod = new JTextField();
		password = new JTextField();
	}

	private void addPanelsToFrame() {
		// add panels to frame
		add(left, BorderLayout.WEST);
		add(top, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
	}

	private void addToTop() {
		// add logout button
		top.add(logout);
		// add labels for the user
		top.add(current);
		top.add(choice);
		// add buttons to top panel
		top.add(empInfo);
		top.add(empBenefits);
		top.add(empTax);
		top.add(empGross);
		top.add(empNet);
	}

	private void addToLeft() {
		// add buttons to left panel
		left.add(ADD);
		left.add(UPDATE);
		left.add(VIEW);
		left.add(DELETE);
		left.add(CLEAR);
		left.add(UNLOCK);
	}

	private void addToCenter() {
		// add content panels to center
		center.add(empInfoView, "Emp Info");
		center.add(empBenefitsView, "Emp Benefits");
		center.add(taxInfoView, "Emp Tax");
		center.add(grossView, "Emp Gross");
		center.add(netView, "Emp Net");
	}

	private void addToEmpInfo() {
		// add labels and text fields to panel
		empInfoView.add(fn);
		empInfoView.add(firstname);
		empInfoView.add(ln);
		empInfoView.add(lastname);
		empInfoView.add(ss);
		empInfoView.add(socialsec);
		empInfoView.add(addr);
		empInfoView.add(address);
		empInfoView.add(dob);
		empInfoView.add(DOB);
		empInfoView.add(homephone);
		empInfoView.add(homeNo);
		empInfoView.add(mobphone);
		empInfoView.add(mobileNo);
		empInfoView.add(email);
		empInfoView.add(emailAddress);
		empInfoView.add(employedsince);
		empInfoView.add(dateStarted);
		empInfoView.add(idNo);
		empInfoView.add(IDNumber);
		empInfoView.add(hoursworked);
		empInfoView.add(hoursWorkedLastPayPeriod);
		empInfoView.add(pass);
		empInfoView.add(password);
		empInfoView.add(fulltime);
		empInfoView.add(box);// JCheckBox
		// labels
		fn.setBounds(200, 50, 190, 22);
		ln.setBounds(200, 90, 190, 22);
		ss.setBounds(200, 130, 190, 22);
		addr.setBounds(200, 170, 190, 22);
		dob.setBounds(200, 210, 190, 22);
		homephone.setBounds(200, 250, 190, 22);
		mobphone.setBounds(200, 290, 190, 22);
		email.setBounds(200, 330, 190, 22);
		employedsince.setBounds(200, 370, 190, 22);
		idNo.setBounds(200, 410, 190, 22);
		hoursworked.setBounds(200, 450, 190, 22);
		pass.setBounds(200, 490, 190, 22);
		fulltime.setBounds(200, 530, 190, 22);
		// text fields
		firstname.setBounds(410, 50, 160, 22);
		lastname.setBounds(410, 90, 160, 22);
		socialsec.setBounds(410, 130, 160, 22);
		address.setBounds(410, 170, 160, 22);
		DOB.setBounds(410, 210, 160, 22);
		homeNo.setBounds(410, 250, 160, 22);
		mobileNo.setBounds(410, 290, 160, 22);
		emailAddress.setBounds(410, 330, 160, 22);
		dateStarted.setBounds(410, 370, 160, 22);
		IDNumber.setBounds(410, 410, 160, 22);
		hoursWorkedLastPayPeriod.setBounds(410, 450, 160, 22);
		password.setBounds(410, 490, 160, 22);
		// check box
		box.setBounds(410, 515, 50, 50);
	}

	public void clearFields() {
		firstname.setText(null);
		lastname.setText(null);
		socialsec.setText(null);
		address.setText(null);
		DOB.setText(null);
		homeNo.setText(null);
		mobileNo.setText(null);
		emailAddress.setText(null);
		dateStarted.setText(null);
		IDNumber.setText(null);
		hoursWorkedLastPayPeriod.setText(null);
		password.setText(null);
		if (box.isSelected()) {
			if (employeeIn)
				box.setEnabled(true);
			box.doClick();
			if (employeeIn)
				box.setEnabled(false);
		}
		empBenefitsView.resetFields();
		grossView.resetFields();
		netView.resetFields();
	}

	public void empLoggedIn() {
		employeeIn = true;
		firstname.setEditable(false);
		lastname.setEditable(false);
		socialsec.setEditable(false);
		DOB.setEditable(false);
		dateStarted.setEditable(false);
		IDNumber.setEditable(false);
		hoursWorkedLastPayPeriod.setEditable(false);
		box.setEnabled(false);
		GrossPanel.disableIncomeEditing();
		ADD.setEnabled(false);
		DELETE.setEnabled(false);
		UNLOCK.setVisible(false);
	}

	public void empLoggedOut() {
		if (employeeIn) {
			employeeIn = false;
			firstname.setEditable(true);
			lastname.setEditable(true);
			socialsec.setEditable(true);
			DOB.setEditable(true);
			dateStarted.setEditable(true);
			IDNumber.setEditable(true);
			hoursWorkedLastPayPeriod.setEditable(true);
			box.setEnabled(true);
			GrossPanel.enableIncomeEditing();
			ADD.setEnabled(true);
			DELETE.setEnabled(true);
			UNLOCK.setVisible(true);
		} else
			return;
	}

	public static void main(String[] args) {
		new HRScreen();
	}
}