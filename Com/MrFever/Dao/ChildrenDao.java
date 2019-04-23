package Com.MrFever.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ChildrenDao {
	
	
    	public void selectChildren() throws ClassNotFoundException, SQLException, InterruptedException {
    	
    	final Connection conn = DbConnectionManager.getConn();
    	Statement statement = conn.createStatement();
        final String sqlQuery = "SELECT name, dateofbirth, sex FROM children";
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        
        String name = null;
        String dateofbirth = null;
        String sex = null;
        while(resultSet.next()) {
            name = resultSet.getString("name");
            dateofbirth = resultSet.getString("dateofbirth");
            sex = resultSet.getString("sex");
            System.out.println(name + " " + dateofbirth + " " + sex);
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
        
    }
    	
    	List<String> allNames = new ArrayList<>();
    	
    	public List<String> selectChildrenName() throws ClassNotFoundException, SQLException, InterruptedException {
        	
        	final Connection conn = DbConnectionManager.getConn();
        	Statement statement = conn.createStatement();
            final String sqlQuery = "SELECT name FROM children";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            
            String name = null;
            while(resultSet.next()) {
                name = resultSet.getString("name");
                System.out.println(name);
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
