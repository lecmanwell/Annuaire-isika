package fr.isika.cda27.projet1.Annuaire_Isika.view;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class MultiSearch extends GridPane {

	public MultiSearch() {
		super();

		TextField lastNameField = new TextField();
		lastNameField.setText("Nom");
		TextField firstNameField = new TextField();
		firstNameField.setText("Prénom");
		ComboBox<String> formationComboBox = new ComboBox<String>();
		formationComboBox.setPromptText("Formation");
		ComboBox<String> anneeFormationComboBox = new ComboBox<String>();
		anneeFormationComboBox.setPromptText("Année de formation");
		ComboBox<String> departementChoiceBox = new ComboBox<String>();
		departementChoiceBox.setPromptText("Département");

		this.add(lastNameField, 0, 0);
		this.add(firstNameField, 1, 0);
		this.add(formationComboBox, 0, 1);
		this.add(anneeFormationComboBox, 1, 1);
		this.add(departementChoiceBox, 2, 1);

	}

}
