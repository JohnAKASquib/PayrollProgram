package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class HRScreen {
	JFrame f;
	JPanel left, top, empInfoView;
	JButton empInfo, empBenefits, empTax, empGross, empNet, ADD, UPDATE, DELETE;
	JLabel fn, ln, ss, addr, dob, homephone, mobphone, email, employedsince, idNo, hoursworked, fulltime;
	JTextField firstname, lastname, socialsec, address, DOB, homeNo, mobileNo, emailAddress, dateStarted, IDNumber,
			hoursWorkedLastPayPeriod;

	HRScreen() {
		setupFrame();
		setupPanels();
		setupButtons();
		setupLabels();
		setupTextFields();
		addPanelsToFrame();
		addToTop();
		addToLeft();
		addToEmpInfo();
		f.setSize(1250, 700);
		f.setVisible(true);
	}

	public void setupFrame() {
		// frame
		f = new JFrame("Payroll Program");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setupPanels() {
		// panels
		Border blackline = BorderFactory.createLineBorder(Color.BLACK, 2);
		left = new JPanel(new GridLayout(10, 1, 10, 5));
		left.setBorder(blackline);
		top = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		top.setBorder(blackline);
		empInfoView = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		// empInfoView.setBorder(blackline);
	}

	public void setupButtons() {
		// buttons
		empInfo = new JButton("Employee Info");
		empBenefits = new JButton("Employee Benefits");
		empTax = new JButton("Employee Tax Info");
		empGross = new JButton("Employee Gross Pay");
		empNet = new JButton("Employee Net Pay");
		ADD = new JButton("ADD");
		UPDATE = new JButton("UPDATE");
		DELETE = new JButton("DELETE");
	}

	public void setupLabels() {
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
		hoursworked = new JLabel("ours Worked Last Pay Period: ");
		fulltime = new JLabel("Full Time? (Y/N): ");
	}

	public void setupTextFields() {
		// text fields
		firstname = new JTextField();
		firstname.setSize(200, 10);
		lastname = new JTextField();
		lastname.setSize(200, 10);
		socialsec = new JTextField();
		address = new JTextField();
		DOB = new JTextField();
		homeNo = new JTextField();
		mobileNo = new JTextField();
		emailAddress = new JTextField();
		dateStarted = new JTextField();
		IDNumber = new JTextField();
		hoursWorkedLastPayPeriod = new JTextField();
	}

	public void addPanelsToFrame() {
		// add panels to frame
		f.add(left, BorderLayout.WEST);
		f.add(top, BorderLayout.NORTH);
		f.add(empInfoView, BorderLayout.CENTER);
	}

	public void addToTop() {
		// add buttons to top panel
		top.add(empInfo);
		top.add(empBenefits);
		top.add(empTax);
		top.add(empGross);
		top.add(empNet);
	}

	public void addToLeft() {
		// add buttons to left panel
		left.add(ADD);
		left.add(UPDATE);
		left.add(DELETE);
	}

	public void addToEmpInfo() {
		// add labels and text fields to name
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
	}

	public static void main(String[] args) {
		new HRScreen();
	}
}