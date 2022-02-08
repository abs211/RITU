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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Task2BController {
	
		Player player=Player.getObject();
		private Stage stage;
		private Scene scene;
		private Parent root;
		
		@FXML
	    private Button Back;
		@FXML
	    private Button Continue;
		@FXML
	    private Button Save;
		@FXML
	    private TextField Link;
		
		@FXML
	    void getLink(ActionEvent event) {
	    	player.setTask2(Link.getText());
	    }
	
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
	    void Submit(ActionEvent event) {
	 		try {
				  
		    	  try {
		    		  
		    		  String url = "jdbc:sqlserver://SHELBY-30102000;databaseName=master";
			    	  String user= "Ritu";
			    	  String password = "password";
					  Connection conn = DriverManager.getConnection(url,user,password);
					  
					  Statement statement = conn.createStatement();
					  ResultSet rs = statement.executeQuery("SELECT Email,Points,Task2 FROM leaderboard");
				      String sql = "UPDATE leaderboard SET Points=100 where Email ="+ player.getPlayerEmail();
				      Statement stmt = conn.createStatement();
				      stmt.executeUpdate(sql);
				        		
				      //String sql2 = "UPDATE pseudo SET task1 = '?' where Serials = '?'";
				      //PreparedStatement stmt2 = (PreparedStatement) conn.prepareStatement(sql2);
				      //stmt.execute(sql2);
					  
					  
				  } catch (SQLException e) {
					  e.printStackTrace();
				  }
	    		  
	    		  root = FXMLLoader.load(getClass().getResource("Task3.fxml"));
				  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				  scene = new Scene(root);
				  stage.setScene(scene);
				  stage.show();
				  
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	
}