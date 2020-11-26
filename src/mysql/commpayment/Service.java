package mysql.commpayment;

import java.io.Serializable;

public class Service implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private int rate;
    
    public Service(){ }
    public Service(String name, int rate){  
        this.name = name;
        this.rate = rate;
    }
    public Service(int id, String name, int rate){
         
        this.id = id;
        this.name = name;
        this.rate = rate;
    }
     
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
     
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getRate() {
        return rate;
    }
 
    public void setRate(int rate) {
        this.rate = rate;
    }
}