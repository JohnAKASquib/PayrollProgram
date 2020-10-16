
abstract public class BenefitsPackage {
	
	
	
	
	int ID;
	
	
	static Benefit healthInsurance = new Benefit("Health Insurance", 70, 30, true);
	static Benefit lifeInsurance = new Benefit("Life Insurance", 70, 30, true);
	static Benefit homeInsurance = new Benefit("Home Insurance", 70, 30, true);
	static Benefit legalInsurance = new Benefit("Legal Insurance", 70, 30, true);
	static Benefit disabilityProtection = new Benefit("Disability Protection", 70, 30, true);
	static Benefit daycare = new Benefit("Daycare", 70, 30, true);
	static Benefit paternalLeave = new Benefit("Paternal Leave", 70, 30, true);
	static Benefit education = new Benefit("Education", 70, 30, true);
	static Benefit transportation = new Benefit("Transportation", 70, 30, true);
	static Benefit housing = new Benefit("Housing", 70, 30, true);
	static Benefit paidVacation = new Benefit("Paid Vacation", 70, 30, true);
	static Benefit dentalCare = new Benefit("Dental Care", 70, 30, true);
	static Benefit visionCare  = new Benefit("Vision Care", 70, 30, true);
	
	
	public static void main(String[] args) { 
		
		
	}
	
	
	public BenefitsPackage() {
		
	}
	
	
	abstract public void display();

}
