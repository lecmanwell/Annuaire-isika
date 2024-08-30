package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class HomeText extends VBox {
	
	private Scene scene;
	CustomButton btnDirectory;

	public HomeText(Scene scene) {
		super();
		this.scene = scene;
		this.setAlignment(Pos.CENTER);
//		this.setPadding(new Insets(20));

		Label titleLabel = new Label("Annuaire");
		titleLabel.setFont(Font.font("Futura", FontWeight.BOLD, 40));
		titleLabel.setPadding(new Insets(0, 0, 20, 0));

		Label descriptionLabel = new Label(
				"Dans cet annuaire, retrouvez tous les stagiaires ayant bénéficié d’une formation chez ISIKA.");
		descriptionLabel.setFont(Font.font("Futura", 17));
		descriptionLabel.setTextAlignment(TextAlignment.CENTER);
		descriptionLabel.setWrapText(true);
		descriptionLabel.setMaxWidth(300);
		descriptionLabel.setPadding(new Insets(0, 0, 20, 0));
		descriptionLabel.setAlignment(Pos.CENTER);
		descriptionLabel.setMaxWidth(Double.MAX_VALUE);

		btnDirectory = new CustomButton(scene);
		btnDirectory.goToDirectory();
		
		
//		CustomButton btn = new CustomButton(scene);
//		Button btn1 = btn.goToDirectory();


		this.getChildren().addAll(titleLabel, descriptionLabel, btnDirectory);

	}

}
