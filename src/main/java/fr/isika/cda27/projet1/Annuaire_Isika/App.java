package fr.isika.cda27.projet1.Annuaire_Isika;

import fr.isika.cda27.projet1.Annuaire_Isika.model.ReaderInitialText;
import fr.isika.cda27.projet1.Annuaire_Isika.view.AddStudentView;
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

	public void init() {
		// initialisation données
		ReaderInitialText reader = new ReaderInitialText();
		reader.readInitialText("src/main/resources/testAnnuaireText.txt");

	}

	@Override
	public void start(Stage stage) {

		stage.setMaximized(true);
		stage.getIcons().add(new Image(getClass().getResourceAsStream("/Images/isika.png")));
		Scene scene = new Scene(new Pane(), stage.getMaxWidth(), stage.getMaxHeight());

//		UserDirectoryView userDirectoryView = new UserDirectoryView(scene);
//		HomeViewAdmin adminHome = new HomeViewAdmin(scene);
//		HomeView home = new HomeView(scene);
		AddStudentView addStudent = new AddStudentView(scene);

		stage.setScene(scene);
		stage.show();
		scene.getRoot().setStyle("-fx-font-family: 'Futura'");

	}

	public static void main(String[] args) {
		launch();
	}

}