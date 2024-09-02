package fr.isika.cda27.projet1.Annuaire_Isika;

import java.io.IOException;

import fr.isika.cda27.projet1.Annuaire_Isika.model.ReaderInitialText;
import fr.isika.cda27.projet1.Annuaire_Isika.model.Tree;
import fr.isika.cda27.projet1.Annuaire_Isika.view.HomeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Classe principale de l'application JavaFX.
 * Cette application est un annuaire informatisé pour les étudiants de l'ISIKA.
 * 
 * La classe App hérite de la classe Application de JavaFX et implémente les méthodes init(), start(), et main().
 * 
 * La méthode init() est appelée une seule fois avant la méthode start().
 * Elle est utilisée pour initialiser les données nécessaires à l'application,
 * notamment la construction de l'arbre de données pour l'annuaire.
 * 
 * La méthode start() est appelée une fois que la fenêtre de l'application est prête à être affichée.
 * Elle crée et affiche la scène principale de l'application,
 * avec une vue d'accueil par défaut.
 * 
 * La méthode main() est le point d'entrée de l'application.
 * Elle lance l'application en appelant la méthode launch() de la classe Application.
 * 
 * La classe App utilise également des classes de modèle, de vue et de contrôle pour gérer les différentes fonctionnalités de l'application.
 * 
 * @author groupe1
 * @version 1.0
 */
public class App extends Application {

    // Déclaration de l'arbre de données pour l'annuaire
	Tree tree;
	
	// Méthode appelée une seule fois avant la méthode start()
	@Override
	public void init() {		
		// Initialisation des données
		this.tree = new Tree();
		ReaderInitialText reader = new ReaderInitialText();
		try {
            // Lecture du fichier texte initial et remplissage de l'arbre de données
			reader.readInitialText("src/main/resources/STAGIAIRES.DON", this.tree);
		} catch (IOException e) {
            // Gestion des exceptions d'entrée/sortie
			e.printStackTrace();
		}
	}

    // Méthode appelée une fois que la fenêtre de l'application est prête à être affichée
	@Override
	public void start(Stage stage) {
		stage.setTitle("Annuaire informatisé ISIKA");
		stage.getIcons().add(new Image(getClass().getResourceAsStream("/Images/isika.png")));
		Scene scene = new Scene(new Pane(), 800, 600);

        // Création et affichage de la vue d'accueil
		HomeView home = new HomeView(scene, tree);

		stage.setScene(scene);
		stage.show();
		scene.getRoot().setStyle("-fx-font-family: 'Futura'");
	}

    // Point d'entrée de l'application
	public static void main(String[] args) {
		launch();
	}
}