package fr.isika.cda27.projet1.Annuaire_Isika.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HomeText extends VBox {

	public HomeText() {
		super();

		this.setAlignment(Pos.CENTER);
//		this.setPadding(new Insets(20));

		Label titleLabel = new Label("Annuaire");
		titleLabel.setFont(Font.font("Futura", FontWeight.BOLD, 40));
		titleLabel.setPadding(new Insets(0, 0, 50, 0));

		Label descriptionLabel = new Label(
				"Dans cet annuaire, retrouvez tous les stagiaires ayant bénéficié d’une formation chez ISIKA.");
		descriptionLabel.setFont(Font.font("Futura", 16));
		descriptionLabel.setWrapText(true);
		descriptionLabel.setMaxWidth(300);
		descriptionLabel.setPadding(new Insets(0, 0, 50, 0));

		Button btn = new Button("Accéder à l'annuaire");
		btn.setStyle("-fx-background-color: #144d65; -fx-padding: 10 20; -fx-text-fill: white;");
		btn.setPrefWidth(200);

		this.getChildren().addAll(titleLabel, descriptionLabel, btn);

	}

}
