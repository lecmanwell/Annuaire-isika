package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import fr.isika.cda27.projet1.Annuaire_Isika.view.HomeView;
import fr.isika.cda27.projet1.Annuaire_Isika.view.UserDirectoryView;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CustomButton extends Button {

	Scene scene;

	public CustomButton(Scene scene) {
		super();
		this.scene = scene;

	}

	public CustomButton generateDocumentation() {
		CustomButton btn = new CustomButton(this.scene);
		btn.setText("Comment fonction cet annuaire ?");
		btn.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
		return btn;

	}

	public CustomButton adminAccess() {
		CustomButton btn = new CustomButton(this.scene);
		btn.setText("Accès administrateur");
		btn.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
		return btn;

	}

	public CustomButton goToDirectory() {
		CustomButton btn = new CustomButton(this.scene);
		btn.setText("Accéder à l'annuaire");
		btn.setStyle("-fx-background-color: #144d65; -fx-text-fill: white;");
		
		// go to page action
		btn.setOnAction((e) -> {
			scene.setRoot(new UserDirectoryView(scene));
		});
		return btn;

	}

	public CustomButton printDirectory() {
		CustomButton btn = new CustomButton(this.scene);
		btn.setText("Imprimer le PDF");
		btn.setStyle("-fx-background-color: #144d65; -fx-text-fill: white;");
		return btn;

	}

	public CustomButton logOut() {
		CustomButton btn = new CustomButton(this.scene);
		btn.setText("Deconnexion");
		btn.setStyle("-fx-background-color: transparent; -fx-text-fill: black; -fx-border-color: #db754a;");
		return btn;

	}

	public CustomButton modifyStudent() {
		CustomButton btn = new CustomButton(this.scene);
		btn.setText("Modifier");
		return btn;

	}

	public CustomButton deleteStudent() {
		CustomButton btn = new CustomButton(this.scene);
		btn.setText("Supprimer");
		return btn;

	}

	public CustomButton addStudent() {
		CustomButton btn = new CustomButton(this.scene);
		btn.setText("Ajouter un stagiaire");
		btn.setStyle("-fx-background-color: #144d65; -fx-text-fill: white;");

		return btn;

	}

	public CustomButton back() {
		CustomButton btn = new CustomButton(this.scene);
		btn.setText("Retour");
		btn.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");

		return btn;

	}

	// Buttons for the menu in HeaderViewGeneral
	public CustomButton homeButtonTitle() {
		CustomButton btn = new CustomButton(this.scene);
		btn.setText("Accueil");
		btn.setStyle("-fx-background-color: transparent;");
		btn.setFont(Font.font("Futura", FontWeight.BOLD, 14));

		// hover effect
		btn.setOnMouseEntered((e) -> {
			btn.setTextFill(Color.web("#adb6b6"));
		});
		btn.setOnMouseExited((e) -> {
			btn.setTextFill(Color.web("#333333"));
		});

		// go to page action
		btn.setOnAction((e) -> {
			scene.setRoot(new HomeView(scene));
		});
		return btn;
	}

	public CustomButton goToDirectoryTitle() {
		CustomButton btn = new CustomButton(this.scene);
		btn.setText("Annuaire");
		btn.setStyle("-fx-background-color: transparent;");
		btn.setFont(Font.font("Futura", FontWeight.BOLD, 14));

		// hover effect
		btn.setOnMouseEntered((e) -> {
			btn.setTextFill(Color.web("#adb6b6"));
		});
		btn.setOnMouseExited((e) -> {
			btn.setTextFill(Color.web("#333333"));
		});

		// go to page action
		btn.setOnAction((e) -> {
			scene.setRoot(new UserDirectoryView(scene));
		});
		return btn;

	}

	public CustomButton adminAccessTitle() {
		CustomButton btn = new CustomButton(this.scene);
		btn.setText("Administrateur");
		btn.setStyle("-fx-background-color: transparent;");
		btn.setFont(Font.font("Futura", FontWeight.BOLD, 14));

		// hover effect
		btn.setOnMouseEntered((e) -> {
			btn.setTextFill(Color.web("#adb6b6"));
		});
		btn.setOnMouseExited((e) -> {
			btn.setTextFill(Color.web("#333333"));
		});

		// go to page action. IT NEEDS TO BE FILLED WITH THE SCENE OF THE
		// ADMINDIRECTORYVIEW
//		btn.setOnAction((e) -> {
//			scene.setRoot(new ----------(scene));
//		});
		return btn;

	}

}
