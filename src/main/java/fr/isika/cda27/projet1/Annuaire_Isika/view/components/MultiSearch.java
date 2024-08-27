package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class MultiSearch extends GridPane {

	public MultiSearch(Scene scene) {
		super();

	}
		public GridPane multiSearchUser() {
		GridPane multisearchUser = new GridPane();
		
		TextField lastNameField = new TextField("Nom");
		lastNameField.setPrefHeight(200);
		lastNameField.setPrefWidth(300);
			lastNameField.setOnMouseClicked(event -> {
	            	lastNameField.clear();
	        });

			lastNameField.focusedProperty().addListener((observable, oldValue, newValue) -> {
	            if (!newValue && lastNameField.getText().isEmpty()) {
	            	lastNameField.setText("Nom");
	            }
	        });
	
		
		TextField firstNameField = new TextField("Prénom");
		firstNameField.setPrefHeight(200);
		firstNameField.setPrefWidth(300);
			firstNameField.setOnMouseClicked(event -> {
            	firstNameField.clear();

        });

		firstNameField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue && firstNameField.getText().isEmpty()) {
            	firstNameField.setText("Prénom");
            }
        });
		
		
		
		ComboBox<String> formationComboBox = new ComboBox<String>();
		formationComboBox.setPromptText("Formation");
		formationComboBox.setPrefHeight(200);
		formationComboBox.setPrefWidth(300);
		
		ComboBox<String> anneeFormationComboBox = new ComboBox<String>();
		anneeFormationComboBox.setPromptText("Année de formation");
		anneeFormationComboBox.setPrefHeight(200);
		anneeFormationComboBox.setPrefWidth(300);
		
		ComboBox<String> departementChoiceBox = new ComboBox<String>();
		departementChoiceBox.setPromptText("Département");
		departementChoiceBox.setPrefHeight(200);
		departementChoiceBox.setPrefWidth(300);
		
		multisearchUser.add(lastNameField, 0, 0);
		multisearchUser.add(firstNameField, 0, 1);
		multisearchUser.add(formationComboBox, 1, 0);
		multisearchUser.add(anneeFormationComboBox, 1, 1);
		multisearchUser.add(departementChoiceBox, 2, 1);
		multisearchUser.setHgap(70);
		multisearchUser.setVgap(20);
		multisearchUser.setPadding(new Insets(0, 0, 20, 5));
		return multisearchUser;
	}

		public GridPane multiSearchAdmin() {
			GridPane multisearchAdmin = new GridPane();
			
			TextField lastNameField = new TextField("Nom");
			lastNameField.setPrefHeight(200);
			lastNameField.setPrefWidth(300);
				lastNameField.setOnMouseClicked(event -> {
		            	lastNameField.clear();
		        });

				lastNameField.focusedProperty().addListener((observable, oldValue, newValue) -> {
		            if (!newValue && lastNameField.getText().isEmpty()) {
		            	lastNameField.setText("Nom");
		            }
		        });
		
			
			TextField firstNameField = new TextField("Prénom");
			firstNameField.setPrefHeight(200);
			firstNameField.setPrefWidth(300);
				firstNameField.setOnMouseClicked(event -> {
	            	firstNameField.clear();

	        });

			firstNameField.focusedProperty().addListener((observable, oldValue, newValue) -> {
	            if (!newValue && firstNameField.getText().isEmpty()) {
	            	firstNameField.setText("Prénom");
	            }
	        });
			
			
			
			ComboBox<String> formationComboBox = new ComboBox<String>();
			formationComboBox.setPromptText("Formation");
			formationComboBox.setPrefHeight(200);
			formationComboBox.setPrefWidth(300);
			
			ComboBox<String> anneeFormationComboBox = new ComboBox<String>();
			anneeFormationComboBox.setPromptText("Année de formation");
			anneeFormationComboBox.setPrefHeight(200);
			anneeFormationComboBox.setPrefWidth(300);
			
			ComboBox<String> departementChoiceBox = new ComboBox<String>();
			departementChoiceBox.setPromptText("Département");
			departementChoiceBox.setPrefHeight(200);
			departementChoiceBox.setPrefWidth(300);
			
			Button btn = new Button("Ajouter un stagiaire");
			btn.setStyle("-fx-background-color: #144d65; -fx-padding: 10 20; -fx-text-fill: white;");
			btn.setPrefHeight(200);
			btn.setPrefWidth(300);
			
			multisearchAdmin.add(lastNameField, 0, 0);
			multisearchAdmin.add(firstNameField, 0, 1);
			multisearchAdmin.add(formationComboBox, 1, 0);
			multisearchAdmin.add(anneeFormationComboBox, 1, 1);
			multisearchAdmin.add(departementChoiceBox, 2, 1);
			multisearchAdmin.add(btn,  3, 1);
			multisearchAdmin.setHgap(70);
			multisearchAdmin.setVgap(20);
			multisearchAdmin.setPadding(new Insets(0, 0, 20, 5));
			return multisearchAdmin;
	}
}
