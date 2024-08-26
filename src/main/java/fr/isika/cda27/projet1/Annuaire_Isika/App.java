package fr.isika.cda27.projet1.Annuaire_Isika;

import fr.isika.cda27.projet1.Annuaire_Isika.model.ReaderInitialText;
import fr.isika.cda27.projet1.Annuaire_Isika.view.HomeView;
import fr.isika.cda27.projet1.Annuaire_Isika.view.HomeViewAdmin;
import fr.isika.cda27.projet1.Annuaire_Isika.view.UserDirectoryView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	public void init() {
		// initialisation données
		ReaderInitialText reader = new ReaderInitialText();
		reader.readInitialText("src/main/resources/STAGIAIRES.don");

	}

	@Override
	public void start(Stage stage) {

		stage.setMaximized(true);
		stage.getIcons().add(new Image(getClass().getResourceAsStream("/Images/isika.png")));
		var label = new Label("Hello, ISIKA ");
		Scene scene = new Scene(new StackPane(label), stage.getMaxWidth(), stage.getMaxHeight());

		UserDirectoryView userDirectoryView = new UserDirectoryView(scene);
//		HomeViewAdmin adminHome = new HomeViewAdmin(scene);
//		HomeView home = new HomeView(scene);

		stage.setScene(scene);
		stage.show();
		scene.getRoot().setStyle("-fx-font-family: 'Helvetica'");

	}

	public static void main(String[] args) {
		launch();
	}

}