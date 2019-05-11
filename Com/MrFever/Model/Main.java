package Com.MrFever.Model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent parent = (Parent) FXMLLoader.load(getClass().getResource("../View/StartPane.fxml"));
			Scene scene = new Scene(parent);
			primaryStage.setTitle("Mr Fever");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);

	}

}
