package Com.MrFever.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;

public class ChildrenController {

    @FXML
    private TextField titleChildrenField;

    @FXML
    private Accordion childrenOptions;

    @FXML
    private TitledPane viewChildProfile;

    @FXML
    private ChoiceBox<?> childrenViewChoiceBox;

    @FXML
    private TitledPane addChildProfile;

    @FXML
    private Button addChildButton;

    @FXML
    private TitledPane deleteChildProfile;

    @FXML
    private Button deleteChildButton;

}
