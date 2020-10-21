package Classes;

public class Employee {

    String firstName;
    String lastName;
    String SSNumber;
    String address;
    String dateOfBirth;
    String homePhoneNumber;
    String mobilePhoneNumber;
    String emailAddress;
    String employedSince;
    String password;
    int IDNumber, benefitsPackageNumber;
    int hoursWorkedLastPayPeriod;
    boolean fullTime;

    public static void main(String[] args) {

    }

    public Employee() {

    }

    public Employee(String firstName, String lastName, String SSNumber, String address, String dateOfBirth,
            String homePhoneNumber, String mobilePhoneNumber, String emailAddress, String employedSince, int IDNumber,
            int benefitsPackageNumber, int hoursWorkedLastPayPeriod, boolean fullTime, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSNumber = SSNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.homePhoneNumber = homePhoneNumber;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.emailAddress = emailAddress;
        this.employedSince = employedSince;
        this.password = password;
        this.IDNumber = IDNumber;
        this.benefitsPackageNumber = benefitsPackageNumber;
        this.hoursWorkedLastPayPeriod = hoursWorkedLastPayPeriod;
        this.fullTime = fullTime;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSSNumber(String SSNumber) {
        this.SSNumber = SSNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setEmployedSince(String employedSince) {
        this.employedSince = employedSince;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIDNumber(int IDNumber) {
        this.IDNumber = IDNumber;
    }

    public void setHoursWorkedLastPayPeriod(int hoursWorkedLastPayPeriod) {
        this.hoursWorkedLastPayPeriod = hoursWorkedLastPayPeriod;
    }

    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSSNumber() {
        return SSNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getEmployedSince() {
        return employedSince;
    }

    public String getPassword() {
        return password;
    }

    public int getIDNumber() {
        return IDNumber;
    }

    public int getHoursWorkedLastPayPeriod() {
        return hoursWorkedLastPayPeriod;
    }

    public boolean isFullTime() {
        return fullTime;
    }

    public void print() {
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(SSNumber);
        System.out.println(address);
        System.out.println(dateOfBirth);
        System.out.println(homePhoneNumber);
        System.out.println(mobilePhoneNumber);
        System.out.println(emailAddress);
        System.out.println(employedSince);
        System.out.println(password);
        System.out.println(IDNumber);
        System.out.println(hoursWorkedLastPayPeriod);
        System.out.println(fullTime);
    }
}
