package fr.ece.bernoux.lab5JavaFX.Exercice3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class Model {
	private final ObservableList<Majeur> majeurs;
	private final ObservableList<PieChart.Data> pieChartData;

	public Model() {
		super();
		this.majeurs = FXCollections.observableArrayList();
		this.pieChartData = FXCollections.observableArrayList();
		
		this.addMajeur("Système d'information", 150);
		this.addMajeur("Système embarqué", 120);
		this.addMajeur("Finance", 100);
		this.addMajeur("Santé", 70);
	}

	public ObservableList<Majeur> getMajeurs() {
		return majeurs;
	}

	public ObservableList<PieChart.Data> getPieChartData() {
		return pieChartData;
	}
	
	public void addMajeur(String name,int value){
		majeurs.add(new Majeur(name, value));
		pieChartData.add(new PieChart.Data(name, value));
	}
}
