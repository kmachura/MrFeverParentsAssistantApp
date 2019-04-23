package Com.MrFever.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Com.MrFever.Controller.AddChildController;

public class AddChildDao {

	AddChildController addChildCon = new AddChildController();

	public void addChild() throws ClassNotFoundException, SQLException, InterruptedException {

		final Connection conn = DbConnectionManager.getConn();
		Statement statement = conn.createStatement();

		final String sqlQuery = "INSERT INTO children (name, dateofbirth, sex) VALUES ('" + addChildCon.getGivenNameOfChild() + "', '" + addChildCon.getGivenBirthdayOfChild() + "', '" + addChildCon.getSexChoiceBox().getSelectionModel().getSelectedItem() + "')";

		statement.executeUpdate(sqlQuery);

		if (statement != null) {
			statement.close();
		}

		if (conn != null) {
			conn.close();
		}

	}

}
