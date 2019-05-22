package Com.MrFever.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Com.MrFever.Dao.ChildrenDao;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteChildController implements Initializable {

	public static String profileToBeDeleted = null;

	ChildrenDao chDao = new ChildrenDao();

	@FXML
    private Label titleLabel;

	@FXML
	private ChoiceBox<String> profileChoiceBox;

    @FXML
    private Label confirmationLabel;

	@FXML
	private Button deleteButton;

	@FXML
	private Button returnButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//method to select a child profile to delete it from the available ones

		try {

			getProfileChoiceBox().getItems().add(0, "Choose child");
			getProfileChoiceBox().getSelectionModel().select(0);
			getProfileChoiceBox().getItems().addAll(chDao.selectChildrenName());
		} catch (ClassNotFoundException | SQLException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		profileChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			profileToBeDeleted = newValue;
		});

		//method to view message of confirmation about deleting specific profile
		getProfileChoiceBox().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				confirmationLabel.setText("Are you sure to delete " + getProfileChoiceBox().getValue() + "'s profile?");

			}
		});

		//method to send you to Deleted Profile Pane	
		deleteButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					goToDeletedProfilePane(event);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		//method to send you back to Children Pane
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

	//method to change loaded pane to Children Pane
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

	//method to change loaded pane to DeletedProfile Pane
	private void goToDeletedProfilePane(ActionEvent e) throws IOException {
		System.out.println("Button was clicked!");
		System.out.println(e.getEventType());
		Parent home_page_parent = FXMLLoader.load(getClass().getResource("../View/DeletedProfilePane.fxml"));
		Scene home_page_scene = new Scene(home_page_parent);
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.hide(); // optional
		app_stage.setScene(home_page_scene);
		app_stage.show();
	}

	public ChoiceBox<String> getProfileChoiceBox() {
		return profileChoiceBox;
	}

	public void setProfileChoiceBox(ChoiceBox<String> profileChoiceBox) {
		this.profileChoiceBox = profileChoiceBox;
	}

}
