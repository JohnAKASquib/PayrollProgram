package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class HRScreen extends JFrame implements ActionListener {
	CardLayout card = new CardLayout();
	// JFrame f;
	JPanel left, top, center, empInfoView, empBenefitsView;
	JButton empInfo, empBenefits, empTax, empGross, empNet, ADD, UPDATE, DELETE;
	JLabel fn, ln, ss, addr, dob, homephone, mobphone, email, employedsince, idNo, hoursworked, fulltime;
	JLabel benefits;
	JTextField firstname, lastname, socialsec, address, DOB, homeNo, mobileNo, emailAddress, dateStarted, IDNumber,
			hoursWorkedLastPayPeriod;

	HRScreen() {
		super("Payroll Program");
		setupFrame();
		setupPanels();
		setupButtons();
		setupLabels();
		setupTextFields();
		addPanelsToFrame();
		addToTop();
		addToLeft();
		addToEmpInfo();
		addToEmpBenefits();
		addToCenter();
		addActionListeners();
		setSize(1250, 700);
		setVisible(true);
	}

	public void addActionListeners() {
		empInfo.addActionListener(this);
		empBenefits.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		// as we add more panels to center, this function will need to be updated to
		// switch between them
		if (source == this.empInfo) {
			card.show(center, "Emp Info");
		} else if (source == this.empBenefits) {
			card.show(center, "Emp Benefits");
		}
	}

	public void setupFrame() {
		// frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setupPanels() {
		// make a border object
		Border blackline = BorderFactory.createLineBorder(Color.BLACK, 2);
		// give left panel a grid layout and a border
		left = new JPanel(new GridLayout(10, 1, 10, 5));
		left.setBorder(blackline);
		// give top panel a flowlayout and a border
		top = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		top.setBorder(blackline);
		// give center panel a card layout
		center = new JPanel(card);
		// other panels have no specific layout manager, they will be added to center
		empInfoView = new JPanel(null);
		empBenefitsView = new JPanel(null);
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
		hoursworked = new JLabel("Hours Worked Last Pay Period: ");
		fulltime = new JLabel("Full Time? (Y/N): ");
		benefits = new JLabel("Benefits?");
	}

	public void setupTextFields() {
		// text fields
		firstname = new JTextField();
		// firstname.setSize(200, 10);
		lastname = new JTextField();
		// lastname.setSize(200, 10);
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
		add(left, BorderLayout.WEST);
		add(top, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
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

	public void addToCenter() {
		// add content panels to center
		center.add(empInfoView, "Emp Info");
		center.add(empBenefitsView, "Emp Benefits");
	}

	public void addToEmpInfo() {
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
		empInfoView.add(fulltime);
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
		fulltime.setBounds(200, 490, 190, 22);
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
	}

	public void addToEmpBenefits() {
		empBenefitsView.add(benefits);
		benefits.setBounds(200, 50, 190, 22);
	}

	public static void main(String[] args) {
		new HRScreen();
	}
}