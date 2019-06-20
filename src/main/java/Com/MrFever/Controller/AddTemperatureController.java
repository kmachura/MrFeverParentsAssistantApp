package Com.MrFever.Controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Com.MrFever.Dao.AddTemperatureDao;
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

public class AddTemperatureController implements Initializable {

	AddTemperatureDao aTDao = new AddTemperatureDao();

	public static LocalDate givenDateOfMeasurement = null;

	public static String givenTimeOfMeasurement = null;

	public static String givenPlaceOfMeasurement = null;

	public static Double givenLevelOfTemperature = 0.0;

	@FXML
	private Label titleLabel;

	@FXML
	private Label temperatureLevelLabel;

	@FXML
	private TextField givenTemperatureLevelField;

	@FXML
	private Label placeOfMeasurementLabel;

	@FXML
	private ChoiceBox<String> placeOfMeasurementChoiceBox;

	@FXML
	private Label dateLabel;

	@FXML
	private DatePicker givenDatePicker;

	@FXML
	private Label timeLabel;

	@FXML
	private TextField givenTimeField;

	@FXML
	private Button addTempButton;

	@FXML
	private Label warningLabel;

	@FXML
	private Button cleanButton;

	@FXML
	private Button returnButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// input for givenTemperatureLevelField, getting givenLevelOfTemperature value
		// for further use
		givenTemperatureLevelField.setOnMouseEntered(mouseEvent -> warningLabel.setText(""));
		givenTemperatureLevelField.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {

				System.out.println("Wygenerowano zdarzenie " + event.getEventType());
				givenTemperatureLevelField.textProperty().addListener((observable, oldValue, newValue) -> {
					try {
						givenLevelOfTemperature = Double.parseDouble(newValue);
					} catch (NumberFormatException e) {
						warningLabel
								.setText("Temperature should be added in double format \n with point as a seperator");
					}
				});
			}
		});

		// selecting givenPlaceOfMeasurement value in dedicated Choice Box
		String[] availablePlacesOfMeasurement = { "armpit", "ear", "foreahead", "mouth" };
		getPlaceOfMeasurementChoiceBox().getItems().addAll(availablePlacesOfMeasurement);
		placeOfMeasurementChoiceBox.getItems().add(0, "Choose place of measurement");
		placeOfMeasurementChoiceBox.getSelectionModel().select(0);

		placeOfMeasurementChoiceBox.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> {
					givenPlaceOfMeasurement = newValue;
				});

		// input for givenDateField, getting givenDateOfMeasurement value for further
		// use
		givenDatePicker.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Wygenerowano zdarzenie " + event.getEventType());
				// get the birthday date picker value
				LocalDate givenDateOfMeasure = givenDatePicker.getValue();

				givenDateOfMeasurement = givenDateOfMeasure;

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
					givenTimeOfMeasurement = newValue;
				});
			}
		});

		// action for addTempButton to go to AddedTemperaturePane
		addTempButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					Pattern pattern = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]");
					Matcher matcher = pattern.matcher(givenTimeOfMeasurement);
					matcher.matches();
					if (matcher.matches() == false) {
						warningLabel.setText( "Time should be added in format: \"HH:MM\".");
						givenTimeField.clear();
						matcher = null;
					} else {
					goToAddedTemperaturePane(event);
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
				givenTemperatureLevelField.clear();
				givenDatePicker.setValue(null);
				givenTimeField.clear();
				getPlaceOfMeasurementChoiceBox().getSelectionModel().selectFirst();
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

	public ChoiceBox<String> getPlaceOfMeasurementChoiceBox() {
		return placeOfMeasurementChoiceBox;
	}

	public void setPlaceOfMeasurementChoiceBox(ChoiceBox<String> placeOfMeasurementChoiceBox) {
		this.placeOfMeasurementChoiceBox = placeOfMeasurementChoiceBox;
	}

	// method to change loaded Pane to AddedTemperature Pane
	private void goToAddedTemperaturePane(ActionEvent e) throws IOException {
		System.out.println("Button was clicked!");
		System.out.println(e.getEventType());
		Parent home_page_parent = FXMLLoader.load(getClass().getResource("../View/AddedTemperaturePane.fxml"));
		Scene home_page_scene = new Scene(home_page_parent);
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.hide(); // optional
		app_stage.setScene(home_page_scene);
		app_stage.show();
	}

	// method to change loaded Pane to ChildProfile Pane
	private void goToChildProfilePane(ActionEvent e) throws IOException {
		System.out.println("Button was clicked!");
		System.out.println(e.getEventType());
		Parent home_page_parent = FXMLLoader.load(getClass().getResource("../View/ChildProfilePane.fxml"));
		Scene home_page_scene = new Scene(home_page_parent);
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.hide(); // optional
		app_stage.setScene(home_page_scene);
		app_stage.show();
	}

}
