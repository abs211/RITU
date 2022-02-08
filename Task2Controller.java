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

public class Task2Controller {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
    private Button Back;
	@FXML
    private Button Continue;
	
	 	@FXML
	    void goBack(ActionEvent event) {
	    	try {
				root = FXMLLoader.load(getClass().getResource("Task1B.fxml"));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	 	@FXML
	    void Continue(ActionEvent event) {
	    	try {
				root = FXMLLoader.load(getClass().getResource("Task2B.fxml"));
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