package Com.MrFever.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Com.MrFever.Dao.AddMedicineDoseDao;
import Com.MrFever.Dao.MedicinesDetailDao;
import Com.MrFever.Model.MedicinesDetail;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MedicineController implements Initializable {
	
	AddMedicineDoseDao aMDDao = new AddMedicineDoseDao();
	MedicinesDetailDao mDDao = new MedicinesDetailDao();
	
	public static String selectedMedicine = null;

	  @FXML
	    private TextField titleMedField;

	    @FXML
	    private ChoiceBox<String> medChoiceBox;

	    @FXML
	    private TableView<MedicinesDetail> medicineTab;

	    @FXML
	    private TableColumn<MedicinesDetail, String> formOfMedColumn;

	    @FXML
	    private TableColumn<MedicinesDetail, String> medDescriptionColumn;


	    @FXML
	    private Button addMedDoseButton;

	    @FXML
	    private Button returnButton;

    @Override
   	public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	// selecting givenTypeOfMedicine value in dedicated Choice Box
    	try {
    		medChoiceBox.getItems().addAll(aMDDao.selectMedicines());
    		medChoiceBox.getItems().add(0, "Choose medicine");
			medChoiceBox.getSelectionModel().select(0);
			
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
		
		
		//viewing details about chosen medicine after selecting option in choiceBox
		getMedChoiceBox().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// filling medicineTab using selecting items from database
				medicineTab.getItems().clear();
				try {
					mDDao.viewMedicineDescription();
				} catch (ClassNotFoundException | SQLException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				formOfMedColumn.setCellValueFactory(new PropertyValueFactory("form"));
				medDescriptionColumn.setCellValueFactory(new PropertyValueFactory("description"));
				medicineTab.setItems(null);
				medicineTab.setItems(mDDao.medicinesDetailList);
			}
		});
       	
		//action for addMedDoseButton to send you to AddMedicineDose Pane
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
 
    	//action for returnButton to send you back to Main Pane
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

	//method to change loaded pane to AddMedicineDose Pane
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
    
	//method to change loaded Pane to Main Pane
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