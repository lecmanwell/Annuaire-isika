package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import fr.isika.cda27.projet1.Annuaire_Isika.view.HomeView;
import fr.isika.cda27.projet1.Annuaire_Isika.view.HomeViewAdmin;
import fr.isika.cda27.projet1.Annuaire_Isika.view.UserDirectoryView;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CustomButton extends Button {

	Scene scene;

	public CustomButton(Scene scene) {
		super();
		this.scene = scene;

	}

	public void generateDocumentation() {
		this.setText("Comment fonction cet annuaire ?");
		this.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
		this.setOnAction((e) -> {
			System.out.println("clicked");
		});

	}

	// Button to go to HomeViewAdmin
	public void adminAccess() {
		this.setText("Accès administrateur");
		this.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");

		this.setOnAction((e) -> {
			System.out.println("clicked on adminAcces");
			scene.setRoot(new HomeViewAdmin(this.scene));
			System.out.println("check scene " + this.scene);

		});

	}

	// Button to go to UserDirectoryView
	public void goToDirectory() {
		this.setText("Accéder à l'annuaire");
		this.setStyle("-fx-background-color: #144d65; -fx-text-fill: white;");

		//
		this.setOnAction((e) -> {
			System.out.println("click");
			scene.setRoot(new UserDirectoryView(this.scene));
		});

	}

	// Button to print to PDF the students
	public void printDirectory() {
		this.setText("Imprimer le PDF");
		this.setStyle(
				"-fx-background-color: #144d65; -fx-text-fill: white; -fx-background-radius: 15; -fx-border-radius: 15;");
		this.setPadding(new Insets(3, 20, 3, 20));
	}

	// Button to disconnect from the admin role
	public void logOut() {
		this.setText("Deconnexion");
		this.setStyle(
				"-fx-background-color: transparent; -fx-text-fill: black; -fx-border-color: #db754a; -fx-border-radius: 15;");
		this.setPadding(new Insets(3, 20, 3, 20));

	}

	public void modifyStudent() {
		this.setText("Modifier");

	}

	public void deleteStudent() {
		this.setText("Supprimer");

	}

	public void addStudent() {
		this.setText("Ajouter un stagiaire");
		this.setStyle("-fx-background-color: #144d65; -fx-text-fill: white;");

	}

	// Button to go back to the HomeView from the HomeViewAdmin
	public void back() {
		this.setText("Retour");
		this.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");

	}

	// Buttons for the menu in HeaderViewGeneral

	public void homeButtonTitle() {
		this.setText("Accueil");
		this.setStyle("-fx-background-color: transparent;");
		this.setFont(Font.font("Futura", FontWeight.BOLD, 14));

		// hover effect
		this.setOnMouseEntered((e) -> {
			this.setTextFill(Color.web("#adb6b6"));
		});
		this.setOnMouseExited((e) -> {
			this.setTextFill(Color.web("#333333"));
		});

		// go to page action
		this.setOnAction((e) -> {
			scene.setRoot(new HomeView(scene));
		});
	}

	public void goToDirectoryTitle() {
		this.setText("Annuaire");
		this.setStyle("-fx-background-color: transparent;");
		this.setFont(Font.font("Futura", FontWeight.BOLD, 14));

		// hover effect
		this.setOnMouseEntered((e) -> {
			this.setTextFill(Color.web("#adb6b6"));
		});
		this.setOnMouseExited((e) -> {
			this.setTextFill(Color.web("#333333"));
		});

		// go to page action
		this.setOnAction((e) -> {
			scene.setRoot(new UserDirectoryView(scene));
		});

	}

	public void adminAccessTitle() {
		this.setText("Administrateur");
		this.setStyle("-fx-background-color: transparent;");
		this.setFont(Font.font("Futura", FontWeight.BOLD, 14));

		// hover effect
		this.setOnMouseEntered((e) -> {
			this.setTextFill(Color.web("#adb6b6"));
		});
		this.setOnMouseExited((e) -> {
			this.setTextFill(Color.web("#333333"));
		});

		// go to page action. IT NEEDS TO BE FILLED WITH THE SCENE OF THE
		// ADMINDIRECTORYVIEW
//		btn.setOnAction((e) -> {
//			scene.setRoot(new ----------(scene));
//		});

	}

	public void addStudentFromFields(TextField lastNameTextField, TextField firstNameTextField,
			TextField locationTextField, TextField promoTextField, TextField yearPromoTextField) {
		this.setText("Valider");
		this.setStyle("-fx-background-color: #144d65; -fx-padding: 10 20; -fx-text-fill: white;");

		this.setOnAction((e) -> {
			String lastNameInput = lastNameTextField.getText().trim();
			String firstNameInput = firstNameTextField.getText().trim();
			String locationInput = locationTextField.getText().trim();
			String namePromoInput = promoTextField.getText().trim();
			String yearPromoInput = yearPromoTextField.getText().trim();

			// if a field is empty, print an error
			if (lastNameInput.isEmpty() || firstNameInput.isEmpty() || locationInput.isEmpty()
					|| namePromoInput.isEmpty() || yearPromoInput.isEmpty()) {
				System.out.println("something is empty");
				return;
			}
			
			//if there are spaces, print an error
			if (Validator.containsSpace(lastNameInput,firstNameInput, locationInput, namePromoInput, yearPromoInput)) {
				System.out.println("there cant be any spaces");
			}
			
			if (Validator.containsNumbers(lastNameInput, firstNameInput)) {
				System.out.println("there cannot be any numbers");
			}
			
			if (Validator.containsSpecialCharacters(lastNameInput, firstNameInput, locationInput, namePromoInput, yearPromoInput)) {
				System.out.println("there cannot be any special characters");
			}
			
			
//			
//			System.out.println("Nom:" + lastNameInput);
//			System.out.println("Prenom :" + firstNameInput);
//			System.out.println("Localisation :" + locationInput);
//			System.out.println("Promo :" + namePromoInput);
//			System.out.println("Anne Promo :" + yearPromoInput);
			
			//all of them
			//filled, no spaces,no numbers(except for year), no special characters
			
			//last name and first name:
			//max length : 30 each
			
			//location
			//max length : 3
            
            //promo
            //max length: 12
            
            //yearPromo
            // only numbers, max length: 4,  parse Int to store it
            
//            // resetting the fields, put that in the case that everything is corrrect
//            lastNameTextField.clear();
//            firstNameTextField.clear();
//            locationTextField.clear();
//            promoTextField.clear();
//            yearPromoTextField.clear();
			
			

		});

	}

}
