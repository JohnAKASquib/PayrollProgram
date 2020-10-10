package GUI;

import java.awt.*;
import javax.swing.*;

public class HRScreen {
	JFrame f;
	JPanel left, top, center;
	JSeparator sep;

	HRScreen() {
		// frame
		f = new JFrame("Payroll Program");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// panels
		left = new JPanel(new GridLayout(10, 1, 10, 5));
		top = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		center = new JPanel();
		// separator
		sep = new JSeparator(SwingConstants.VERTICAL);
		// buttons
		JButton empInfo = new JButton("Employee Info");
		JButton empBenefits = new JButton("Employee Benefits");
		JButton empTax = new JButton("Employee Tax Info");
		JButton empGross = new JButton("Employee Gross Pay");
		JButton empNet = new JButton("Employee Net Pay");
		JButton ADD = new JButton("ADD");
		JButton UPDATE = new JButton("UPDATE");
		JButton DELETE = new JButton("DELETE");
		// add panels to frame
		f.add(left, BorderLayout.WEST);
		f.add(top, BorderLayout.NORTH);
		f.add(center, BorderLayout.CENTER);
		// add buttons to top panel
		top.add(empInfo);
		top.add(empBenefits);
		top.add(empTax);
		top.add(empGross);
		top.add(empNet);
		// add buttons to left panel
		left.add(ADD);
		left.add(UPDATE);
		left.add(DELETE);
		// Dimension d = sep.getPreferredSize();
		// d.height = left.getPreferredSize().height;
		// sep.setPreferredSize(d);
		// left.add(sep);

		f.setSize(1250, 700);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new HRScreen();
	}
}