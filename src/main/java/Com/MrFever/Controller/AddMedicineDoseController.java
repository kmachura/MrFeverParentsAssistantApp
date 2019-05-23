package Com.MrFever.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Com.MrFever.Dao.AddMedicineDoseDao;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class AddMedicineDoseController implements Initializable {

	AddMedicineDoseDao aMDDao = new AddMedicineDoseDao();

	public static LocalDate givenDateOfGiving = null;

	public static String givenTimeOfGiving = null;

	public static String givenTypeOfMedicine = null;

	public static String givenFormOfMedicine = null;

	public static String givenDoseOfMedicine = null;

	public static String selectedChild = null;

	ChildrenDao chDao = new ChildrenDao();

	@FXML
	private TextField titleField;

	@FXML
	private Label typeMedLabel;

	@FXML
	private ChoiceBox<String> typeMedChoiceBox;

	@FXML
	private Label formMedLabel;

	@FXML
	private ChoiceBox<String> formMedChoiceBox;

	@FXML
	private Label doseLabel;

	@FXML
	private TextField givenDoseField;

	@FXML
	private Label dateLabel;

	@FXML
	private DatePicker givenDatePicker;

	@FXML
	private Label timeLabel;

	@FXML
	private TextField givenTimeField;

	@FXML
	private Button addMedicineButton;

	@FXML
	private Label whichChildLabel;

	@FXML
	private ChoiceBox<String> selectChildChoiceBox;

	@FXML
	private Label warningLabel;

	@FXML
	private Button cleanButton;

	@FXML
	private Button returnButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// selecting givenTypeOfMedicine value in dedicated Choice Box
		try {

			typeMedChoiceBox.getItems().addAll(aMDDao.selectMedicines());
			typeMedChoiceBox.getItems().add(0, "Choose type of medicine");
			typeMedChoiceBox.getSelectionModel().select(0);

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		typeMedChoiceBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
			givenTypeOfMedicine = newValue;
		});

		// selecting givenFormOfMedicine value in dedicated Choice Box
		String[] availableFormOfMedicines = { "drops", "suppository", "syrup", "tablet" };
		getFormMedChoiceBox().getItems().addAll(availableFormOfMedicines);
		formMedChoiceBox.getItems().add(0, "Choose place of measurement");
		formMedChoiceBox.getSelectionModel().select(0);

		formMedChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			givenFormOfMedicine = newValue;
		});

		// input for givenDoseField, getting givenDoseOfMedicine value for further use
		givenDoseField.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				System.out.println("Wygenerowano zdarzenie " + event.getEventType());
				givenDoseField.textProperty().addListener((observable, oldValue, newValue) -> {
					givenDoseOfMedicine = newValue;
				});
			}
		});

		// input for givenDateField, getting givenDateOfGiving value for further use
		givenDatePicker.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Wygenerowano zdarzenie " + event.getEventType());
				// get the birthday date picker value
				LocalDate givenDate = givenDatePicker.getValue();

				givenDateOfGiving = givenDate;

			}

		});

		// input for givenTimeField, getting givenTimeOfMeasurement value for further
		// use
		givenTimeField.setOnMouseEntered(mouseEvent -> warningLabel.setText(""));
		givenTimeField.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				System.out.println("Wygenerowano zdarzenie " + event.getEventType());
				givenTimeField.textProperty().addListener((observable, oldValue, newValue) -> {
					givenTimeOfGiving = newValue;
				});
			}
		});

		try {

			selectChildChoiceBox.getItems().addAll(chDao.selectChildrenName());
			selectChildChoiceBox.getItems().add(0, "Choose child");
			if (!(ChildrenController.chosenChild == null)) {
				selectChildChoiceBox.getSelectionModel().select(ChildrenController.chosenChild);
			} else {
				selectChildChoiceBox.getSelectionModel().select(0);
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		selectChildChoiceBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
			selectedChild = newValue;
		});

		// action for addTempButton to go to AddedTemperaturePane
		addMedicineButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					Pattern pattern = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]");
					Matcher matcher = pattern.matcher(givenTimeOfGiving);
					matcher.matches();
					if (matcher.matches() == false) {
						warningLabel.setText( "Time should be added in format: \"HH:MM\".");
						givenTimeField.clear();
						matcher = null;
					} else {
					goToAddedMedicineDosePane(event);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		// action for cleanButton to clear all of the fields
		cleanButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Wygenerowano zdarzenie" + event.getEventType());
				getTypeMedChoiceBox().getSelectionModel().selectFirst();
				getFormMedChoiceBox().getSelectionModel().selectFirst();
				givenDoseField.clear();
				givenDatePicker.setValue(null);
				givenTimeField.clear();
				getSelectChildChoiceBox().getSelectionModel().selectFirst();
			}
		});

		// action for return button to send you back to Child Profile Pane
		returnButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					goToChildProfilePane(event);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}

	public ChoiceBox<String> getSelectChildChoiceBox() {
		return selectChildChoiceBox;
	}

	public void setSelectChildChoiceBox(ChoiceBox<String> selectChildChoiceBox) {
		this.selectChildChoiceBox = selectChildChoiceBox;
	}

	public ChoiceBox<String> getTypeMedChoiceBox() {
		return typeMedChoiceBox;
	}

	public void setTypeMedChoiceBox(ChoiceBox<String> typeMedChoiceBox) {
		this.typeMedChoiceBox = typeMedChoiceBox;
	}

	public ChoiceBox<String> getFormMedChoiceBox() {
		return formMedChoiceBox;
	}

	public void setFormMedChoiceBox(ChoiceBox<String> formMedChoiceBox) {
		this.formMedChoiceBox = formMedChoiceBox;
	}

	// method to change loaded Pane to Children Pane
	private void goToChildProfilePane(ActionEvent e) throws IOException {
		System.out.println("Button was clicked!");
		System.out.println(e.getEventType());
		Parent home_page_parent = FXMLLoader.load(getClass().getResource("../View/ChildrenPane.fxml"));
		Scene home_page_scene = new Scene(home_page_parent);
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.hide(); // optional
		app_stage.setScene(home_page_scene);
		app_stage.show();
	}

	// method to change loaded Pane to AddedMedicineDose Pane
	private void goToAddedMedicineDosePane(ActionEvent e) throws IOException {
		System.out.println("Button was clicked!");
		System.out.println(e.getEventType());
		Parent home_page_parent = FXMLLoader.load(getClass().getResource("../View/AddedMedicineDosePane.fxml"));
		Scene home_page_scene = new Scene(home_page_parent);
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.hide(); // optional
		app_stage.setScene(home_page_scene);
		app_stage.show();
	}

}
