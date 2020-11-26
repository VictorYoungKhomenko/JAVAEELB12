package mysql.commpayment;
 
import java.sql.*;
import java.util.ArrayList;
 
public class PaymentET {
 
	private static String url = "jdbc:mysql://localhost:3306/commpayment?serverTimezone=Europe/Kiev&allowPublicKeyRetrieval=true&useSSL=false";
    private static String username = "root";
    private static String password = "VITYAsqlpass2020";
    
    public static ArrayList<Payment> choose() {
        ArrayList<Payment> payments = new ArrayList<Payment>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Payment");
                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String phoneNumber = resultSet.getString(2);
                    int total = resultSet.getInt(3);
                    Payment payment = new Payment(id, phoneNumber, total);
                    payments.add(payment);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return payments;
    }
    
    public static Payment chooseThis(int id) {
    	Payment payment = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT * FROM Payment WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int paymentId = resultSet.getInt(1);
                        String phoneNumber = resultSet.getString(2);
                        int total = resultSet.getInt(3);
                        payment = new Payment(paymentId, phoneNumber, total);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return payment;
    }
    
    public static ArrayList<Payment> findPhoneNumber(String phoneNumber) {
    	ArrayList<Payment> payments = new ArrayList<Payment>();
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
    		try (Connection conn = DriverManager.getConnection(url, username, password)){
    			String sql = "SELECT * FROM Payment WHERE phoneNumber=?";
    			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
    				preparedStatement.setString(1, phoneNumber);
    				ResultSet resultSet = preparedStatement.executeQuery();
    				while(resultSet.next()) {
    					int id = resultSet.getInt(1);
    					String paymentPhoneNumber = resultSet.getString(2);
    					int total = resultSet.getInt(3);
    					Payment payment = new Payment(id, paymentPhoneNumber, total);
    					payments.add(payment);
    				}
    			}
    		}
    	}
    	catch(Exception ex){
            System.out.println(ex);
        }
    	return payments;
    }
    
    public static int addNew(Payment payment) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "INSERT INTO Payment (phoneNumber, total) Values (?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                	preparedStatement.setString(1, payment.getPhoneNumber());
                    preparedStatement.setInt(2, payment.getTotal());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
     
    public static int change(Payment payment) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "UPDATE Payment SET phoneNumber = ?, total = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                	preparedStatement.setString(1, payment.getPhoneNumber());
                    preparedStatement.setInt(2, payment.getTotal());
                    preparedStatement.setInt(3, payment.getId());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    
    public static int delete(int id) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "DELETE FROM Payment WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    
}