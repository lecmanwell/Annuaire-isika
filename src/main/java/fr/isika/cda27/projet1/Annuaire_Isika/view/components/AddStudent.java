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
		addStudentVBox.setPadding(new Insets(300));

		// title
		Label titleLbl = new Label("Ajouter nouveau stagiaire");
		titleLbl.setFont(Font.font("Futura", FontWeight.BOLD, 40));

		// GridPane imput components
		GridPane gridAddStudentBox = new GridPane();
		
		Label lastNameLbl = new Label("Nom");
		TextField lastNameTextField = new TextField();
		
		Label firstNameLbl = new Label("Prénom");
		TextField firstNameTextField = new TextField();
		
		
		// adding the components to the grid


		// HBox for the button
		HBox btnValiderBox = new HBox();
		Button btnValider = new Button("Valider");
		btnValider.setStyle("-fx-background-color: #144d65; -fx-padding: 10 20; -fx-text-fill: white;");
		btnValiderBox.getChildren().add(btnValider);
		btnValiderBox.setAlignment(Pos.BOTTOM_RIGHT);

		// adding all elements as children
		addStudentVBox.getChildren().addAll(titleLbl, btnValiderBox);
		this.getChildren().add(addStudentVBox);
	}

}
