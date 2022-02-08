package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateNewAccountController {
	@FXML
    private Button createAccountButton;

    @FXML
    private TextField emailIDField;

    @FXML
    private TextField playerName;

    @FXML
    private PasswordField playerPassword;

    @FXML
    private TextField playerPhoneNumber;
    static int otp;
    
    static String newplayerEmail;
    
    @FXML
    void createAccount(ActionEvent event) throws InstantiationException, IllegalAccessException {
		DataBase.sendData(this.emailIDField.getText(), this.playerName.getText(), this.playerPhoneNumber.getText(), this.playerPassword.getText());
		//newplayerEmail=this.emailIDField.getText();
		CreateNewAccountController.otp=generateOTP();
		ViewFactory showVerification=new ViewFactory();
		showVerification.showView("Verification.fxml");
		showVerification.fooClass(VerificationController.class);
		Stage stage=showVerification.getStage(event);
		showVerification.closeView(stage);
		System.out.println(CreateNewAccountController.otp);
		//SendingMail mail=new SendingMail();
		//if(mail.mailLogin()) {
			//mail.sendVerification();
		//}
		
    }
    private int generateOTP() {
    	int otpCode=(int)(Math.random()*(10023-6789+1)+10023);
    	return otpCode;
    }
}