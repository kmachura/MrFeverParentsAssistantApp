package Com.MrFever.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Com.MrFever.Controller.DeleteChildController;

public class DeletedProfileDao {

	DeleteChildController dChCon = new DeleteChildController();

	public void deletedProfile() throws ClassNotFoundException, SQLException, InterruptedException {

		final Connection conn = DbConnectionManager.getConn();
		Statement statement = conn.createStatement();

		final String sqlQuery = "DELETE FROM children WHERE name = '" + DeleteChildController.profileToBeDeleted + "'";

		statement.executeUpdate(sqlQuery);

		if (statement != null) {
			statement.close();
		}

		if (conn != null) {
			conn.close();
		}

	}
}