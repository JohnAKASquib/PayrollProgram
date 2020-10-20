
public class BronzePackage extends BenefitsPackage{
	
	
	
	
	static Benefit[] benefitsBronze = new Benefit[5];
	
	
	
	
	
	public static void main(String[] args) {
		
	}
	
	
	
	public BronzePackage() {
		this.MakeBronzePackage();
	}
	
	
	
	public Benefit[] MakeBronzePackage() {
		
		ID = 1;
		
		benefitsBronze[0] = paternalLeave;
		benefitsBronze[1] = healthInsurance;
		benefitsBronze[2] = lifeInsurance;
		benefitsBronze[3] = disabilityProtection;
		benefitsBronze[4] = dentalCare;
		
		
		return benefitsBronze;
	}
	
	

	public void display() {
		
		for (int index = 0; index < benefitsBronze.length; index++) {
		(benefitsBronze[index]).print();
		System.out.println();
		System.out.println();
		System.out.println();
		
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
	}
	

}
