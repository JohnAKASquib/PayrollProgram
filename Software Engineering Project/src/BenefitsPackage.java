
public class BenefitsPackage {
	
	
	public static int numBenefitsBronze = 15;
	public static int numBenefitsSilver = 20;
	public static int numBenefitsGold = 30;
	
	public int ID;
	
	Benefit dentalCare = new Benefit("Dental Care", 70, 30, true);
	
	public static Benefit [] benefitsBronze = new Benefit[numBenefitsBronze];
	public static Benefit [] benefitsSilver = new Benefit[numBenefitsSilver];
	public static Benefit [] benefitsGold = new Benefit[numBenefitsGold];
	
	
	
	public BenefitsPackage() {
		
	}
	
	
	
	
	public BenefitsPackage(int numBenefitsBronze) {

		this.numBenefitsBronze = numBenefitsBronze;
		
		
}







	public void setNumBenefitsBronze(int numBenefitsBronze) {
		this.numBenefitsBronze = numBenefitsBronze;
	}
	
	
	
	
	
	
	public void setNumBenefitsSilver(int numBenefitsSilver) {
		this.numBenefitsSilver = numBenefitsSilver;
	}
	
	
	
	
	
	
	public void setNumBenefitsGold(int numBenefitsGold) {
		this.numBenefitsGold = numBenefitsGold;
	}
	
	
	
	
	
	
	
	
    public void setBenefitsBronze() {
    	benefitsBronze[0] = dentalCare;
    	//this.benefitsBronze[index] = benefit;
	}

    
    
    
    

    public void setBenefitsSilver(int index, Benefit benefit) {
		this.benefitsSilver[index] = benefit;
	}
	
    
    
    
    
    
    
    public void setBenefitsGold(int index, Benefit benefit) {
		this.benefitsGold[index] = benefit;
	}
	
    
    
    
    
    

	public int getNumBenefitsBronze() {
	    return numBenefitsBronze;
	}
	
	
	
	
	
	
	
	public int getNumBenefitsSilver() {
	    return numBenefitsSilver;
	}
	
	
	
	
	
	
	
	public int getNumBenefitsGold() {
	    return numBenefitsGold;
	}
	
	
	
	
	
	
	
	public Benefit getBenefitsBronze(int index) {
		return benefitsBronze[index];
	}
	
	
	
	
	
	
	public Benefit getBenefitsSilver(int index) {
		return benefitsSilver[index];
	}
	
	
	
	
	
	
	public Benefit getBenefitsGold(int index) {
		return benefitsGold[index];
	}
	
	
	
	
	
	
	
	
	public static void displayBenefitsBronze() {
		for (int index = 0; index < benefitsBronze.length; index++)
		(benefitsBronze[index]).print();
	}
	
	
	
	
	
	
	
	
	
	public static void displayBenefitsSilver() {
		for (int index = 0; index < benefitsSilver.length; index++)
		(benefitsSilver[index]).print();
	}

	
	
	
	
	
	
	
	public static void displayBenefitsGold() {
		for (int index = 0; index < benefitsGold.length; index++)
		(benefitsGold[index]).print();
	}
	
	
	
	
	
	
	

}
