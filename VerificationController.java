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

public class VerificationController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	@FXML
    private TextField verificationField;

    @FXML
    private Button verifyButton;

    @FXML
    void verify(ActionEvent event) {
    	if(Integer.valueOf(this.verificationField.getText())==CreateNewAccountController.otp) {
    		System.out.println("Verification Done");
    	}
    	try {
  		  root = FXMLLoader.load(getClass().getResource("Login.fxml"));
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
