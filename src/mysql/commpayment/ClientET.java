package mysql.commpayment;
 
import java.sql.*;
import java.util.ArrayList;
 
public class ClientET {
 
	private static String url = "jdbc:mysql://localhost:3306/commpayment?serverTimezone=Europe/Kiev&allowPublicKeyRetrieval=true&useSSL=false";
    private static String username = "root";
    private static String password = "VITYAsqlpass2020";
    
    public static ArrayList<Client> choose() {
        ArrayList<Client> clients = new ArrayList<Client>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Client");
                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String firstName = resultSet.getString(2);
                    String phoneNumber = resultSet.getString(3);
                    Client client = new Client(id, firstName, phoneNumber);
                    clients.add(client);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return clients;
    }
    
    public static Client chooseThis(int id) {
    	Client client = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT * FROM Client WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int clientId = resultSet.getInt(1);
                        String firstName = resultSet.getString(2);
                        String phoneNumber = resultSet.getString(3);
                        client = new Client(clientId, firstName, phoneNumber);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return client;
    }
    
    public static ArrayList<Client> findFirstName(String firstName) {
    	ArrayList<Client> clients = new ArrayList<Client>();
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
    		try (Connection conn = DriverManager.getConnection(url, username, password)){
    			String sql = "SELECT * FROM Client WHERE firstName=?";
    			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
    				preparedStatement.setString(1, firstName);
    				ResultSet resultSet = preparedStatement.executeQuery();
    				while(resultSet.next()) {
    					int id = resultSet.getInt(1);
    					String clientName = resultSet.getString(2);
    					String phoneNumber = resultSet.getString(3);
    					Client client = new Client(id, clientName, phoneNumber);
    					clients.add(client);
    				}
    			}
    		}
    	}
    	catch(Exception ex){
            System.out.println(ex);
        }
    	return clients;
    }
    
    public static int addNew(Client client) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "INSERT INTO Client (firstName, phoneNumber) Values (?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, client.getFirstName());
                    preparedStatement.setString(2, client.getPhoneNumber());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
     
    public static int change(Client client) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "UPDATE Client SET firstName = ?, phoneNumber = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, client.getFirstName());
                    preparedStatement.setString(2, client.getPhoneNumber());
                    preparedStatement.setInt(3, client.getId());
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
                String sql = "DELETE FROM Client WHERE id = ?";
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