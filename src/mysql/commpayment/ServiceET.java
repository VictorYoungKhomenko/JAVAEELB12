package mysql.commpayment;
 
import java.sql.*;
import java.util.ArrayList;
 
public class ServiceET {
	private static String url = "jdbc:mysql://localhost:3306/commpayment?serverTimezone=Europe/Kiev&allowPublicKeyRetrieval=true&useSSL=false";
    private static String username = "root";
    private static String password = "VITYAsqlpass2020";
    
    public static ArrayList<Service> choose() {
        ArrayList<Service> services = new ArrayList<Service>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Service");
                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int rate = resultSet.getInt(3);
                    Service service = new Service(id, name, rate);
                    services.add(service);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return services;
    }
    
    public static Service chooseThis(int id) {
    	Service service = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT * FROM Service WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int serviceId = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        int rate = resultSet.getInt(3);
                        service = new Service(serviceId, name, rate);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return service;
    }
    
    public static ArrayList<Service> findRate(int rate) {
    	ArrayList<Service> services = new ArrayList<Service>();
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
    		try (Connection conn = DriverManager.getConnection(url, username, password)){
    			String sql = "SELECT * FROM Service WHERE rate=?";
    			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
    				preparedStatement.setInt(1, rate);
    				ResultSet resultSet = preparedStatement.executeQuery();
    				while(resultSet.next()) {
    					int id = resultSet.getInt(1);
    					String name = resultSet.getString(2);
    					int serviceRate = resultSet.getInt(3);
    					Service service = new Service(id, name, serviceRate);
    					services.add(service);
    				}
    			}
    		}
    	}
    	catch(Exception ex){
            System.out.println(ex);
        }
    	return services;
    }
    
    public static int addNew(Service service) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "INSERT INTO Service (name, rate) Values (?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, service.getName());
                    preparedStatement.setInt(2, service.getRate());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
     
    public static int change(Service service) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "UPDATE Service SET name = ?, rate = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, service.getName());
                    preparedStatement.setInt(2, service.getRate());
                    preparedStatement.setInt(3, service.getId());
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
                String sql = "DELETE FROM Service WHERE id = ?";
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