package fr.isika.cda27.projet1.Annuaire_Isika.view;

import fr.isika.cda27.projet1.Annuaire_Isika.model.TreeDAO;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.AddStudent;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.Footer;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.HeaderViewAdmin;
import fr.isika.cda27.projet1.Annuaire_Isika.view.components.HeaderViewGeneral;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

/**
 * Vue pour l'ajout d'un nouveau stagiaire.
 * Cette vue affiche un en-tête, un corps contenant le formulaire d'ajout de stagiaire, 
 * ainsi qu'un pied de page. Elle configure également le style de la scène.
 */

public class AddStudentView extends BorderPane {
	private Scene scene;
	private TreeDAO tree;

    /**
     * Constructeur de la classe.
     *
     * @param scene La scène à laquelle cette vue est attachée.
     * @param tree  L'objet {@code TreeDAO} utilisé pour gérer les stagiaires.
     */
	
	public AddStudentView(Scene scene, TreeDAO tree) {
		super();
		this.scene = scene;
		this.tree = tree;

		// Obtention des dimensions de l'écran
		double screenHeight = Screen.getPrimary().getBounds().getHeight();
		double screenWidth = Screen.getPrimary().getBounds().getWidth();

		// Création de l'en-tête
		HeaderViewAdmin header = new HeaderViewAdmin(scene);
		header.setPrefHeight(screenHeight * 0.15);
		header.setMinHeight(screenHeight * 0.15);
		header.setMaxHeight(screenHeight * 0.15);
		header.setPrefWidth(screenWidth);
		header.setAlignment(Pos.CENTER);

		// Création du conteneur du corps
		HBox body = new HBox();
		AddStudent addStudent = new AddStudent(tree);
		body.getChildren().add(addStudent);
		body.setAlignment(Pos.CENTER);

		 // Création du pied de page
		Footer footer = new Footer(scene);
		footer.footerAddStudentView();
		
		// Configuration du BorderPane
		this.setTop(header);
		this.setCenter(body);
		this.setBottom(footer);
		
		// Définition de la racine de la scène et du style de la police
		scene.setRoot(this);
		scene.getRoot().setStyle("-fx-font-family: 'Futura'");
	}

}
