package fr.ece.bernoux.lab5JavaFX.Exercice3;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
	Model model;
	
	@FXML
	private PieChart pieChart;
	@FXML
	private TableView<Majeur> tableView;
	@FXML
	private TableColumn<Majeur, String> tableColumnName;
	@FXML
	private TableColumn<Majeur, Integer> tableColumnValue;
	@FXML
	private  TextField textFieldName;
	@FXML
	private  TextField textFieldValue;
	@FXML
	private Button submit;
	
	
	@FXML
	public void initialize() {
		model = new Model();
		
		pieChart.setData(model.getPieChartData());
		tableColumnName.setCellValueFactory(new PropertyValueFactory<Majeur, String>("name"));
		tableColumnValue.setCellValueFactory(new PropertyValueFactory<Majeur,Integer>("number"));
		tableView.setItems(model.getMajeurs());			
	}
	
	@FXML
	public void addMajorOnSubmit(){
		String name = this.textFieldName.getText();
		int value = Integer.parseInt(this.textFieldValue.getText());
		
		this.model.addMajeur(name, value);
		System.out.println(name+""+value);
		
		this.textFieldName.clear();
		this.textFieldValue.clear();
				
	}

}
