
package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

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

public class AddStudent extends VBox {

	public AddStudent() {
		super();

		VBox addStudentVBox = new VBox(10);
//		addStudentVBox.setPadding(new Insets(300));

		// title
		Label titleLbl = new Label("Ajouter nouveau stagiaire");
		titleLbl.setFont(Font.font("Futura", FontWeight.BOLD, 40));

		// GridPane imput components
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

		// adding the components to the grid
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

		// gap between components and center position
		gridAddStudent.setHgap(15);
		gridAddStudent.setVgap(15);
		gridAddStudent.setAlignment(Pos.CENTER);

		// HBox for the button
		BorderPane btnValiderBox = new BorderPane();
		Label studentAdded = new Label();
		studentAdded.setFont(Font.font("Futura", 1));
		CustomButton btnValider = new CustomButton(null);
		btnValider.setOnAction((e) -> {
			String lastNameInput = lastNameTextField.getText().trim().toUpperCase();
			String firstNameInput = firstNameTextField.getText().trim();
			String locationInput = locationTextField.getText().trim();
			String namePromoInput = promoTextField.getText().trim();
			String yearPromoInput = yearPromoTextField.getText().trim();
			int yearPromoInt;

			// if a field is empty, print an error
			if (lastNameInput.isEmpty() || firstNameInput.isEmpty() || locationInput.isEmpty()
					|| namePromoInput.isEmpty() || yearPromoInput.isEmpty()) {
				System.err.println("something is empty");
				return;
			}

			// if first or last name is not valid name, print an error
			if (!(Validator.isValidName(lastNameInput, firstNameInput))) {
				System.err.println("name can only contain: a-z, spaces, -, '");
				return;
			}

			// if promo name is not valid, print error
			if (!(Validator.isValidPromo(namePromoInput))) {
				System.err.println("name promo can only contain: a-z, 0-9, spaces");
				return;
			}

			// if special characters, print an error
			if (Validator.containsSpecialCharacters(locationInput, yearPromoInput)) {
				System.err.println("there cant be any special characters in year or location");
				return;
			}

			// if year is not a valid year, print an error
			if (Validator.isYear(yearPromoInput)) {
				yearPromoInt = Integer.parseInt(yearPromoInput);
			} else {
				System.err.println("is not a valid year");
				return;
			}

			// if last name <=30 chars
			if (!(Validator.maxLength(lastNameInput, 30))) {
				System.err.println("last name cant be longer than 30 chars");
				return;
			}

			// if first name <=30 chars
			if (!(Validator.maxLength(firstNameInput, 30))) {
				System.err.println("first name cant be longer than 30 chars");
				return;
			}

			// if location <= 3 chars
			if (!(Validator.maxLength(locationInput, 3))) {
				System.err.println("location cant be longer than 3 chars");
				return;
			}

			// if namepromo <= chars
			if (!(Validator.maxLength(namePromoInput, 12))) {
				System.err.println("name promo cannot be longer than 12 chars");
				return;
			}

			System.out.println("Nom:" + lastNameInput);
			System.out.println("Prenom :" + firstNameInput);
			System.out.println("Localisation :" + locationInput);
			System.out.println("Promo :" + namePromoInput);
			System.out.println("Anne Promo :" + yearPromoInput);

			// resetting the fields
			lastNameTextField.clear();
			firstNameTextField.clear();
			locationTextField.clear();
			promoTextField.clear();
			yearPromoTextField.clear();
			studentAdded.setText("Nouveau stagiaire enregistré." + "\n" + lastNameInput + " " + firstNameInput + ", "
					+ locationInput + "\nFormation : " + namePromoInput + " - " + yearPromoInput);

		});

//		btnValider.addStudentFromFields(lastNameInput, firstNameInput, locationInput, namePromoInput, yearPromoInput);
		btnValider.addStudentFromFields(lastNameTextField, firstNameTextField, locationTextField, promoTextField,
				yearPromoTextField);

//		btnValiderBox.getChildren().addAll(studentAdded, btnValider);
		btnValiderBox.setLeft(studentAdded);
		btnValiderBox.setCenter(btnValider);

		// adding all elements as children
		addStudentVBox.getChildren().addAll(titleLbl, gridAddStudent, btnValiderBox);
		this.getChildren().add(addStudentVBox);
	}

}
