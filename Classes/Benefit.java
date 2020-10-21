package Classes;

public class Benefit {
	
	
	
	String name;
	int amountGiven;
	boolean includesFamily;
	
	
	
	public static void main(String[] args) { 
		
		
		
		
	}
	
	
	
	
	
	public Benefit() {
		
	}
	
	
	
	
	public Benefit(String name, int amountGiven, boolean includesFamily) {
		
		
		this.name = name;
		this.amountGiven = amountGiven;
		this.includesFamily = includesFamily;
		
	}
 



	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	public void setAmountGiven(int amountGiven) {
		this.amountGiven = amountGiven;
	}
	
	
	
	
	
	
	public void setIncludesFamily(boolean includesFamily) {
		this.includesFamily = includesFamily;
	}
	
	
	
	
	
	public String getName() {
		return name;
	}
	
	

	
	
	
	
	
	public int getAmountGiven() {
		return amountGiven;
	}
	
	
	
	
	
	
	public boolean getIncludesFamily() {
		return includesFamily;
	}
	
	
	
	public void print() {
		System.out.println(name);
		System.out.println(amountGiven);
		System.out.println(includesFamily);
		
	}
	
	
	
	

}
