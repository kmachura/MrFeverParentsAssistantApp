package Com.MrFever.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionManager {
	
	private static String url = "jdbc:mysql://localhost:3306/mrfever?serverTimezone=UTC&useSSL=false";    
    private static String driverName = "com.mysql.cj.jdbc.Driver";   
    private static String username = "root";   
    private static String password = "admin";
    private static Connection conn;

	public static void setConn(Connection conn) {
		DbConnectionManager.conn = conn;
	}

	public static Connection getConn() {
        try {
            Class.forName(driverName);
            try {
                conn = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
               ex.printStackTrace(); 
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found."); 
        }
        return conn;
    }
}