package fr.ece.bernoux.lab3MVC.Controller;

import java.util.Arrays;
import java.util.HashSet;

import fr.ece.bernoux.lab3MVC.Model.UserList;
import fr.ece.bernoux.lab3MVC.View.CLI;
import fr.ece.bernoux.lab3MVC.View.GUI;
import fr.ece.bernoux.lab3MVC.View.View;

public class Main2 {

	public static void main(String[] args) {
		//Creation of the model
		UserList model = new UserList();
		//Creation of the views
		GUI gui = new GUI(model, "Lab3", 320, 240);
		CLI cli = new CLI(model);
		HashSet<View> set = new HashSet<>(Arrays.asList(gui, cli));
		//Creation of the controller
		Controller controller = new Controller(model, set);
		controller.start();
		controller.getModel().addUser("etienne");
		controller.getModel().addUser("nicolas");
		controller.getModel().addUser("toto");

	}
}
