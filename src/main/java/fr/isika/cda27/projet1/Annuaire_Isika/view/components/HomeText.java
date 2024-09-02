package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import fr.isika.cda27.projet1.Annuaire_Isika.model.Tree;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

/**
 * Classe représentant une vue de la page d'accueil de l'annuaire. Cette vue
 * affiche un titre, une description et un bouton pour accéder à l'annuaire.
 */
public class HomeText extends VBox {

	private Scene scene;
	CustomButton btnDirectory;
	Tree tree;

	/**
	 * Constructeur pour initialiser la vue de la page d'accueil.
	 * 
	 * @param scene La scène dans laquelle cette vue sera affichée.
	 */
	public HomeText(Scene scene, Tree tree) {
		super();
		this.scene = scene;
		this.tree = tree;
		
		this.setAlignment(Pos.CENTER);

		// Création du label pour le titre
		Label titleLabel = new Label("Annuaire");
		titleLabel.setFont(Font.font("Futura", FontWeight.BOLD, 40));
		titleLabel.setPadding(new Insets(0, 0, 20, 0));

		// Création du label pour la description
		Label descriptionLabel = new Label(
				"Dans cet annuaire, retrouvez tous les stagiaires ayant bénéficié d’une formation chez ISIKA.");
		descriptionLabel.setFont(Font.font("Futura", 17));
		descriptionLabel.setTextAlignment(TextAlignment.CENTER);
		descriptionLabel.setWrapText(true);
		descriptionLabel.setMaxWidth(300);
		descriptionLabel.setPadding(new Insets(0, 0, 20, 0));
		descriptionLabel.setAlignment(Pos.CENTER);
		descriptionLabel.setMaxWidth(Double.MAX_VALUE);

		// Création du bouton pour accéder à l'annuaire
		btnDirectory = new CustomButton(scene, this.tree);
		btnDirectory.goToDirectory();

		// Ajout des éléments à la vue
		this.getChildren().addAll(titleLabel, descriptionLabel, btnDirectory);

	}
}
