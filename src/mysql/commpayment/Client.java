package mysql.commpayment;

import java.io.Serializable;

public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;
	 
    private int id;
    private String firstName;
    private String phoneNumber;
    
    public Client(){ }
    public Client(String firstName, String phoneNumber){
         
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
    }
    public Client(int id, String firstName, String phoneNumber){
         
        this.id = id;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
    }
     
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
     
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getPhoneNumber() {
        return phoneNumber;
    }
 
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}