package Com.MrFever.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Com.MrFever.Dao.ChildProfileDao;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ChildProfileController implements  Initializable {
	
	ChildProfileDao chPDao = new ChildProfileDao();
	
	@FXML
    private Tab childProfileTab;

    @FXML
    private ImageView girlOrBoy;

    @FXML
    private TextField nameField;

    @FXML
    private TextField birthField;

    @FXML
    private Tab temperatureTab;

    @FXML
    private TableView<?> temperatureTable;

    @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private TableColumn<?, ?> timeColumn;

    @FXML
    private TableColumn<?, ?> placeColumn;

    @FXML
    private TableColumn<?, ?> levelColumn;

    @FXML
    private Tab medicinesTab;

    @FXML
    private TableView<?> medicineTable;

    @FXML
    private TableColumn<?, ?> dateMcolumn;

    @FXML
    private TableColumn<?, ?> timeMcolumn;

    @FXML
    private TableColumn<?, ?> medicineColumn;

    @FXML
    private TableColumn<?, ?> formColumn;

    @FXML
    private TableColumn<?, ?> doseColumn;

    @FXML
    private Button addTemperatureButton;

    @FXML
    private Button addMedDoseButton;
    
    @FXML
    private Button returnButton;

    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	System.out.println(ChildrenController.chosenChild);
    	
    	try {
			chPDao.viewChildDetails();
		} catch (ClassNotFoundException | SQLException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	nameField.setText("Child's name: " + ChildProfileDao.name);
    	birthField.setText("Child's date of birth: " + ChildProfileDao.dateofbirth);
    	String sexImage = ChildProfileDao.sex;
    	
    	ImageView girlOrBoy = new ImageView(getClass().getResource("../Resources/" + sexImage + ".png").toExternalForm());
    	
    	addTemperatureButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					goToAddTemperaturePane(event);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
    	
    	addMedDoseButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					goToAddMedicineDosePane(event);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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

	private void goToAddTemperaturePane(ActionEvent e) throws IOException {
		System.out.println("Button was clicked!");
		System.out.println(e.getEventType());
		Parent home_page_parent = FXMLLoader.load(getClass().getResource("../View/AddTemperaturePane.fxml"));
		Scene home_page_scene = new Scene(home_page_parent);
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.hide(); // optional
		app_stage.setScene(home_page_scene);
		app_stage.show();
	}
    
    private void goToAddMedicineDosePane(ActionEvent e) throws IOException {
		System.out.println("Button was clicked!");
		System.out.println(e.getEventType());
		Parent home_page_parent = FXMLLoader.load(getClass().getResource("../View/AddMedicineDosePane.fxml"));
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

}