
package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class AddStudent extends VBox {

	public AddStudent() {
		super();

		VBox addStudentVBox = new VBox(15);
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

//		
		// HBox for the button
		HBox btnValiderBox = new HBox();
		CustomButton btnValider = new CustomButton(null);
		
//		btnValider.addStudentFromFields(lastNameInput, firstNameInput, locationInput, namePromoInput, yearPromoInput);
        btnValider.addStudentFromFields(lastNameTextField, firstNameTextField, locationTextField, promoTextField, yearPromoTextField);

		
		btnValiderBox.getChildren().add(btnValider);
		btnValiderBox.setAlignment(Pos.BOTTOM_RIGHT);

		// adding all elements as children
		addStudentVBox.getChildren().addAll(titleLbl, gridAddStudent, btnValiderBox);
		this.getChildren().add(addStudentVBox);
	}

}
