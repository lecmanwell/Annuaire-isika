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
	
	Scene scene;

	public MultiSearch(Scene scene) {
		super();
		this.scene=scene;

	}
	
	public void multiSearchUser() {
//		GridPane multisearchUser = new GridPane();
		
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
		
		this.add(lastNameField, 0, 0);
		this.add(firstNameField, 0, 1);
		this.add(formationComboBox, 1, 0);
		this.add(anneeFormationComboBox, 1, 1);
		this.add(departementChoiceBox, 2, 1);
		this.setHgap(70);
		this.setVgap(20);
		this.setPadding(new Insets(0, 0, 20, 5));
		this.setHeight(100);
		this.setMaxHeight(120);
//		return this;
	}

	public void multiSearchAdmin() {
//			GridPane multisearchAdmin = new GridPane();
			
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
			
			
			CustomButton btnGoToAddStudent = new CustomButton(scene);
			btnGoToAddStudent.goToAddStudent();
			
//			btn.setPrefHeight(200);
//			btn.setPrefWidth(300);
			
			this.add(lastNameField, 0, 0);
			this.add(firstNameField, 0, 1);
			this.add(formationComboBox, 1, 0);
			this.add(anneeFormationComboBox, 1, 1);
			this.add(departementChoiceBox, 2, 1);
			this.add(btnGoToAddStudent,  3, 1);
			this.setHgap(70);
			this.setVgap(20);
			this.setPadding(new Insets(0, 0, 20, 5));
//			return this;
	}
}
