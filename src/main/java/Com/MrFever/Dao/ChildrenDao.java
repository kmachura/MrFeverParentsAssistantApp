package Com.MrFever.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ChildrenDao {
	
	String name;
    	
    	List<String> allNames = new ArrayList<>();
    	
    	public List<String> selectChildrenName() throws ClassNotFoundException, SQLException, InterruptedException {
        	
        	final Connection conn = DbConnectionManager.getConn();
        	Statement statement = conn.createStatement();
            final String sqlQuery = "SELECT name FROM children";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            
            name = null;
            while(resultSet.next()) {
                name = resultSet.getString("name");
                allNames.add(name);
               
              
            }
            
            
            if(statement != null) {
                statement.close();
            }
            if(resultSet != null) {
                resultSet.close();
            }
            if(conn != null) {
                conn.close();
            }
            
			return allNames;
            
        }

		@Override
		public String toString() {
			return allNames.toString();
		}
    	
    	

}
