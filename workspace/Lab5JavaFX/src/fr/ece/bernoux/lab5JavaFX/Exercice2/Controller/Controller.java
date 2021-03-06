package fr.ece.bernoux.lab5JavaFX.Exercice2.Controller;

import fr.ece.bernoux.lab5JavaFX.Exercice2.Model.User;
import fr.ece.bernoux.lab5JavaFX.Exercice2.Model.UserList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
	//We useUserList as Model because our program need to word for a specific data Structure
	private  UserList userList;
	
	@FXML
	private TextField textField;
	@FXML
	private TableView<User> tableView;
	@FXML
	private Button button;
	
	

	@FXML
	public void validateText ( ActionEvent event ) {
		System.out.println(textField.getText().toString());
		this.userList.addUser(new User(textField.getText().toString()));
		this.textField.clear();
	
	}

	@FXML
	public void initialize() {
		this.userList = new UserList(new User("Jacob"));
		
		
		TableColumn<User, String> firstNameCol = new TableColumn<User, String>("Name");
        firstNameCol.setMinWidth(350);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<User, String>("firstName"));
        
		this.tableView.setItems(userList.getUserList());
		this.tableView.getColumns().add(firstNameCol);
	}



	
}
