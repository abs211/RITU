package application;

import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class LoginOrSignupController {
	private String email;
	private String playerName;
	private String phoneNumber;
	private String playerPassword;
	
	
	@FXML
    private Button loginButton;

    @FXML
    private Button signUpbutton;

    @FXML
    void login(ActionEvent event) throws InstantiationException, IllegalAccessException {
    	ViewFactory showLogin=new ViewFactory();
    	showLogin.showView("Login.fxml");
    	showLogin.fooClass(LoginController.class);
    	Stage stage=showLogin.getStage(event);
    	showLogin.closeView(stage);
    }

    @FXML
    void signUp(ActionEvent event) throws InstantiationException, IllegalAccessException {
    	ViewFactory showCreateNewAccount=new ViewFactory();
    	showCreateNewAccount.showView("CreatingNewAccount.fxml");
    	showCreateNewAccount.fooClass(CreateNewAccountController.class);
		Stage stage=showCreateNewAccount.getStage(event);
		showCreateNewAccount.closeView(stage);
    }
	
}