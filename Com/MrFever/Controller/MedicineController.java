package Com.MrFever.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

public class MedicineController implements Initializable {

    @FXML
    private Accordion medicineList;

    @FXML
    private TitledPane paracetamolPane;

    @FXML
    private TitledPane ibuprofenPane;

    @FXML
    private TitledPane aspirinPane;

    @FXML
    private TitledPane mixedMedPane;

    @FXML
    private TextField titleMedField;
    
    @FXML
    private Button addMedDoseButton;
    
    @FXML
    private Button returnButton;

    @Override
   	public void initialize(URL arg0, ResourceBundle arg1) {
       	
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