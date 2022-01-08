package app;

import java.sql.Connection;



import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnexionSingleton  {
	
	private static Connection conn;
	
	

	private ConnexionSingleton() {
		
	}
	
		
			public static Connection getInstance(){
		
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/Gestionpharmacie","root","");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return conn;
				
				}

}