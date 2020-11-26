package mysql.commpayment;

import java.io.Serializable;

public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String phoneNumber;
	private int total;
	
    public Payment(){ }
    public Payment(String phoneNumber, int total){  
    	this.phoneNumber = phoneNumber;
        this.total = total;
    }
    public Payment(int id, String phoneNumber, int total){
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.total = total;
    }
     
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
 
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public int getTotal() {
        return total;
    }
 
    public void setTotal(int total) {
        this.total = total;
    }
}