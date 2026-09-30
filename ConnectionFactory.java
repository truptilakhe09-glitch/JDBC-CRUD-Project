package in.soft.Factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
//this used singletone design pattern 
	
	
	//private static variable
	private static Connection con=null;
	
	//static block
	static{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_jdbc","root","admin");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//static method
	public static Connection getConnection() {
		return con;	
	}
	
	
	
	
	
}
