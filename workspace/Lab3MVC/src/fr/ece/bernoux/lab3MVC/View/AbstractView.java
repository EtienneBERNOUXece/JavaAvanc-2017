package fr.ece.bernoux.lab3MVC.View;

import fr.ece.bernoux.lab3MVC.Controller.GUIListener;
import fr.ece.bernoux.lab3MVC.Model.Model;

public abstract class AbstractView implements View {
	//Final because it will not change
	private GUIListener controller;
	private Model model;
	
	
	public AbstractView(Model model) {
		super();
		this.model = model;
	}

/**
 * This method is declare in protected final because only this class or children can getModel.
 * It protects the MVC structure
 */

	protected final Model getModel (){
		return this.model;
	}

	protected final GUIListener getController() {
		return this.controller;
	}
	
	@Override
	public void setController(GUIListener controller) {
		this.controller = controller;

	}
	
}
