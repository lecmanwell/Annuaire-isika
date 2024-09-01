package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import fr.isika.cda27.projet1.Annuaire_Isika.model.TreeDAO;
import fr.isika.cda27.projet1.Annuaire_Isika.view.AdminDirectoryView;
import fr.isika.cda27.projet1.Annuaire_Isika.view.HomeView;
import fr.isika.cda27.projet1.Annuaire_Isika.view.login.Admin;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Représente une vue de connexion pour les administrateurs. Cette classe
 * affiche une interface utilisateur permettant à un administrateur de se
 * connecter en entrant un identifiant et un mot de passe. Si les informations
 * sont correctes, l'administrateur est redirigé vers la vue de l'annuaire
 * administrateur. Sinon, un message d'erreur est affiché.
 */

public class LoginAdmin extends VBox {

	Scene scene;
	TreeDAO tree;

	/**
	 * Construit une instance de LoginAdmin avec la scène spécifiée.
	 *
	 * @param scene La scène dans laquelle ce composant sera utilisé.
	 */
	public LoginAdmin(Scene scene, TreeDAO tree) {
		super();
		this.scene = scene;
		this.tree = tree;

		VBox loginVBox = new VBox(15);

		// Création du titre
		Label titleLbl = new Label("Accès administrateur");
		titleLbl.setFont(Font.font("Futura", FontWeight.BOLD, 36));

		// Création de la grille pour les composants de connexion
		GridPane gridLoginBox = new GridPane();
		Label userNameLbl = new Label("Identifiant");
		TextField userNameTextField = new TextField();
		Label passwordLbl = new Label("Mot de passe");
		PasswordField passwordField = new PasswordField();

		// Ajout des composants à la grille
		gridLoginBox.add(userNameLbl, 0, 0);
		gridLoginBox.add(userNameTextField, 1, 0);
		gridLoginBox.add(passwordLbl, 0, 1);
		gridLoginBox.add(passwordField, 1, 1);
		gridLoginBox.setHgap(15);
		gridLoginBox.setVgap(15);
		gridLoginBox.setAlignment(Pos.CENTER);

		// Création du bouton d'accès
		Button btnAccess = new Button("Accéder à l'annuaire");
		btnAccess.setStyle("-fx-background-color: #144d65; -fx-padding: 10 20; -fx-text-fill: white;");
		btnAccess.setDefaultButton(true);
		btnAccess.setOnAction((e) -> {
			Admin admin = new Admin();
			String usernameInput = userNameTextField.getText();
			String passwordInput = passwordField.getText();

			// Validation des informations d'identification et redirection
			if (Admin.validateAdmin(usernameInput, passwordInput)) {
				scene.setRoot(new AdminDirectoryView(scene, this.tree));
			} else {
				// Affichage d'un message d'erreur en cas d'identifiant ou mot de passe
				// incorrect
				titleLbl.setText("Identifiant ou mot de passe incorrect");
				titleLbl.setFont(Font.font("Futura", FontWeight.BOLD, 28));
			}

		});

		// Création de la boîte pour le bouton d'accès
		HBox btnAccessBox = new HBox();
		btnAccessBox.getChildren().add(btnAccess);
		btnAccessBox.setAlignment(Pos.CENTER);

		// Ajout de tous les éléments comme enfants du VBox principal
		loginVBox.getChildren().addAll(titleLbl, gridLoginBox, btnAccessBox);
		this.getChildren().add(loginVBox);

	}

}
