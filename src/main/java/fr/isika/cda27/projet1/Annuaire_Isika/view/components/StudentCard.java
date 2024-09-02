package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import fr.isika.cda27.projet1.Annuaire_Isika.model.Student;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Représente une carte d'étudiant affichée dans l'interface. La carte contient
 * les informations d'un étudiant, telles que le nom, le prénom, la formation,
 * l'année de formation, et la localisation. Elle peut également afficher une
 * photo de l'étudiant.
 */

public class StudentCard extends GridPane {

	String imagePath;
	String lastNameString;
	String firstNameString;
	String formationString;
	String anneeFormationString;
	String localisationString;

	/**
	 * Constructeur pour créer une carte d'étudiant sans image.
	 *
	 * @param name           Nom de l'étudiant.
	 * @param firstname      Prénom de l'étudiant.
	 * @param formation      Formation de l'étudiant.
	 * @param anneeFormation Année de formation de l'étudiant.
	 * @param localisation   Localisation de l'étudiant.
	 */

	public StudentCard(Student stud) {
		super();
		this.lastNameString = stud.getLastName();
		this.firstNameString = stud.getFirstName();
		this.formationString = stud.getNamePromo();
		this.anneeFormationString = String.valueOf(stud.getYearPromo());
		this.localisationString = stud.getLocation();
		this.setAlignment(Pos.CENTER);
		Label lastNameLabel = new Label(this.lastNameString);
		lastNameLabel.setFont(Font.font("Futura", FontWeight.BOLD, 12));

		// Parametrage du label Prénom
		Label firstNameLabel = new Label(this.firstNameString);
		firstNameLabel.setFont(Font.font("Futura", FontWeight.BOLD, 12));

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

		this.add(nameHBox, 0, 0);
		this.add(formationLabel, 0, 1);
		this.add(anneeFormationLabel, 0, 2);
		this.add(localisationLabel, 0, 3);

		this.setStyle(
				"-fx-border-color: black;-fx-border-radius: 10px;-fx-background-radius: 10px; -fx-background-color: #ffffff; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
		this.setPadding(new Insets(10));
	}

	/**
	 * Constructeur pour créer une carte d'étudiant avec une image.
	 *
	 * @param imagePath      Chemin de l'image de l'étudiant.
	 * @param lastName       Nom de l'étudiant.
	 * @param firstName      Prénom de l'étudiant.
	 * @param formation      Formation de l'étudiant.
	 * @param anneeFormation Année de formation de l'étudiant.
	 * @param localisation   Localisation de l'étudiant.
	 */

	public StudentCard(String imagePath, String lastNameString, String firstNameString, String formationString,
			String anneeFormationString, String localisationString) {
		super();
		this.imagePath = imagePath;
		this.lastNameString = lastNameString;
		this.firstNameString = firstNameString;
		this.formationString = formationString;
		this.anneeFormationString = anneeFormationString;
		this.localisationString = localisationString;

		this.setPadding(new Insets(20));
		this.setMaxWidth(Double.MAX_VALUE);
		this.setAlignment(Pos.CENTER);
		this.setHeight(50);
		this.setWidth(50);
		this.setStyle(
				"-fx-border-color: black;-fx-border-radius: 30px;-fx-background-radius: 30px; -fx-background-color: #ffffff; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");

		// Parametrage photo
		ImageView photo = new ImageView(new Image(getClass().getResourceAsStream(imagePath)));
		photo.setFitHeight(300);
		photo.setFitWidth(300);
		photo.setPreserveRatio(true);

		// Paramétrage du label Nom
		Label lastNameLabel = new Label(this.lastNameString);
		lastNameLabel.setFont(Font.font("Futura", FontWeight.BOLD, 25));
		lastNameLabel.setText(lastNameString.toUpperCase());

		// Paramétrage du label Prénom
		Label firstNameLabel = new Label(this.firstNameString);
		firstNameLabel.setFont(Font.font("Futura", FontWeight.BOLD, 25));

		HBox nameHBox = new HBox();
		nameHBox.getChildren().addAll(lastNameLabel, firstNameLabel);
		nameHBox.setSpacing(10);

		// Paramétrage du label Formation
		Label formationLabel = new Label(this.formationString);
		formationLabel.setFont(Font.font("Futura", 14));

		// Paramétrage du label Année de formation
		Label anneeFormationLabel = new Label(this.anneeFormationString);
		anneeFormationLabel.setFont(Font.font("Futura", 14));

		HBox formationHBox = new HBox();
		formationHBox.getChildren().addAll(formationLabel, anneeFormationLabel);
		formationHBox.setSpacing(20);

		// Paramétrage du label Département
		Label localisationLabel = new Label("Département : " + this.localisationString);
		localisationLabel.setFont(Font.font("Futura", 14));

		this.add(photo, 1, 0, 3, 2);
		this.add(nameHBox, 1, 3);
		this.add(formationHBox, 1, 4);
		this.add(localisationLabel, 1, 5);
		this.setVgap(20);

	}

	/**
	 * Getters et setters pour les attributs de la carte d'étudiant.'
	 */

	public String getLastNameString() {
		return lastNameString;
	}

	public void setLastNameString(String lastNameString) {
		this.lastNameString = lastNameString;
	}

	public String getFirstNameString() {
		return firstNameString;
	}

	public void setFirstNameString(String firstNameString) {
		this.firstNameString = firstNameString;
	}

	public String getFormationString() {
		return formationString;
	}

	public void setFormationString(String formationString) {
		this.formationString = formationString;
	}

	public String getAnneeFormationString() {
		return anneeFormationString;
	}

	public void setAnneeFormationString(String anneeFormationString) {
		this.anneeFormationString = anneeFormationString;
	}

	public String getLocalisationString() {
		return localisationString;
	}

	public void setLocalisationString(String localisationString) {
		this.localisationString = localisationString;
	}

	/**
	 * Retourne une représentation sous forme de chaîne de caractères de la carte de
	 * l'étudiant.
	 */
	@Override
	public String toString() {
		return "StudentCard [lastNameString=" + lastNameString + ", firstNameString=" + firstNameString
				+ ", formationString=" + formationString + ", anneeFormationString=" + anneeFormationString
				+ ", localisationString=" + localisationString + "]";
	}
}
