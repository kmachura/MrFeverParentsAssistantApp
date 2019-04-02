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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteChildController implements Initializable {

    @FXML
    private TextField titleField;

    @FXML
    private ChoiceBox<?> profileChoiceBox;

    @FXML
    private TextField confirmationField;

    @FXML
    private Button returnButton;

    @Override
   	public void initialize(URL arg0, ResourceBundle arg1) {

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

   }
