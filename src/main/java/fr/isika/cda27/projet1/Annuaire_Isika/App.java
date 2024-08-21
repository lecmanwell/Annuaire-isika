package fr.isika.cda27.projet1.Annuaire_Isika;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import fr.isika.cda27.projet1.Annuaire_Isika.model.ReaderInitialText;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

	public void init() {

	ReaderInitialText reader = new ReaderInitialText();
	reader.readInitialText("src/main/resources/testAnnuaireText.txt");
		
	}
    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, ISIKA " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
		scene.getRoot().setStyle("-fx-font-family: 'Helvetica'");
    }

    public static void main(String[] args) {
        launch();
    }

}