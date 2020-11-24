package Classes;

abstract public class BenefitsPackage {
	
	
	
	
	int ID;
	
	
	static Benefit healthInsurance = new Benefit("Health Insurance", 12000, true);
	static Benefit lifeInsurance = new Benefit("Life Insurance", 10000, false);
	static Benefit legalInsurance = new Benefit("Legal Insurance", 5000, false);
	static Benefit disabilityProtection = new Benefit("Disability Protection", 3000, true);
	static Benefit daycare = new Benefit("Daycare", 8000, true);
	static Benefit paternalMaternalLeave = new Benefit("Paternal Leave", 8000, true);
	static Benefit education = new Benefit("Education", 6000, true);
	static Benefit transportation = new Benefit("Transportation", 1000, false);
	static Benefit housing = new Benefit("Housing", 12000, true);
	static Benefit paidVacation = new Benefit("Paid Vacation", 2000, false);
	static Benefit dentalCare = new Benefit("Dental Care", 500, true);
	static Benefit visionCare  = new Benefit("Vision Care", 200, true);
	
	
	
	public static void main(String[] args) { 
		
		
	}
	
	
	public BenefitsPackage() {
		
	}
	
	
	abstract public void display();

}
