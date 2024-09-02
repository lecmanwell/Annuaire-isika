package fr.isika.cda27.projet1.Annuaire_Isika.view;

import fr.isika.cda27.projet1.Annuaire_Isika.model.TreeDAO;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.Footer;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.Header;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.HomeText;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.LoginAdmin;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.StudentCard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;


/**
 * Vue d'accueil pour l'administrateur.
 * Cette vue affiche une carte d'étudiant, un formulaire de connexion administrateur et un pied de page.
 * Elle configure également l'en-tête, le pied de page et le style de la scène.
 */
public class HomeViewAdmin extends BorderPane {

	private Scene scene;
	private TreeDAO tree;

	
    /**
     * Constructeur de la classe.
     *
     * @param scene La scène à laquelle cette vue est attachée.
     */
	public HomeViewAdmin(Scene scene, TreeDAO tree) {
		super();
		this.scene = scene;
		this.tree = tree;

		// Création de l'en-tête
		Header header = new Header(scene, tree);
		header.headerSimple();
		header.setAlignment(Pos.CENTER);

		// Création du conteneur principal
		GridPane body = new GridPane();
		body.setAlignment(Pos.CENTER);

		// Création de la carte d'étudiant
		String imagePath = "/Images/imageCardHome.jpg";
		StudentCard studentCard = new StudentCard(imagePath, "Projet", "Isika", "Architecte Logiciel", "2024", "92");

		// Création du formulaire de connexion administrateur
		LoginAdmin loginAdmin = new LoginAdmin(scene, this.tree);
		loginAdmin.setAlignment(Pos.CENTER);

		// Ajout des composants au conteneur principal
		body.add(studentCard, 1, 1);
		body.add(loginAdmin, 2, 1);
		body.setPadding(new Insets(0, 30, 0, 30));
		body.setHgap(20);

		// Création du pied de page
		Footer footer = new Footer(scene, this.tree);
		footer.footerHomeViewAdmin();
		
		// Configuration du BorderPane
		this.setTop(header);
		this.setBottom(footer);
		this.setCenter(body);

		// Définition de la racine de la scène et du style de la police
		scene.setRoot(this);
		scene.getRoot().setStyle("-fx-font-family: 'Futura'");

	}
}
