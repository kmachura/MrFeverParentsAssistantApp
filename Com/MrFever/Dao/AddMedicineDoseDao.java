package Com.MrFever.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Com.MrFever.Controller.AddMedicineDoseController;
import Com.MrFever.Controller.ChildrenController;

public class AddMedicineDoseDao {

	//inserting given data about medicine dose to database 'givenmedicines' table 
	public void addedMedicineDose() throws ClassNotFoundException, SQLException, InterruptedException {

		final Connection conn = DbConnectionManager.getConn();
		Statement statement = conn.createStatement();

		final String sqlQuery = "INSERT INTO givenmedicines (dateofgiving, timeofgiving, typeofmedicine, formofmedicine, doseofmedicine, towhom) VALUES ('" + AddMedicineDoseController.givenDateOfGiving + "', '" + AddMedicineDoseController.givenTimeOfGiving + "', '" + AddMedicineDoseController.givenTypeOfMedicine + "', '" + AddMedicineDoseController.givenFormOfMedicine + "', '" + AddMedicineDoseController.givenDoseOfMedicine + "', '" + ChildrenController.chosenChild + "')";

		statement.executeUpdate(sqlQuery);

		if (statement != null) {
			statement.close();
		}

		if (conn != null) {
			conn.close();
		}

	}
	
	//selecting list of medicines from database 'medicineslist' table
	String medicine;
	
	List<String> allMedicines = new ArrayList<>();
	
	public List<String> selectMedicines() throws ClassNotFoundException, SQLException, InterruptedException {
    	
    	final Connection conn = DbConnectionManager.getConn();
    	Statement statement = conn.createStatement();
        final String sqlQuery = "SELECT nameofmedicine FROM medicineslist";
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        
        medicine = null;
        while(resultSet.next()) {
            medicine = resultSet.getString("nameofmedicine");
            allMedicines.add(medicine);
           
          
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
        
		return allMedicines;
        
    }

	@Override
	public String toString() {
		return allMedicines.toString();
	}
	
	

}



