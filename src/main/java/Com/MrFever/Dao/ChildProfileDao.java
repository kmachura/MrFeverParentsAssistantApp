package Com.MrFever.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Com.MrFever.Controller.ChildrenController;

public class ChildProfileDao {
	
	public static String name = null;
	public static String dateOfBirth = null;
	public static String sex = null;

	public void viewChildDetails() throws ClassNotFoundException, SQLException, InterruptedException {

		final Connection conn = DbConnectionManager.getConn();
		Statement statement = conn.createStatement();
		final String sqlQuery = "SELECT name, dateofbirth, sex FROM children WHERE name = '" + ChildrenController.chosenChild + "';";
		ResultSet resultSet = statement.executeQuery(sqlQuery);

		
		while (resultSet.next()) {
			name = resultSet.getString("name");
			dateOfBirth = resultSet.getString("dateofbirth");
			sex = resultSet.getString("sex");
		
		}

		if (statement != null) {
			statement.close();
		}
		if (resultSet != null) {
			resultSet.close();
		}
		if (conn != null) {
			conn.close();
		}

	}

}
