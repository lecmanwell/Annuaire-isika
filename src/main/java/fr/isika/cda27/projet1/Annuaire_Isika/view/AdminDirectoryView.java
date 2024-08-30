package fr.isika.cda27.projet1.Annuaire_Isika.view;

import fr.isika.cda27.projet1.Annuaire_Isika.model.TreeDAO;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.Footer;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.HeaderViewAdmin;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.HeaderViewGeneral;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.MultiSearch;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.StudentListAdmin;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.UserDirectory;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Vue pour l'annuaire administrateur. Cette vue affiche une liste de stagiaires
 * avec une barre de recherche et une zone de défilement. Elle configure
 * également l'en-tête, le pied de page et le style de la scène.
 */

public class AdminDirectoryView extends BorderPane {

	private Scene scene;
	TreeDAO tree;

	/**
	 * Constructeur de la classe.
	 *
	 * @param scene La scène à laquelle cette vue est attachée.
	 * @param tree  L'objet utilisé pour gérer les stagiaires.
	 */

	public AdminDirectoryView(Scene scene, TreeDAO tree) {
		super();
		this.scene = scene;
		this.tree = tree;

		// Création de l'en-tête
		HeaderViewAdmin header = new HeaderViewAdmin(scene, this.tree);

		// Création du conteneur central
		VBox body = new VBox();
		body.setPadding(new Insets(20, 20, 0, 20));

		// Création de la barre de recherche
		MultiSearch multiSearch = new MultiSearch(scene, this.tree);
		multiSearch.multiSearchUser();

		// Création de la liste des étudiants avec une zone de défilement
		StudentListAdmin userDirectory = new StudentListAdmin(scene, tree);
		ScrollPane scrollpane = new ScrollPane();
		userDirectory.setMinWidth(scrollpane.getWidth());
		scrollpane.setContent(userDirectory);
		scrollpane.setFitToWidth(true);
		scrollpane.setFitToHeight(true);
		scrollpane.setMinHeight(290);

		// Ajout des composants au conteneur central
		body.getChildren().addAll(multiSearch, scrollpane);

		// Création du pied de page
		Footer footer = new Footer(scene,this.tree, userDirectory);
		footer.footerAdminDirectoryView();

		// Configuration du BorderPane
		this.setTop(header);
		this.setBottom(footer);
		this.setCenter(body);

		// Définition de la racine de la scène et du style de la police
		scene.setRoot(this);
		scene.getRoot().setStyle("-fx-font-family: 'Futura'");

	}

}
