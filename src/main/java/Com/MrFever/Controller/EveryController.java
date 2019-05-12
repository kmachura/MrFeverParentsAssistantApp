package Com.MrFever.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class EveryController implements Initializable {
	
	public static String flowVariable = null;
	
    @FXML
    private Pane viewPane;

    @FXML
    private Button addTemperatureButton;

    @FXML
    private Button addMedDoseButton;

    @FXML
    private Button returnButton;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	
    }

}
