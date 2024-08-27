package fr.isika.cda27.projet1.Annuaire_Isika.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StudentCard extends GridPane {

	String imagePath;
	String lastNameString;
	String firstNameString;
	String formationString;
	String anneeFormationString;
	String localisationString;

	public StudentCard() {
		super();
		
		Label lastNameLabel = new Label(this.lastNameString);
		lastNameLabel.setFont(Font.font("Futura", FontWeight.BOLD, 18));
		

		// Parametrage du label Prénom
		Label firstNameLabel = new Label(this.firstNameString);
		firstNameLabel.setFont(Font.font("Futura", FontWeight.BOLD, 18));
		
		HBox nameHBox = new HBox();
		nameHBox.getChildren().addAll(lastNameLabel, firstNameLabel);

		// Parametrage du label Formation
		Label formationLabel = new Label(this.formationString);
		formationLabel.setFont(Font.font("Futura", 14));

		// Parametrage du label Année de formation
		Label anneeFormationLabel = new Label(this.anneeFormationString);
		anneeFormationLabel.setFont(Font.font("Futura", 14));

		// Parametrage du label Departement
		Label localisationLabel = new Label("Département : " + this.localisationString);
		localisationLabel.setFont(Font.font("Futura", 14));
		
		this.add(nameHBox, 1, 3);
		this.add(formationLabel, 1, 4);
		this.add(anneeFormationLabel, 2, 4);
		this.add(localisationLabel, 1, 5);
		this.setVgap(30);
	}

	public StudentCard(String imagePath, String lastNameString, String firstNameString, String formationString,
			String anneeFormationString, String localisationString) {
		super();
		this.imagePath = imagePath;
		this.lastNameString = lastNameString;
		this.firstNameString = firstNameString;
		this.formationString = formationString;
		this.anneeFormationString = anneeFormationString;
		this.localisationString = localisationString;

//		this.setPadding(new Insets(20));
//		this.setHgap(10);
//		this.setVgap(10);
		this.setAlignment(Pos.CENTER);
		this.setStyle("-fx-border-color: black; -fx-background-color: #ffffff; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");

		// Parametrage photo
		ImageView photo = new ImageView(new Image(getClass().getResourceAsStream(imagePath)));
		photo.setFitHeight(150);
		photo.setFitWidth(150);
		photo.setStyle("-fx-border-color: black; -fx-border-radius: 15px;");
		photo.setPreserveRatio(true);

		// Parametrage du label Nom
		Label lastNameLabel = new Label(this.lastNameString);
		lastNameLabel.setFont(Font.font("Futura", FontWeight.BOLD, 25));
		lastNameLabel.setText(lastNameString.toUpperCase());

		// Parametrage du label Prénom
		Label firstNameLabel = new Label(this.firstNameString);
		firstNameLabel.setFont(Font.font("Futura", FontWeight.BOLD, 25));

		HBox nameHBox = new HBox();
		nameHBox.getChildren().addAll(lastNameLabel, firstNameLabel);
		nameHBox.setPadding(new Insets(0, 0, 20, 0));
		nameHBox.setSpacing(10);
		
		// Parametrage du label Formation
		Label formationLabel = new Label(this.formationString);
		formationLabel.setFont(Font.font("Futura", 14));

		// Parametrage du label Année de formation
		Label anneeFormationLabel = new Label(this.anneeFormationString);
		anneeFormationLabel.setFont(Font.font("Futura", 14));
		
		HBox formationHBox = new HBox();
		formationHBox.getChildren().addAll(formationLabel, anneeFormationLabel);
		formationHBox.setSpacing(20);

		// Parametrage du label Departement
		Label localisationLabel = new Label("Département : " + this.localisationString);
		localisationLabel.setFont(Font.font("Futura", 14));

		this.add(photo, 1, 0, 3, 2);
		this.add(nameHBox, 1, 3);
		this.add(formationHBox, 1, 4);
		this.add(localisationLabel, 1, 5);
		this.setVgap(20);

	}

}
