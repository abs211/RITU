package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ViewFactory {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	Object ob;
	public void fooClass(Class c) throws InstantiationException, IllegalAccessException {
		ob=c.newInstance();
	}
	public void showView(String fxmlName) {
		try {
			FXMLLoader loader=new FXMLLoader(getClass().getResource(fxmlName));
	    	root=loader.load();
	    	ob=loader.getController();
	    	scene=new Scene(root);
	    	stage=new Stage();
	    	stage.setScene(scene);
	    	stage.setTitle("RITU");
	    	stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void closeView(Stage stage) {
		stage.close();
	}
	public Stage getStage(ActionEvent event) {
		return stage=(Stage)((Node)event.getSource()).getScene().getWindow();
	}

}
