package Com.MrFever.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Com.MrFever.Controller.ChildrenController;
import Com.MrFever.Model.Temperature;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TemperatureDao<E> {

	public ObservableList<Temperature> temperatureList = FXCollections.observableArrayList();
	
	public ObservableList<Temperature> viewTemperatures() throws ClassNotFoundException, SQLException, InterruptedException {
		final Connection conn = DbConnectionManager.getConn();
		Statement statement = conn.createStatement();
		final String sqlQuery = "SELECT dateofmeasurement, timeofmeasurement, placeofmeasurement, leveloftemperature FROM temperature WHERE whose = '" + ChildrenController.chosenChild + "';";
		ResultSet resultSet = statement.executeQuery(sqlQuery);

		while (resultSet.next()) {
			temperatureList.add(new Temperature(resultSet.getDouble("leveloftemperature"), resultSet.getString("placeofmeasurement"), resultSet.getString("dateofmeasurement"), resultSet.getString("timeofmeasurement")));

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

		return temperatureList;

	}

}
