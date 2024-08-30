
package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import fr.isika.cda27.projet1.Annuaire_Isika.model.Student;
import fr.isika.cda27.projet1.Annuaire_Isika.model.TreeDAO;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


/**
 * Classe représentant une vue pour ajouter un nouveau stagiaire. 
 * Cette vue fournit un formulaire pour saisir les informations du stagiaire 
 * et un bouton pour valider l'ajout du stagiaire.
 */
public class AddStudent extends VBox {

	TreeDAO tree;
	
    /**
     * Constructeur de la classe.
     * 
     * @param tree L'objet {@link TreeDAO} utilisé pour ajouter le stagiaire à la base de données.
     */
	
	public AddStudent(TreeDAO tree) {
		super();
		this.tree = tree;

		VBox addStudentVBox = new VBox(10);

		// Création du titre
		Label titleLbl = new Label("Ajouter nouveau stagiaire");
		titleLbl.setFont(Font.font("Futura", FontWeight.BOLD, 40));

		// Création du GridPane pour les champs de saisie
		GridPane gridAddStudent = new GridPane();

		Label lastNameLbl = new Label("Nom");
		TextField lastNameTextField = new TextField();

		Label firstNameLbl = new Label("Prénom");
		TextField firstNameTextField = new TextField();

		Label promoLbl = new Label("Formation");
		TextField promoTextField = new TextField();

		Label yearPromoLbl = new Label("Anne Formation");
		TextField yearPromoTextField = new TextField();

		Label locationLbl = new Label("Localisation");
		TextField locationTextField = new TextField();

		// Ajout des composants au GridPane
		gridAddStudent.add(lastNameLbl, 0, 0);
		gridAddStudent.add(lastNameTextField, 1, 0);
		gridAddStudent.add(firstNameLbl, 0, 1);
		gridAddStudent.add(firstNameTextField, 1, 1);
		gridAddStudent.add(promoLbl, 0, 2);
		gridAddStudent.add(promoTextField, 1, 2);
		gridAddStudent.add(yearPromoLbl, 0, 3);
		gridAddStudent.add(yearPromoTextField, 1, 3);
		gridAddStudent.add(locationLbl, 0, 4);
		gridAddStudent.add(locationTextField, 1, 4);

		// Configuration des espacements entre les composants et alignement
		gridAddStudent.setHgap(15);
		gridAddStudent.setVgap(15);
		gridAddStudent.setAlignment(Pos.CENTER);

		// Création de la BorderPane pour le bouton de validation
		BorderPane btnValiderBox = new BorderPane();
		Label studentAdded = new Label();
		studentAdded.setFont(Font.font("Futura", 1));
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
				System.err.println("Certains champs sont vides.");
				return;
			}

			if (!(Validator.isValidName(lastNameInput, firstNameInput))) {
				System.err.println("Les noms ne peuvent contenir que des lettres, espaces, -, '");
				return;
			}

			if (!(Validator.isValidPromo(namePromoInput))) {
				System.err.println("La formation ne peut contenir que des lettres, chiffres et espaces.");
				return;
			}

			if (Validator.containsSpecialCharacters(locationInput, yearPromoInput)) {
				System.err.println("La localisation et l'année de formation ne doivent pas contenir de caractères spéciaux.");
				return;
			}

			if (Validator.isYear(yearPromoInput)) {
				yearPromoInt = Integer.parseInt(yearPromoInput);
			} else {
				System.err.println("L'année de formation n'est pas valide.");
				return;
			}

			if (!(Validator.maxLength(lastNameInput, 30))) {
				System.err.println("Le nom ne peut pas dépasser 30 caractères.");
				return;
			}

			if (!(Validator.maxLength(firstNameInput, 30))) {
				System.err.println("Le prénom ne peut pas dépasser 30 caractères.");
				return;
			}

			if (!(Validator.maxLength(locationInput, 3))) {
				System.err.println("La localisation ne peut pas dépasser 3 caractères.");
				return;
			}

			if (!(Validator.maxLength(namePromoInput, 12))) {
				System.err.println("Le nom de la formation ne peut pas dépasser 12 caractères.");
				return;
			}
			
			// Création du nouvel étudiant et ajout au TreeDAO
			Student student = new Student (lastNameInput, firstNameInput, locationInput, namePromoInput, yearPromoInt);
			tree.addToTree(student);
			System.out.println("Nom:" + lastNameInput);
			System.out.println("Prenom :" + firstNameInput);
			System.out.println("Localisation :" + locationInput);
			System.out.println("Promo :" + namePromoInput);
			System.out.println("Anne Promo :" + yearPromoInput);

			// Réinitialisation des champs de saisie
			lastNameTextField.clear();
			firstNameTextField.clear();
			locationTextField.clear();
			promoTextField.clear();
			yearPromoTextField.clear();
			studentAdded.setText("Nouveau stagiaire enregistré." + "\n" + lastNameInput + " " + firstNameInput + ", "
					+ locationInput + "\nFormation : " + namePromoInput + " - " + yearPromoInput);

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
