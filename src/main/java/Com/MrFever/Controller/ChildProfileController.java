package Com.MrFever.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Com.MrFever.Dao.ChildProfileDao;
import Com.MrFever.Dao.MedicineDao;
import Com.MrFever.Dao.TemperatureDao;
import Com.MrFever.Model.Medicine;
import Com.MrFever.Model.Temperature;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ChildProfileController implements Initializable {

	ChildProfileDao chPDao = new ChildProfileDao();
	TemperatureDao tDao = new TemperatureDao();
	MedicineDao mDao = new MedicineDao();

	@FXML
	private Tab childProfileTab;

	@FXML
	private ImageView girlOrBoy;

    @FXML
    private Label nameLabel;

    @FXML
    private Label birthLabel;

	@FXML
	private Tab temperatureTab;

	@FXML
	private TableView<Temperature> temperatureTable;

	@FXML
	private TableColumn<Temperature, String> dateColumn;

	@FXML
	private TableColumn<Temperature, String> timeColumn;

	@FXML
	private TableColumn<Temperature, String> placeColumn;

	@FXML
	private TableColumn<Temperature, Double> levelColumn;

	@FXML
	private Tab medicinesTab;

	@FXML
	private TableView<Medicine> medicineTable;

	@FXML
	private TableColumn<Medicine, String> dateMColumn;

	@FXML
	private TableColumn<Medicine, String> timeMColumn;

	@FXML
	private TableColumn<Medicine, String> medicineColumn;

	@FXML
	private TableColumn<Medicine, String> formColumn;

	@FXML
	private TableColumn<Medicine, String> doseColumn;

	@FXML
	private Button addTemperatureButton;

	@FXML
	private Button addMedDoseButton;

	@FXML
	private Button returnButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		try {
			chPDao.viewChildDetails();
		} catch (ClassNotFoundException | SQLException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		nameLabel.setText("Child's name: " + ChildProfileDao.name);
		birthLabel.setText("Child's date of birth: " + ChildProfileDao.dateOfBirth);
	
		String sexImage = ChildProfileDao.sex;
		/*

		if (sexImage.equals("boy")) {
			girlOrBoy.setImage(new Image(FXMLLoader.class.getResourceAsStream("../Resources/boy.png")));
		}
		*/
		
		// filling temperatureTable using selecting items from database
		try {
			tDao.viewTemperatures();
		} catch (ClassNotFoundException | SQLException | InterruptedException e1) {
			e1.printStackTrace();
		}

		dateColumn.setCellValueFactory(new PropertyValueFactory("date"));
		timeColumn.setCellValueFactory(new PropertyValueFactory("time"));
		placeColumn.setCellValueFactory(new PropertyValueFactory("place"));
		levelColumn.setCellValueFactory(new PropertyValueFactory("level"));
		temperatureTable.setItems(null);
		temperatureTable.setItems(tDao.temperatureList);

		// filling medicineTable using selecting items from database
		try {
			mDao.viewGivenMedicines();
		} catch (ClassNotFoundException | SQLException | InterruptedException e1) {
			e1.printStackTrace();
		}

		dateMColumn.setCellValueFactory(new PropertyValueFactory("dateM"));
		timeMColumn.setCellValueFactory(new PropertyValueFactory("timeM"));
		medicineColumn.setCellValueFactory(new PropertyValueFactory("type"));
		formColumn.setCellValueFactory(new PropertyValueFactory("form"));
		doseColumn.setCellValueFactory(new PropertyValueFactory("dose"));
		medicineTable.setItems(null);
		medicineTable.setItems(mDao.givenMedicinesList);

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