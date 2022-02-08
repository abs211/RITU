package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	Player player=Player.getObject();
    @FXML
    private Button login;

    @FXML
    private TextField mail;

    @FXML
    private TextField password;
    
    private boolean found=false;
    @FXML
    void logIN(ActionEvent event) {
    	try {
			String url = "jdbc:sqlserver://SHELBY-30102000;databaseName=master";
	    	String user= "Ritu";
	    	String password = "password";
	    	Connection conn = DriverManager.getConnection(url,user,password);
	        Statement statement = conn.createStatement();
	        ResultSet rs = statement.executeQuery("SELECT Email,PlayerName,Phonenumber,Password FROM player_info");
	        while(rs.next()) {
	        	if(rs.getString("Email").equals(this.mail.getText()) && rs.getString("Password").equals(this.password.getText())) {
	        		this.found=true;
	        		player.setPlayerEmail(rs.getString("Email"));
	        		player.setPlayerName(rs.getString("PlayerName"));
	        		player.setPlayerPhonenumber(rs.getString("Phonenumber"));
	        		player.setPlayerPassword("Password");
	        		break;
	        	}
	        }
	        
	        //PreparedStatement statement2 =null;
			//String sql = "INSERT INTO leaderboard (Email,Points,Task1,Task2,Task3)"
					//+ " VALUES (?,'x','x','x','x')";
			//statement2 = conn.prepareStatement(sql);
			//statement2.setString(1, player.getPlayerEmail());
			//statement2.executeQuery();
	        
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    	if(found) {
    		try {
				root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}else {
    		Alert alert = new Alert(AlertType.CONFIRMATION);
	  		  alert.setTitle("Warning");
	  		  alert.setHeaderText("There is no account with this email or password.");
	  		  alert.setContentText("Please try again.");
	  		  
	  		  if(alert.showAndWait().get() == ButtonType.OK) {
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
    }
    
}
