package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GameController {

	private Stage stage;
	private Scene scene;
	private Parent root;
	

    @FXML
    private Button PlayButton;


    @FXML
    void letsPlay(ActionEvent event) {
    	try {
			root = FXMLLoader.load(getClass().getResource("LoginOrSignup.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	

}