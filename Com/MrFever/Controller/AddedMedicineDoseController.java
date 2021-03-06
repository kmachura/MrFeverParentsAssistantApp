package Com.MrFever.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Com.MrFever.Dao.AddMedicineDoseDao;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddedMedicineDoseController implements Initializable {
	
	AddMedicineDoseDao aMDDao = new AddMedicineDoseDao();

	@FXML
	private TextField messageField;

	@FXML
	private Button returnButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// Initializing inserting data to table 'givenmedicines' in database
		try {
			aMDDao.addedMedicineDose();
		} catch (ClassNotFoundException | SQLException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// viewing message for adding medicine dose
		messageField.setText("Medicine dose was added");

       	// action for return button to send you back to Children Pane
		returnButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					goToChildrenPane(event);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}

	// method to change loaded Pane to Children Pane
	private void goToChildrenPane(ActionEvent e) throws IOException {
		System.out.println("Button was clicked!");
		System.out.println(e.getEventType());
		Parent home_page_parent = FXMLLoader.load(getClass().getResource("../View/ChildrenPane.fxml"));
		Scene home_page_scene = new Scene(home_page_parent);
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.hide(); // optional
		app_stage.setScene(home_page_scene);
		app_stage.show();
	}

}
