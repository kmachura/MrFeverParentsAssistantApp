package Com.MrFever.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Com.MrFever.Dao.AddChildDao;
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

public class AddChildController implements Initializable {
	
	AddChildDao achdao = new AddChildDao();
	
	private String givenNameOfChild;
	
	private String givenBirthdayOfChild;
	
	public String getGivenNameOfChild() {
		return givenNameOfChild;
	}

	public void setGivenNameOfChild(String givenNameOfChild) {
		this.givenNameOfChild = givenNameOfChild;
	}

	public String getGivenBirthdayOfChild() {
		return givenBirthdayOfChild;
	}

	public void setGivenBirthdayOfChild(String givenBirthdayOfChild) {
		this.givenBirthdayOfChild = givenBirthdayOfChild;
	}

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
    			    setGivenNameOfChild(newValue);
    			});
    		}
    	});
    	
    	birthdayField.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
    		@Override
    		public void handle(KeyEvent event) {
    			System.out.println("Wygenerowano zdarzenie " + event.getEventType());	
    			birthdayField.textProperty().addListener((observable, oldValue, newValue) -> {
    			    setGivenBirthdayOfChild(newValue);
    			});
    		}
    	});
    	
    	String[] availableChoices = {"girl", "boy"}; 
    	getSexChoiceBox().getItems().addAll(availableChoices);  
    	
    	
    	    	
    	cleanButton.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    		public void handle(ActionEvent event) {
    			System.out.println("Wygenerowano zdarzenie" + event.getEventType());
    			nameField.clear();
    			birthdayField.clear();
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