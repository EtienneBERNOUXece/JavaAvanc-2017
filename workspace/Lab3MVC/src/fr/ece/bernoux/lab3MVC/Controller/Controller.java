package fr.ece.bernoux.lab3MVC.Controller;

import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.text.JTextComponent;

import fr.ece.bernoux.lab3MVC.Model.UserList;
import fr.ece.bernoux.lab3MVC.View.View;

public class Controller implements GUIListener {
	//We useUserList as Model because our program need to word for a specific data Structure
	private final UserList userList;
	//We use a general view because we can imagine that different view can be executed for this program.
	private  Set<View> views;
	
	public Controller(UserList userList, HashSet<View> views) {
		super();
		this.userList = userList;
		this.views = views;
	}
	void start(){
		//For each view
		for (View view : views) {
			//The controller need to be set
			view.setController(this);
			view.start();
			userList.addObserver(view);	
		}
	}

	@Override
	public ActionListener getAddUserListener(JTextComponent textComponent) {
		return new AddUserListener(textComponent,userList);
	}
	public Set<View> getViews() {
		return views;
	}

	public UserList getModel() {
		return userList;
	}

	
}
