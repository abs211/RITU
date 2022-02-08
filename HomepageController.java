package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HomepageController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	

    @FXML
    private Button PlayGame;
    @FXML
    private Button Leaderboard;
    @FXML
    private Button About;
    


    @FXML
    void PlayGame(ActionEvent event) {
    	try {
			root = FXMLLoader.load(getClass().getResource("Task1.fxml"));
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
    void Leaderboard(ActionEvent event) {
    	try {
			root = FXMLLoader.load(getClass().getResource("Leaderboard.fxml"));
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
    void About(ActionEvent event) {
    	try {
			root = FXMLLoader.load(getClass().getResource("About.fxml"));
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
