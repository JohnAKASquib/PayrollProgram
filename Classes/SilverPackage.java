package Classes;

public class SilverPackage extends BenefitsPackage{
	
	
	Benefit[] benefitsSilver = new Benefit[8];
	
	
	
	

	
	public static void main(String[] args) {
		
	}
	
	
	
	
	
	
	public SilverPackage() {
		
		this.MakeSilverPackage();
		
	}
	
	
	
	
	public Benefit[] MakeSilverPackage() {
		
		
		ID = 2;
		
		
		
		benefitsSilver[0] = paternalMaternalLeave;
		benefitsSilver[1] = healthInsurance;
		benefitsSilver[2] = lifeInsurance;
		benefitsSilver[3] = disabilityProtection;
		benefitsSilver[4] = dentalCare;
		benefitsSilver[5] = legalInsurance;
		benefitsSilver[6] = paidVacation;
		benefitsSilver[7] = visionCare;
		
		return benefitsSilver;
		
	}
	
	
	
	
	
	public void display() {
		for (int index = 0; index < benefitsSilver.length; index++) {
		(benefitsSilver[index]).print();
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
