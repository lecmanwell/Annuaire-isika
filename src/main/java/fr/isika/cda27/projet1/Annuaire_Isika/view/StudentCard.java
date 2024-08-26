package fr.isika.cda27.projet1.Annuaire_Isika.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StudentCard extends GridPane {

	String imagePath;
	String lastNameString;
	String firstNameString;
	String formationString;
	String anneeFormationString;
	String localisationString;

	public StudentCard(String imagePath, String lastNameString, String firstNameString, String formationString,
			String anneeFormationString, String localisationString) {
		super();
		this.imagePath = imagePath;
		this.lastNameString = lastNameString;
		this.firstNameString = firstNameString;
		this.formationString = formationString;
		this.anneeFormationString = anneeFormationString;
		this.localisationString = localisationString;

		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(20));
		this.setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #ffffff;");

		// Parametrage photo
		ImageView photo = new ImageView(new Image(this.imagePath));
		photo.setFitHeight(150);
		photo.setFitWidth(150);
		photo.setStyle("-fx-border-color: black; -fx-border-radius: 15px;");

		// Parametrage du label Nom
		Label lastNameLabel = new Label(this.lastNameString);
		lastNameLabel.setFont(Font.font("Futura", FontWeight.BOLD, 18));

		// Parametrage du label Prénom
		Label firstNameLabel = new Label(this.firstNameString);
		firstNameLabel.setFont(Font.font("Futura", FontWeight.BOLD, 18));

		// Parametrage du label Formation
		Label formationLabel = new Label(this.formationString);
		formationLabel.setFont(Font.font("Futura", 14));

		// Parametrage du label Année de formation
		Label anneeFormationLabel = new Label(this.anneeFormationString);
		anneeFormationLabel.setFont(Font.font("Futura", 14));

		// Parametrage du label Departement
		Label localisationLabel = new Label("Département : " + this.localisationString);
		localisationLabel.setFont(Font.font("Futura", 14));

		this.add(photo, 1, 0, 3, 2);
		this.add(lastNameLabel, 1, 3);
		this.add(firstNameLabel, 2, 3);
		this.add(formationLabel, 1, 4);
		this.add(anneeFormationLabel, 2, 4);
		this.add(localisationLabel, 1, 5);
	}

}
