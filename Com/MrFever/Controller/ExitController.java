package Com.MrFever.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class ExitController implements Initializable {

    @FXML
    private ImageView mrFeverImage;

    @FXML
    private TextArea exitTextArea;

    @FXML
    private Button exitAppButton;
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		exitAppButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});
		
    
}
}
