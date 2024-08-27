package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class MultiSearch extends GridPane {

	public MultiSearch(Scene scene) {
		super();
	}
		public GridPane multiSearchUser() {
		GridPane multisearchUser = new GridPane();
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
		multisearchUser.add(lastNameField, 0, 0);
		multisearchUser.add(firstNameField, 1, 0);
		multisearchUser.add(formationComboBox, 0, 1);
		multisearchUser.add(anneeFormationComboBox, 1, 1);
		multisearchUser.add(departementChoiceBox, 2, 1);
		return multisearchUser;
	}

		public GridPane multiSearchAdmin() {
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
		Button addStudent = new Button("Ajouter un stagiaire à l'annuaire");

		this.add(lastNameField, 0, 0);
		this.add(firstNameField, 1, 0);
		this.add(formationComboBox, 0, 1);
		this.add(anneeFormationComboBox, 1, 1);
		this.add(departementChoiceBox, 2, 1);
		this.add(addStudent, 3, 1);
		
		return this;
	}
}
