package Classes;

public class HR {
	
	String IDNumber;
	String password;
	
	
	
	
	
    public static void main(String[] args) {
		
		
	}
	
	
	
    public HR() {
    	
    }
    
    
	
	public HR(String IDNumber, String password) {
		this.IDNumber = IDNumber;
		this.password = password;
	}




	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}
	
	
	
	public void setPassword(String password) {
		this.password = password;
	}

   
	
	public String getIDNumber() {
		return IDNumber;
	}




    public String getPassword() {
		return password;
	}






	public static void ViewEmployee(Employee employee) {
         employee.print();
		
	}
	
	
	
	public static void changeFirstName(Employee employee, String firstName) {
		employee.firstName = firstName;
		
	}
	
	
	
	public static void changeLastName(Employee employee, String lastName) {
		employee.lastName = lastName;
		
	}
	
	
	public static void changeSSNumber(Employee employee, String SSNumber) {
		employee.SSNumber = SSNumber;
		
	}
	
	
	
	
	
	public static void changeAddress(Employee employee, String address) {
		employee.address = address;
		
	}
	
	
	
	
	public static void changeDateOfBirth(Employee employee, String dateOfBirth) {
		employee.dateOfBirth = dateOfBirth;
				
	}
	
	
	
	
	
	public static void changeHomePhoneNumber(Employee employee, String homePhoneNumber) {
		employee.homePhoneNumber = homePhoneNumber;
			
		
	}
	
	
	
	
			
	public static void changeMobilePhoneNumber(Employee employee, String mobilePhoneNumber) {
		employee.mobilePhoneNumber = mobilePhoneNumber;
			
		
		
	}
	
	
	
	
	public static void changeEMailAddress(Employee employee, String emailAddress) {
		employee.emailAddress = emailAddress;
		
		
	}
	
	
	
	
	public static void changeEmployedSince(Employee employee, String employedSince) {
		employee.employedSince = employedSince;
		
	}
	
	
	
	
	public static void changeIDNumber(Employee employee, int IDNumber) {
		employee.IDNumber = IDNumber;
		
	}
		
	
	
    public void changeBenefitsPackageNumber(Employee employee, int benefitsPackageNumber) {
    	employee.benefitsPackageNumber = benefitsPackageNumber;
    }
	
		
	public static void changeHoursWorkedLastPayPeriod(Employee employee, int hoursWorkedLastPayPeriod) {
		employee.hoursWorkedLastPayPeriod = hoursWorkedLastPayPeriod;
		
	}
	
	
	
	
	public static void changeIsFullTime(Employee employee, boolean fullTime) {
		employee.fullTime = fullTime;
		
	}
	
	
	
	
	
	
	
	

}
