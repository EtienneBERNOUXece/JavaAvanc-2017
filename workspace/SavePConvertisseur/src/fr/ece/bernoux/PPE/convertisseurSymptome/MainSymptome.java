package fr.ece.bernoux.PPE.convertisseurSymptome;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import fr.ece.bernoux.PPE.convertisseurReponses.MainReponse;
import fr.ece.bernoux.PPE.convertisseurReponses.QuestionReponse;
import fr.ece.bernoux.PPE.convertisseurReponses.Reponse;

public class MainSymptome {

	public static String getIntitule(ArrayList<Reponse> myreponses, int question_id, int valeur) {

		for (Reponse reponse : myreponses) {
			if (reponse.question_id == question_id && reponse.valeur == valeur) {
				return reponse.intitule;
			}
		}
		return "";
	}

	public static int getIdReponse(ArrayList<Reponse> myreponses, int question_id, int valeur) {

		for (Reponse reponse : myreponses) {
			if (reponse.question_id == question_id && reponse.valeur == valeur) {
				return reponse.id_reponse;
			}
		}
		return -1;
	}

	public static String getTitre(String symptome, ArrayList<Reponse> myreponses) {
		String titre = "";
		//System.out.println(symptome);
		String[] lines = symptome.split(" ");
		for (int l = 0; l < lines.length; l++) {
			String line = lines[l].replaceAll("[()]+", "");
			//System.out.println(line);
			String[] words = line.split("-");

			titre += getIntitule(myreponses, Integer.parseInt(words[0]), Integer.parseInt(words[1])) + " ";
		}
		// System.out.println(titre);

		return titre;

	}

	public static void convertS(File Symptome, File SymptomeSQL, ArrayList<Reponse> myreponses) {
		FileWriter fw;
		FileReader fr;
		ArrayList<Symptome> mySymptomes = new ArrayList<>();
		ArrayList<ReponseSymptome> myReponseSymptomes = new ArrayList<>();
		String str = "";
		try {
			fr = new FileReader(Symptome);
			int i = 0;
			// Lecture des donn�es
			while ((i = fr.read()) != -1)
				str += (char) i;
			// Affichage
			// System.out.println(str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// int i=0;

		String[] clusters = str.split("}");
		int nbcluster = 0;
		int nbsymptome = 0;
		for (int i = 0; i < clusters.length; i++) {
			String cluster = clusters[i];
			// System.out.println(cluster);
			String[] parts = cluster.split("[{]");
			for (int j = 0; j < parts.length; j++) {
				String part = parts[j];
				if (j % 2 == 0) {
					part = part.replaceAll("[\r\n]+", "");
					nbcluster = Integer.parseInt(part);
				} else {
					// System.out.println(nbcluster+"\n");
					String[] symptomes = part.split("\n");

					for (int k = 0; k < symptomes.length; k++) {
						String symptome = symptomes[k].replaceAll("[\r\n]+", "");

						// System.out.println("\n");
						if (!symptome.equals("")) {
							nbsymptome++;
							mySymptomes.add(new Symptome(nbsymptome, getTitre(symptome, myreponses), nbcluster));
							String[] lines = symptome.split(" ");
							for (int l = 0; l < lines.length; l++) {
								String line = lines[l].replaceAll("[()]+", "");
								//System.out.println(line);
								String[] words = line.split("-");
								myReponseSymptomes.add(new ReponseSymptome(nbsymptome,getIdReponse(myreponses, Integer.parseInt(words[0]), Integer.parseInt(words[1]))));

							}

						}
					}
				}
			}
		}
		for (Symptome symptomes : mySymptomes) {
			System.out.println(symptomes.toString());
		}
		for (ReponseSymptome reponseSymptome : myReponseSymptomes) {
			System.out.println(reponseSymptome.toString());
		}

		
		String sql ="\n-- Symptomes --\n";
		sql +="INSERT INTO `saveplus_beta`.`symptomes`";
		sql +="(`id_symptome`,";
		sql +="`titre`,";
		sql +="`cluster`)";
		sql +="VALUES\n";
		 for (Symptome mySymptome : mySymptomes){ 
			 sql += "(" +mySymptome.id_symptome + "," + "\"" + mySymptome.titre + "\","+mySymptome.cluster +")"; 
			 if(mySymptomes.indexOf(mySymptome) != mySymptomes.size() - 1) { 
				 sql +=",\n"; 
				 } else { 
					 sql += ";\n"; 
				 }
		 }
		 sql += "\n-- Reponses_Symptomes --\n\n";
		 sql +="INSERT INTO `Reponses_Symptomes` (`Symptome_id`, `Reponse_id`)\n";
		 sql += "VALUES";
		 
		 for (ReponseSymptome myReponseSymptome : myReponseSymptomes){
			 sql +="(" + myReponseSymptome.symptome_id + ","+myReponseSymptome.reponse_id + ")";
			 if(myReponseSymptomes.indexOf(myReponseSymptome) != myReponseSymptomes.size()- 1){
				 sql += ",\n";
			 }
			 else{
				 sql += ";\n";
			 }
		 }
		 
		 System.out.println(sql);
		 try { 
			 // Cr�ation de l'objet 
			 fw = new FileWriter(SymptomeSQL); 
			 // On �crit la cha�ne 
			 fw.write(sql); 
			 // On ferme le flux 
			 fw.close(); 
			 } 
		 catch (FileNotFoundException e) {
			 e.printStackTrace(); 
			 } 
		 catch (IOException e) { e.printStackTrace(); }
		 

	}

	public static void main(String[] args) {
		File Symptome = new File("src/fichier/Symptomes.txt");
		File SymptomeSQL = new File("src/fichier/Symptomes.sql");
		File reponse = new File("src/fichier/reponses.txt");
		ArrayList<Reponse> myreponses = new ArrayList<>();
		ArrayList<QuestionReponse> myquestionReponses = new ArrayList<>();
		MainReponse.createReponse(reponse, myreponses, myquestionReponses);
		convertS(Symptome, SymptomeSQL, myreponses);

	}
}
