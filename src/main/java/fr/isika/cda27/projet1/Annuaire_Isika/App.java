package fr.isika.cda27.projet1.Annuaire_Isika;


import fr.isika.cda27.projet1.Annuaire_Isika.model.ReaderInitialText;
import fr.isika.cda27.projet1.Annuaire_Isika.view.HomeView;
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
    	
        var label = new Label("Hello, ISIKA ");
        var scene = new Scene(new StackPane(label), 640, 480);
        
        HomeView home = new HomeView(scene);
        
        stage.setScene(scene);
        stage.show();
		scene.getRoot().setStyle("-fx-font-family: 'Helvetica'");
		
    }
    
    
    public static void main(String[] args) {
        launch();
    }

}