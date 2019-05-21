package Com.MrFever.Controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class AddChildController implements Initializable {

	public static String givenNameOfChild = null;

	public static LocalDate givenBirthdayOfChild = null;

	public static String selectedSex = null;

	@FXML
	private TextField titleField;

	@FXML
	private TextField giveNameField;

	@FXML
	private TextField nameField;

	@FXML
	private TextField giveBirthdayField;

	@FXML
	private TextField birthdayField;

	@FXML
	private TextField giveSexField;

	@FXML
	private ChoiceBox<String> sexChoiceBox;

	@FXML
	private Button addProfileButton;

	@FXML
	private DatePicker birthdayDatePicker;

	@FXML
	private Button cleanButton;

	@FXML
	private Button returnButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		nameField.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				System.out.println("Wygenerowano zdarzenie " + event.getEventType());
				nameField.textProperty().addListener((observable, oldValue, newValue) -> {
					givenNameOfChild = newValue;
				});
			}
		});

		birthdayDatePicker.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Wygenerowano zdarzenie " + event.getEventType());
				// get the birthday date picker value
				LocalDate birthdayDate = birthdayDatePicker.getValue();

				givenBirthdayOfChild = birthdayDate;

			}

		});

		String[] availableChoices = { "girl", "boy" };
		getSexChoiceBox().getItems().addAll(availableChoices);
		sexChoiceBox.getItems().add(0, "Choose sex");
		sexChoiceBox.getSelectionModel().select(0);

		sexChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			selectedSex = newValue;
		});

		addProfileButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					goToAddedProfilePane(event);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		cleanButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Wygenerowano zdarzenie" + event.getEventType());
				nameField.clear();
				birthdayDatePicker.setValue(null);
				getSexChoiceBox().getSelectionModel().selectFirst();
			}
		});

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

	private void goToAddedProfilePane(ActionEvent e) throws IOException {
		System.out.println("Button was clicked!");
		System.out.println(e.getEventType());
		Parent home_page_parent = FXMLLoader.load(getClass().getResource("../View/AddedProfilePane.fxml"));
		Scene home_page_scene = new Scene(home_page_parent);
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.hide(); // optional
		app_stage.setScene(home_page_scene);
		app_stage.show();
	}

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

	public ChoiceBox<String> getSexChoiceBox() {
		return sexChoiceBox;
	}

	public void setSexChoiceBox(ChoiceBox<String> sexChoiceBox) {
		this.sexChoiceBox = sexChoiceBox;
	}

}