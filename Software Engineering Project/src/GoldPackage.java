
public class GoldPackage extends BenefitsPackage{
	
	Benefit[] benefitsGold = new Benefit[13];
	

	
	
	
	public static void main(String[] args) {
		
	}
	
	
	
	
	
	
	
	public GoldPackage() {
		
		this.MakeGoldPackage();
		
	}
	
	
	public Benefit[] MakeGoldPackage() {
		
		ID = 3;
		
		
		benefitsGold[0] = paternalLeave;
		benefitsGold[1] = healthInsurance;
		benefitsGold[2] = lifeInsurance;
		benefitsGold[3] = disabilityProtection;
		benefitsGold[4] = dentalCare;
		benefitsGold[5] = legalInsurance;
		benefitsGold[6] = paidVacation;
		benefitsGold[7] = visionCare;
		benefitsGold[8] = daycare;
		benefitsGold[9] = education;
		benefitsGold[10] = transportation;
		benefitsGold[11] = housing;
		benefitsGold[12] = homeInsurance;
	
		
		
		return benefitsGold;
		
		
	}
	
	
	
	
	public void display() {
		for (int index = 0; index < benefitsGold.length; index++) {
		(benefitsGold[index]).print();
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
