package Com.MrFever.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Com.MrFever.Controller.ChildrenController;
import Com.MrFever.Model.Medicine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MedicineDao {

	public ObservableList<Medicine> givenMedicinesList = FXCollections.observableArrayList();

	public ObservableList<Medicine> viewGivenMedicines()
			throws ClassNotFoundException, SQLException, InterruptedException {
		final Connection conn = DbConnectionManager.getConn();
		Statement statement = conn.createStatement();
		final String sqlQuery = "SELECT dateofgiving, timeofgiving, typeofmedicine, formofmedicine, doseofmedicine FROM givenmedicines WHERE towhom = '"
				+ ChildrenController.chosenChild + "';";
		ResultSet resultSet = statement.executeQuery(sqlQuery);

		while (resultSet.next()) {
			givenMedicinesList.add(new Medicine(resultSet.getString("dateofgiving"),
					resultSet.getString("timeofgiving"), resultSet.getString("typeofmedicine"),
					resultSet.getString("formofmedicine"), resultSet.getString("doseofmedicine")));

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

		return givenMedicinesList;

	}

}
