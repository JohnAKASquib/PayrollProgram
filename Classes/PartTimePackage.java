package Classes;

public class PartTimePackage extends BenefitsPackage{
	
	
	
	
	static Benefit[] benefitsPartTime = new Benefit[3];
	
	
	
	
	
	public static void main(String[] args) {
		
	}
	
	
	
	public PartTimePackage() {
		this.MakePartTimePackage();
	}
	
	
	
	public Benefit[] MakePartTimePackage() {
		
		ID = 0;
		
		
		benefitsPartTime[0] = healthInsurance;
		benefitsPartTime[1] = visionCare;
		benefitsPartTime[2] = dentalCare;
		
		
		return benefitsPartTime;
	}
	
	

	public void display() {
		
		for (int index = 0; index < benefitsPartTime.length; index++) {
		(benefitsPartTime[index]).print();
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
