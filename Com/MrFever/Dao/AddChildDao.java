package Com.MrFever.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Com.MrFever.Controller.AddChildController;

public class AddChildDao {

	public void addedProfile() throws ClassNotFoundException, SQLException, InterruptedException {

		final Connection conn = DbConnectionManager.getConn();
		Statement statement = conn.createStatement();

		final String sqlQuery = "INSERT INTO children (name, dateofbirth, sex) VALUES ('" + AddChildController.givenNameOfChild + "', '" + AddChildController.givenBirthdayOfChild + "', '" + AddChildController.selectedSex + "')";

		statement.executeUpdate(sqlQuery);

		if (statement != null) {
			statement.close();
		}

		if (conn != null) {
			conn.close();
		}

	}

}
