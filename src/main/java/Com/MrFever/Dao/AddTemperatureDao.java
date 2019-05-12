package Com.MrFever.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Com.MrFever.Controller.AddTemperatureController;
import Com.MrFever.Controller.ChildrenController;

public class AddTemperatureDao {

	public void addedTemperature() throws ClassNotFoundException, SQLException, InterruptedException {

		final Connection conn = DbConnectionManager.getConn();
		Statement statement = conn.createStatement();

		final String sqlQuery = "INSERT INTO temperature (dateofmeasurement, timeofmeasurement, placeofmeasurement, leveloftemperature, whose) VALUES ('" + AddTemperatureController.givenDateOfMeasurement + "', '" + AddTemperatureController.givenTimeOfMeasurement + "', '" + AddTemperatureController.givenPlaceOfMeasurement + "', '" + AddTemperatureController.givenLevelOfTemperature + "', '" + ChildrenController.chosenChild + "')";

		statement.executeUpdate(sqlQuery);

		if (statement != null) {
			statement.close();
		}

		if (conn != null) {
			conn.close();
		}

	}

}
