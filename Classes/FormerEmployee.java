package Classes;

public class FormerEmployee extends Employee {
    String firstName;
    String lastName;
    String IDNumber;
    String address;
    String employedSince;
    String dateLeft;
    String mobilePhoneNumber;
    String emailAddress;
    String reasonForLeaving;
    
    public void setReasonForLeaving (String s){
            this.reasonForLeaving=s;
    }
    public void setDateLeft (String s){
            this.dateLeft=s;
    }
    public String getReasonForLeaving (){
         return  this.reasonForLeaving;
        }
    public String getDateLeft (){
             return  this.dateLeft;
            }
}