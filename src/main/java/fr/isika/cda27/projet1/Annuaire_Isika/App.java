package fr.isika.cda27.projet1.Annuaire_Isika;

import java.io.IOException;

import fr.isika.cda27.projet1.Annuaire_Isika.model.ReaderInitialText;
import fr.isika.cda27.projet1.Annuaire_Isika.model.TreeDAO;
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

	public void init() {
//		 initialisation données
		ReaderInitialText reader = new ReaderInitialText();
		try {
			reader.readInitialText("src/main/resources/testAnnuaireText.txt");
		} catch (IOException e) {

			e.printStackTrace();
		}
		TreeDAO.setAlphaList();



	}

	@Override
	public void start(Stage stage) {

		stage.getIcons().add(new Image(getClass().getResourceAsStream("/Images/isika.png")));
		Scene scene = new Scene(new Pane(), 800, 600);

		AdminDirectoryView adminDirectoryView = new AdminDirectoryView(scene);
//		UserDirectoryView userDirectoryView = new UserDirectoryView(scene);
//		HomeViewAdmin adminHome = new HomeViewAdmin(scene);
//		HomeView home = new HomeView(scene);
//		AddStudentView addStudent = new AddStudentView(scene);
		AdminDirectoryView adminListView = new AdminDirectoryView(scene);

		stage.setScene(scene);
		stage.show();
		scene.getRoot().setStyle("-fx-font-family: 'Futura'");

	}

	public static void main(String[] args) {
		launch();
	}

}