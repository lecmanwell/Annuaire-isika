package fr.isika.cda27.projet1.Annuaire_Isika.view;

import java.awt.TextField;

import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;

public class MultiSearch extends GridPane{

	
	public MultiSearch() {
		super();
		
		TextField lastNameField = new TextField();
		lastNameField.setText("Nom");
		TextField firstNameField = new TextField();
		firstNameField.setText("Prénom");
		ChoiceBox<String> formationChoiceBox = new ChoiceBox<String>();
		
        
	}
	

	
	


}
