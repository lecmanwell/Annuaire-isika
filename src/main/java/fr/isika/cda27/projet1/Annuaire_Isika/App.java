package fr.isika.cda27.projet1.Annuaire_Isika;

import java.io.IOException;

import fr.isika.cda27.projet1.Annuaire_Isika.model.ReaderInitialText;
import fr.isika.cda27.projet1.Annuaire_Isika.model.Tree;
import fr.isika.cda27.projet1.Annuaire_Isika.view.AddStudentView;
import fr.isika.cda27.projet1.Annuaire_Isika.view.AdminDirectoryView;
import fr.isika.cda27.projet1.Annuaire_Isika.view.HomeView;
import fr.isika.cda27.projet1.Annuaire_Isika.view.HomeViewAdmin;
import fr.isika.cda27.projet1.Annuaire_Isika.view.UserDirectoryView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
/**
 * JavaFX App
 */
public class App extends Application {

	Tree tree;
	
	public void init() {
//		 initialisation données
		
		this.tree = new Tree();
		ReaderInitialText reader = new ReaderInitialText();
		try {
			reader.readInitialText("src/main/resources/STAGIAIRES.DON", this.tree);
		} catch (IOException e) {

			e.printStackTrace();
		}


	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Annuaire informatisé ISIKA");
		stage.getIcons().add(new Image(getClass().getResourceAsStream("/Images/isika.png")));
		Scene scene = new Scene(new Pane(), 800, 600);

		HomeView home = new HomeView(scene, tree);


		stage.setScene(scene);
		stage.show();
		scene.getRoot().setStyle("-fx-font-family: 'Futura'");

	}

	public static void main(String[] args) {
		launch();
	}

}