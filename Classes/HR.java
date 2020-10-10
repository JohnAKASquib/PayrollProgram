// HR class
package Classes;

public class HR {
    String IDNumber;
    String password;
    int numEmployees;
    Employee[] employees = new Employee[numEmployees];

    static int index = 0;

    public static void main(String[] args) {

    }

    public void setNumEmployees(int numEmployees) {
        this.numEmployees = numEmployees;
    }

    public void setEmployees(int index, Employee employee) {
        this.employees[index] = employee;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public Employee getEmployees(int index) {
        return employees[index];
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

    public static void changeHoursWorkedLastPayPeriod(Employee employee, int hoursWorkedLastPayPeriod) {
        employee.hoursWorkedLastPayPeriod = hoursWorkedLastPayPeriod;
    }

    public static void changeIsFullTime(Employee employee, boolean fullTime) {
        employee.fullTime = fullTime;
    }

    public static void addBenefit(Benefit benefit) {
        BenefitsPackage.numBenefits++;
        BenefitsPackage.benefits[index] = benefit;
        index++;
    }

}