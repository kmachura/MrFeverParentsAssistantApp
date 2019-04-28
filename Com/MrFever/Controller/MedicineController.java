package Com.MrFever.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Com.MrFever.Dao.AddMedicineDoseDao;
import Com.MrFever.Dao.MedicineDao;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MedicineController implements Initializable {
	
	AddMedicineDoseDao aMDDao = new AddMedicineDoseDao();
	MedicineDao mDao = new MedicineDao();
	
	public static String selectedMedicine = null;

	  @FXML
	    private TextField titleMedField;

	    @FXML
	    private ChoiceBox<String> medChoiceBox;

	    @FXML
	    private TableView<?> medicineTab;

	    @FXML
	    private TableColumn<?, ?> formOfMedColumn;

	    @FXML
	    private TableColumn<?, ?> medDescriptionColumn;


	    @FXML
	    private Button addMedDoseButton;

	    @FXML
	    private Button returnButton;

    @Override
   	public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	// selecting givenTypeOfMedicine value in dedicated Choice Box
    	try {

			getMedChoiceBox().getItems().add(0, "Choose medicine");
			getMedChoiceBox().getSelectionModel().select(0);
			getMedChoiceBox().getItems().addAll(aMDDao.selectMedicines());
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

		medChoiceBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
			selectedMedicine = newValue;
		});
		
		getMedChoiceBox().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				try {
					mDao.viewMedicineDescription();
				} catch (ClassNotFoundException | SQLException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//fill the tableView
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
   					goToMainPane(event);
   				} catch (IOException e) {
   					// TODO Auto-generated catch block
   					e.printStackTrace();
   				}
   			}
   		});
   		
   	}
    
    public ChoiceBox<String> getMedChoiceBox() {
		return medChoiceBox;
	}

	public void setMedChoiceBox(ChoiceBox<String> medChoiceBox) {
		this.medChoiceBox = medChoiceBox;
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
       
   	private void goToMainPane(ActionEvent e) throws IOException {
   		System.out.println("Button was clicked!");
   		System.out.println(e.getEventType());
   		Parent home_page_parent = FXMLLoader.load(getClass().getResource("../View/MainPane.fxml"));
   		Scene home_page_scene = new Scene(home_page_parent);
   		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
   		app_stage.hide(); // optional
   		app_stage.setScene(home_page_scene);
   		app_stage.show();
   	}

   }