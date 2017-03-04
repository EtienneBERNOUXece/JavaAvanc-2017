package fr.ece.bernoux.lab5JavaFX.Exercice2.View;

import java.util.Observable;

import fr.ece.bernoux.lab5JavaFX.Exercice2.Controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application{
	


	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		Parent root =FXMLLoader.load(getClass().getResource("layout.fxml"));
		Scene scene = new Scene (root);
		String stylesheet = getClass ()
				.getResource ("style.css")
				.toExternalForm ();
				scene.getStylesheets ().add(stylesheet);
		primaryStage.setTitle (" Welcome  to  JavaFX !");
		primaryStage.setScene ( scene );
		primaryStage.sizeToScene ();
		primaryStage.show ();

	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	public void init(){
		
	}
	

}