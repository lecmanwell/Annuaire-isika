package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import javafx.scene.control.Button;

public class CustomButton extends Button {

	public CustomButton() {
		super();

	}

	public CustomButton generateDocumentation() {
		CustomButton btn = new CustomButton();
		btn.setText("Comment fonction cet annuaire ?");
		btn.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
		return btn;

	}

	public CustomButton adminAccess() {
		CustomButton btn = new CustomButton();
		btn.setText("Accès administrateur");
		btn.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
		return btn;

	}

	public CustomButton adminAccessTitle() {
		CustomButton btn = new CustomButton();
		btn.setText("Administrateur");
		return btn;

	}

	public CustomButton goToDirectory() {
		CustomButton btn = new CustomButton();
		btn.setText("Accéder à l'annuaire");
		btn.setStyle("-fx-background-color: #144d65; -fx-text-fill: white;");
		return btn;

	}

	public CustomButton goToDirectoryTitle() {
		CustomButton btn = new CustomButton();
		btn.setText("Annuaire");
		return btn;

	}

	public CustomButton printDirectory() {
		CustomButton btn = new CustomButton();
		btn.setText("Imprimer le PDF");
		btn.setStyle("-fx-background-color: #144d65; -fx-text-fill: white;");
		return btn;

	}

	public CustomButton homeButtonTitle() {
		CustomButton btn = new CustomButton();
		btn.setText("Accueil");
		return btn;
	}

	public CustomButton logOut() {
		CustomButton btn = new CustomButton();
		btn.setText("Deconnexion");
		btn.setStyle("-fx-background-color: transparent; -fx-text-fill: black; -fx-border-color: #db754a;");
		return btn;

	}

	public CustomButton modifyStudent() {
		CustomButton btn = new CustomButton();
		btn.setText("Modifier");
		return btn;

	}

	public CustomButton deleteStudent() {
		CustomButton btn = new CustomButton();
		btn.setText("Supprimer");
		return btn;

	}

	public CustomButton addStudent() {
		CustomButton btn = new CustomButton();
		btn.setText("Ajouter un stagiaire");
		btn.setStyle("-fx-background-color: #144d65; -fx-text-fill: white;");

		return btn;

	}

	public CustomButton back() {
		CustomButton btn = new CustomButton();
		btn.setText("Retour");
		btn.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");

		return btn;

	}

}
