package fr.ece.bernoux.lab5JavaFX.Exercice1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FirstApp extends Application {

	

	public static void main(String[] args) {
		launch ( args );

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root =FXMLLoader.load(getClass().getResource("layout.fxml"));	
		Scene scene = new Scene (root);
		String stylesheet = getClass ()
				.getResource ("Style.css")
				.toExternalForm ();
				scene.getStylesheets ().add(stylesheet);
		primaryStage.setTitle (" Welcome  to  JavaFX !");
		primaryStage.setScene ( scene );
		primaryStage.sizeToScene ();
		primaryStage.show ();

	}
	
	

}
