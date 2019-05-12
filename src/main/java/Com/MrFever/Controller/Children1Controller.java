package Com.MrFever.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Com.MrFever.Dao.ChildrenDao;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

public class Children1Controller implements Initializable {
	
	ChildrenDao chDao = new ChildrenDao();

	public static String chosenChild;

    @FXML
    private TextField titleChildrenField;

    @FXML
    private Accordion childrenOptions;

    @FXML
    private TitledPane viewChildProfile;

    @FXML
    private ChoiceBox<String> childrenViewChoiceBox;

    @FXML
    private Button showButton;

    @FXML
    private TitledPane addChildProfile;

    @FXML
    private Button addChildButton;

    @FXML
    private TitledPane deleteChildProfile;

    @FXML
    private Button deleteChildButton;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		try {

			childrenViewChoiceBox.getItems().addAll(chDao.selectChildrenName());
			childrenViewChoiceBox.getItems().add(0, "Choose child");
			childrenViewChoiceBox.getSelectionModel().select(0);

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

		childrenViewChoiceBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
			chosenChild = newValue;
		});

		showButton.setOnAction(new EventHandler<ActionEvent>() {
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

		addChildButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				try {
		    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/AddChildq.fxml"));
		    		loader.load();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
			}
		});

		deleteChildButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					goToDeleteChildPane(event);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

}
    
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

	private void goToAddChildPane(ActionEvent e) throws IOException {
		System.out.println("Button was clicked!");
		System.out.println(e.getEventType());
		Parent home_page_parent = FXMLLoader.load(getClass().getResource("../View/AddChildPane.fxml"));
		Scene home_page_scene = new Scene(home_page_parent);
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.hide(); // optional
		app_stage.setScene(home_page_scene);
		app_stage.show();
	}

	private void goToDeleteChildPane(ActionEvent e) throws IOException {
		System.out.println("Button was clicked!");
		System.out.println(e.getEventType());
		Parent home_page_parent = FXMLLoader.load(getClass().getResource("../View/DeleteChildPane.fxml"));
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

	public ChoiceBox<String> getChildrenViewChoiceBox() {
		return childrenViewChoiceBox;
	}

	public void setChildrenViewChoiceBox(ChoiceBox<String> childrenViewChoiceBox) {
		this.childrenViewChoiceBox = childrenViewChoiceBox;
	}

}
