package BackEndDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SQL {

	public static int orderPrice = 0;
	public static String orderDescription = "";
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		createTable();
		post();
		get();
	}
    public static ArrayList<String> get() throws Exception{
        try{
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT orderDescription, price FROM orderDetail");
            
            ResultSet result = statement.executeQuery();
            
            ArrayList<String> array = new ArrayList<String>();
            while(result.next()){
                System.out.println("your order: " + result.getString("orderDescription") + "\nyour price: " + result.getInt("price"));
                
                array.add(result.getString("orderDescription"));
            }
            System.out.println("All records have been selected!");
            return array;
            
        }catch(Exception e){System.out.println(e);}
        return null;
        
    }
	
	public static void post() throws Exception{
		int int1 = orderPrice;
		String var1 = orderDescription;
		
		try{
            Connection con = getConnection();
            PreparedStatement posted = con.prepareStatement("INSERT INTO orderDetail (orderDescription, price) VALUES ('"+var1+"', '"+int1+"')");
            
            posted.executeUpdate();
        } catch(Exception e){System.out.println(e);}
        finally {
            System.out.println("Insert Completed.");
        }
    
	}
	
	public static void createTable() throws Exception {
		try {
			Connection con =getConnection();
			//PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS orderDetail(orderID int NOT NULL AUTO_INCREMENT, customerID int, customerName varchar(30), orderDescrip varchar(100), orderIncome DECIMAL(10.2), orderIngredientUsed varchat(100), PRIMARY KEY(customerID))");
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS orderDetail(id int NOT NULL AUTO_INCREMENT, orderDescription varchar(255), price varchar(255), PRIMARY KEY(id))");
			create.executeUpdate();
		}catch(Exception e) {System.out.println(e);}
		finally {
			System.out.println("Function complete.");
			};
	}
	
	public static Connection getConnection() throws Exception{
		try {
			String driver ="com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1:3306/orderlist";
			String username = "root";
			String password = "jerrychu123";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			return conn;
			
		}catch(Exception e) {System.out.println(e);}
		
		return null;
	}
	
}
