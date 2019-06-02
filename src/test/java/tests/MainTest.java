package tests;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.loadui.testfx.GuiTest;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;

import Com.MrFever.Model.Child;
import Com.MrFever.Model.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

class MainTest extends ApplicationTest {

	public void start (Stage stage) throws Exception {
		  Parent mainNode = FXMLLoader.load(Main.class.getResource("../View/AddChildPane.fxml"));
		  stage.setScene(new Scene(mainNode));
		  stage.show();
		  stage.toFront();
		}
	
	  @Before
	  public void setUp () throws Exception {

	}
	
	@After
	public void tearDown () throws Exception {
	  FxToolkit.hideStage();
	  release(new KeyCode[]{});
	  release(new MouseButton[]{});
	}
	
	 @Test
	 public void testNameFieldInput () {
		  Child child = new Child();
		  child.setName("Angelina");
		 TextField textField = (TextField) GuiTest.find("#name-field");
		  clickOn("#name-field");
		  write("Angelina");
		  clickOn("#add-profile-button");
		assertThat(textField.getText(), is(child.getName()));
	  }
	  

	 public <T extends Node> T find(final String query) {
		 return (T) lookup(query).queryAll().iterator().next();
	 }

}
