package fr.isika.cda27.projet1.Annuaire_Isika.view;

import fr.isika.cda27.projet1.Annuaire_Isika.model.TreeDAO;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.Footer;
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
 * Classe représentant la vue du répertoire des utilisateurs. Cette vue affiche
 * un en-tête, un espace de recherche et un répertoire des utilisateurs avec une
 * barre de défilement.
 */
public class UserDirectoryView extends BorderPane {

	private Scene scene;
	TreeDAO tree;

	/**
	 * Constructeur de la classe. Initialise la vue du répertoire des utilisateurs
	 * en créant l'en-tête, l'espace de recherche et le répertoire des utilisateurs.
	 *
	 * @param scene La scène à laquelle cette vue est attachée.
	 * @param tree  L'objet {@code TreeDAO} utilisé pour accéder aux données des
	 *              utilisateurs.
	 */
	public UserDirectoryView(Scene scene, TreeDAO tree) {
		super();
		this.scene = scene;
		this.tree = tree;

		// Création de l'en-tête général
		HeaderViewGeneral header = new HeaderViewGeneral(scene, this.tree);

		// Conteneur principal pour la page centrale
		VBox body = new VBox();
		body.setPadding(new Insets(20, 20, 0, 20));

		// Création de l'espace de recherche

		// Création du répertoire des utilisateurs avec une barre de défilement
		StudentListAdmin userDirectory = new StudentListAdmin(scene, this.tree, false);
		MultiSearch multiSearch = new MultiSearch(scene, this.tree);
		multiSearch.multiSearchUser(userDirectory);
		ScrollPane scrollpane = new ScrollPane();
		userDirectory.setMinWidth(scrollpane.getWidth());
		scrollpane.setContent(userDirectory);
		scrollpane.setFitToWidth(true);
		scrollpane.setFitToHeight(true);
		scrollpane.setMinHeight(290);

		// Ajout de l'espace de recherche et du répertoire des utilisateurs à la page
		// centrale
		body.getChildren().addAll(multiSearch, scrollpane);

		// Création du pied de page
		Footer footer = new Footer(scene, this.tree);
		footer.footerUserDirectoryView();

		// Configuration de la vue
		this.setTop(header);
		this.setBottom(footer);
		this.setCenter(body);

		// Définition de la racine de la scène et du style de la police
		scene.setRoot(this);
		scene.getRoot().setStyle("-fx-font-family: 'Futura'");

	}

}
