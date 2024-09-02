package fr.isika.cda27.projet1.Annuaire_Isika.view;

import fr.isika.cda27.projet1.Annuaire_Isika.model.TreeDAO;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.Footer;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.Header;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.HomeText;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.StudentCard;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * Vue principale de l'application, représentant la page d'accueil. Cette vue
 * affiche un en-tête, un corps avec une carte d'étudiant et du texte, ainsi
 * qu'un pied de page. Elle définit également le style de la scène.
 */

public class HomeView extends BorderPane {

	 public Scene scene;
	public TreeDAO tree;

	/**
	 * Constructeur de la classe.
	 * 
	 * @param scene La scène à laquelle cette vue est attachée.
	 */

	public HomeView(Scene scene, TreeDAO tree) {
		super();
		this.scene = scene;
		this.tree = tree;

		// Création de l'en-tête
		Header header = new Header(scene, tree);
		header.headerSimple();
		header.setAlignment(Pos.CENTER);

		// Création du corps avec une carte d'étudiant et du texte d'accueil
		GridPane body = new GridPane();
		body.setAlignment(Pos.CENTER);

		// Création d'une carte d'étudiant avec des informations fictives
		String imagePath = "/Images/imageCardHome.jpg";
		StudentCard studentCard = new StudentCard(imagePath, "Projet", "Isika", "Architecte Logiciel", "2024", "92");

		// Création du texte d'accueil
		HomeText homeText = new HomeText(this.scene, this.tree);
		homeText.setAlignment(Pos.CENTER);

		// Ajout des composants au GridPane
		body.add(studentCard, 1, 1);
		body.add(homeText, 2, 1);
		body.setPadding(new Insets(0, 50, 0, 50));
		body.setHgap(20);

		// Création du pied de page
		Footer footer = new Footer(scene, this.tree);
		footer.footerHomeView();

		// Configuration du BorderPane
		this.setTop(header);
		this.setBottom(footer);
		this.setCenter(body);

		// Définition de la racine de la scène
		scene.setRoot(this);
		scene.getRoot().setStyle("-fx-font-family: 'Futura'");
	}

}
