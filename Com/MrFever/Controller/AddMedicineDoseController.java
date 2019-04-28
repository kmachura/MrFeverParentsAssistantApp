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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class AddMedicineDoseController implements  Initializable {

	AddMedicineDoseDao aMDDao = new AddMedicineDoseDao();
	
	public static String givenDateOfGiving = null;
	
	public static String givenTimeOfGiving = null;
	
	public static String givenTypeOfMedicine = null;
	
	public static String givenFormOfMedicine = null;
	
	public static String givenDoseOfMedicine = null;
	
	@FXML
    private TextField titleField;

    @FXML
    private TextField typeMedField;

    @FXML
    private ChoiceBox<String> typeMedChoiceBox;

    @FXML
    private TextField formMedField;

    @FXML
    private ChoiceBox<String> formMedChoiceBox;

    @FXML
    private TextField doseField;

    @FXML
    private TextField givenDoseField;

    @FXML
    private TextField dateField;

    @FXML
    private TextField givenDateField;

    @FXML
    private TextField timeField;

    @FXML
    private TextField givenTimeField;

    @FXML
    private Button addMedicineButton;

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
    	String[] availableFormOfMedicines = {"drops", "suppository", "syrup", "tablet"}; 
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
    	givenDateField.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
    		@Override
    		public void handle(KeyEvent event) {
    			System.out.println("Wygenerowano zdarzenie " + event.getEventType());	
    			givenDateField.textProperty().addListener((observable, oldValue, newValue) -> {
    			    givenDateOfGiving = newValue;
    			});
    		}
    	});
    	
    	// input for givenTimeField, getting givenTimeOfMeasurement value for further use
    	givenTimeField.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
    		@Override
    		public void handle(KeyEvent event) {
    			System.out.println("Wygenerowano zdarzenie " + event.getEventType());	
    			givenTimeField.textProperty().addListener((observable, oldValue, newValue) -> {
    			    givenTimeOfGiving = newValue;
    			});
    		}
    	});
    	
    	//action for addTempButton to go to AddedTemperaturePane
    	addMedicineButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					goToAddedMedicineDosePane(event);
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
    			givenDateField.clear();
    			givenTimeField.clear();
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



