package fr.isika.cda27.projet1.Annuaire_Isika.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HomeText extends VBox {

	String title;
	String description;
	
	public HomeText(String title, String description) {
		super();
		this.title = title;
		this.description = description;
		
		Label titleLabel = new Label(this.title);
		titleLabel.setFont(Font.font("Futura", FontWeight.BOLD, 36));
		
		Label descriptionLabel = new Label(this.description);
		descriptionLabel.setFont(Font.font("Futura", 16));
		descriptionLabel.setWrapText(true);
		descriptionLabel.setMaxWidth(300);
		
		Button btn = new Button ("Accéder à l'annuaire");
		btn.setStyle("-fx-background-color: #144d65; -fx-padding: 10 20; -fx-text-fill: white;");
		
		this.getChildren().addAll(titleLabel, descriptionLabel, btn);
		
	}
	
	
	
	
}
