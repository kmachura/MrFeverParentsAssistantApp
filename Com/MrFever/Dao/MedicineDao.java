package Com.MrFever.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Com.MrFever.Controller.MedicineController;

public class MedicineDao {

	public static String medForm = null;
	public static String medDescription = null;

	public void viewMedicineDescription() throws ClassNotFoundException, SQLException, InterruptedException {
		
		System.out.println(MedicineController.selectedMedicine);

		final Connection conn = DbConnectionManager.getConn();
		Statement statement = conn.createStatement();
		final String sqlQuery = "SELECT formofmedicine, description FROM medicinesdetail WHERE thismedicine = '"
				+ MedicineController.selectedMedicine + "';";
		ResultSet resultSet = statement.executeQuery(sqlQuery);

		while (resultSet.next()) {
			medForm = resultSet.getString("formofmedicine");
			medDescription = resultSet.getString("description");
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