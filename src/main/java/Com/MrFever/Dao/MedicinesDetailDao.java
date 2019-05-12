package Com.MrFever.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Com.MrFever.Controller.MedicineController;
import Com.MrFever.Model.MedicinesDetail;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MedicinesDetailDao{

	public ObservableList<MedicinesDetail> medicinesDetailList = FXCollections.observableArrayList();

	//selecting data about chosen medicine from database for viewing them
	public ObservableList<MedicinesDetail> viewMedicineDescription() throws ClassNotFoundException, SQLException, InterruptedException {
		final Connection conn = DbConnectionManager.getConn();
		Statement statement = conn.createStatement();
		final String sqlQuery = "SELECT formofmedicine, description FROM medicinesdetail WHERE thismedicine = '"
				+ MedicineController.selectedMedicine + "';";
		ResultSet resultSet = statement.executeQuery(sqlQuery);

		while (resultSet.next()) {
			medicinesDetailList.add(new MedicinesDetail(resultSet.getString("formofmedicine"), resultSet.getString("description")));
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
		
		return medicinesDetailList;

	}

}