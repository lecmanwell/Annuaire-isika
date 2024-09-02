
package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import fr.isika.cda27.projet1.Annuaire_Isika.model.Student;
import fr.isika.cda27.projet1.Annuaire_Isika.model.Tree;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;


/**
 * Classe représentant une vue pour ajouter un nouveau stagiaire. 
 * Cette vue fournit un formulaire pour saisir les informations du stagiaire 
 * et un bouton pour valider l'ajout du stagiaire.
 */
public class AddStudent extends VBox {

	Tree tree;
	StudentListAdmin studentList;
    /**
     * Constructeur de la classe.
     * 
     * @param tree L'objet {@link Tree} utilisé pour ajouter le stagiaire à la base de données.
     */
	
	public AddStudent(Tree tree, StudentListAdmin studentList) {
		super();
		this.tree = tree;
		this.studentList = studentList;

		VBox addStudentVBox = new VBox();

		// Création du titre
		Label titleLbl = new Label("Ajouter nouveau stagiaire");
		titleLbl.setTextAlignment(TextAlignment.CENTER);;
		titleLbl.setFont(Font.font("Futura", FontWeight.BOLD, 40));
		titleLbl.setPadding(new Insets(0, 0, 20, 0));
		// Création du GridPane pour les champs de saisie
		GridPane gridAddStudent = new GridPane();
		gridAddStudent.setVgap(0);
		Label lastNameLblError = new Label("Le nom peut contenir que 30 caractères : lettres, espaces, -, '");
		lastNameLblError.setFont(Font.font("Futura", 9));
		lastNameLblError.setTextFill(Color.RED);
		lastNameLblError.setGraphicTextGap(0);
		lastNameLblError.setVisible(false);
		Label lastNameLbl = new Label("Nom");
		lastNameLbl.setFont(Font.font("Futura", 12));
		TextField lastNameTextField = new TextField();
		lastNameTextField.setFont(Font.font("Futura", FontWeight.NORMAL, 12));
		lastNameTextField.setPadding(new Insets(1, 1, 1, 1));

		Label firstNameLblError = new Label("Le prénom peut contenir que 30 caractères : lettres, espaces, -, '");
		firstNameLblError.setTextFill(Color.RED);
		firstNameLblError.setFont(Font.font("Futura", 9));
		firstNameLblError.setGraphicTextGap(0);
		firstNameLblError.setVisible(false);
		Label firstNameLbl = new Label("Prénom");
		firstNameLbl.setFont(Font.font("Futura", 12));
		TextField firstNameTextField = new TextField();
		firstNameTextField.setFont(Font.font("Futura", FontWeight.NORMAL, 12));
		firstNameTextField.setPadding(new Insets(1, 1, 1, 1));

		Label promoLblError = new Label("La formation peut contenir que 12 caractères : lettres, chiffres et espaces.");
		promoLblError.setTextFill(Color.RED);
		promoLblError.setFont(Font.font("Futura", 9));
		promoLblError.setGraphicTextGap(0);
		promoLblError.setVisible(false);
		Label promoLbl = new Label("Formation");
		promoLbl.setFont(Font.font("Futura", 12));
		TextField promoTextField = new TextField();
		promoTextField.setFont(Font.font("Futura", FontWeight.NORMAL, 12));
		promoTextField.setPadding(new Insets(1, 1, 1, 1));

		Label yearPromoLblError = new Label("L'année de la formation doit être au format YYYY");
		yearPromoLblError.setTextFill(Color.RED);
		yearPromoLblError.setFont(Font.font("Futura", 9));
		yearPromoLblError.setGraphicTextGap(0);
		yearPromoLblError.setVisible(false);
		Label yearPromoLbl = new Label("Année de formation");
		yearPromoLbl.setFont(Font.font("Futura", 12));
		TextField yearPromoTextField = new TextField();
		yearPromoTextField.setFont(Font.font("Futura", FontWeight.NORMAL, 12));
		yearPromoTextField.setPadding(new Insets(1, 1, 1, 1));
		
		Label locationLblError = new Label("La localisation peut contenir 3 caractères : chiffres et lettre");
		locationLblError.setTextFill(Color.RED);
		locationLblError.setFont(Font.font("Futura", 9));
		locationLblError.setGraphicTextGap(0);
		locationLblError.setVisible(false);
		Label locationLbl = new Label("Localisation");
		locationLbl.setFont(Font.font("Futura", 12));
		TextField locationTextField = new TextField();
		locationTextField.setFont(Font.font("Futura", FontWeight.NORMAL, 12));
		locationTextField.setPadding(new Insets(1, 1, 1, 1));

		// Ajout des composants au GridPane
		
		gridAddStudent.add(lastNameLbl, 0, 0);
		gridAddStudent.add(lastNameTextField, 1, 0);
		gridAddStudent.add(lastNameLblError, 0, 1, 2, 1);
		gridAddStudent.add(firstNameLbl, 0, 2);
		gridAddStudent.add(firstNameTextField, 1, 2);
		gridAddStudent.add(firstNameLblError, 0, 3, 2, 1);
		gridAddStudent.add(promoLbl, 0, 4);
		gridAddStudent.add(promoTextField, 1, 4);
		gridAddStudent.add(promoLblError, 1, 5, 2, 1);
		gridAddStudent.add(yearPromoLbl, 0, 6);
		gridAddStudent.add(yearPromoTextField, 1, 6);
		gridAddStudent.add(yearPromoLblError, 0, 7, 2, 1);
		gridAddStudent.add(locationLbl, 0, 8);
		gridAddStudent.add(locationTextField, 1, 8);
		gridAddStudent.add(locationLblError, 0, 9, 2, 1);

		// Configuration des espacements entre les composants et alignement
		gridAddStudent.setHgap(15);
		gridAddStudent.setVgap(5);
		gridAddStudent.setAlignment(Pos.CENTER);

		// Création de la BorderPane pour le bouton de validation
		BorderPane btnValiderBox = new BorderPane();
		Label studentAdded = new Label();
		studentAdded.setFont(Font.font("Futura", 9));
		CustomButton btnValider = new CustomButton(null, this.tree);
		btnValider.setOnAction((e) -> {
			String lastNameInput = lastNameTextField.getText().trim().toUpperCase();
			String firstNameInput = firstNameTextField.getText().trim();
			String locationInput = locationTextField.getText().trim();
			String namePromoInput = promoTextField.getText().trim();
			String yearPromoInput = yearPromoTextField.getText().trim();
			int yearPromoInt;

			// Validation des champs de saisie
			if (lastNameInput.isEmpty() || firstNameInput.isEmpty() || locationInput.isEmpty()
					|| namePromoInput.isEmpty() || yearPromoInput.isEmpty()) {
				locationLblError.setText("Certains champs sont vides");
				locationLblError.setVisible(true);
				return;
			}

			if (!(Validator.isValidName(lastNameInput)) || !(Validator.maxLength(lastNameInput, 30))) {
				lastNameLblError.setVisible(true);
				return;
			} else {
				lastNameLblError.setVisible(false);
			}
			if (!(Validator.isValidName(firstNameInput)) || !(Validator.maxLength(firstNameInput, 30))) {
				firstNameLblError.setVisible(true);
				return;
			} else {
				firstNameLblError.setVisible(false);
			}

			if (!(Validator.isValidPromo(namePromoInput)) || !(Validator.maxLength(namePromoInput, 12))) {
				promoLblError.setVisible(true);
				return;
			} else {
				promoLblError.setVisible(false);
			}
			
			if ((Validator.containsSpecialCharacters(locationInput)) || !(Validator.maxLength(locationInput, 3))) {
				locationLblError.setVisible(true);
				return;
			} else {
				locationLblError.setVisible(false);
			}
			
			if (Validator.containsSpecialCharacters(yearPromoInput)) {
				yearPromoLblError.setVisible(true);
				return;
			}
			
			if (Validator.isYear(yearPromoInput)) {
				yearPromoInt = Integer.parseInt(yearPromoInput);
				yearPromoLblError.setVisible(false);
			} else {
				yearPromoLblError.setVisible(true);
				return;
			}
		

			
			// Création du nouvel étudiant et ajout au TreeDAO
			Student student = new Student (lastNameInput, firstNameInput, locationInput, namePromoInput, yearPromoInt);
			this.tree.addToTree(student);


			// Réinitialisation des champs de saisie
			lastNameTextField.clear();
			firstNameTextField.clear();
			locationTextField.clear();
			promoTextField.clear();
			yearPromoTextField.clear();
			studentAdded.setText("Stagiaire enregistré : " + "\n" + lastNameInput + " " + firstNameInput + ", "
					+ locationInput + "\nFormation : " + namePromoInput + " - " + yearPromoInput);
			studentAdded.setStyle("-fx-text-fill: green;");
		});

		// Configuration du bouton de validation
//		btnValider.addStudentFromFields(lastNameInput, firstNameInput, locationInput, namePromoInput, yearPromoInput);
		btnValider.addStudentFromFields(lastNameTextField, firstNameTextField, locationTextField, promoTextField,
				yearPromoTextField);

		btnValiderBox.setLeft(studentAdded);
		btnValiderBox.setCenter(btnValider);

		// Ajout des éléments dans le VBox principal
		addStudentVBox.getChildren().addAll(titleLbl, gridAddStudent, btnValiderBox);
		this.getChildren().add(addStudentVBox);
	}

}
