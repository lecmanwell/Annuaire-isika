package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class LoginAdmin extends VBox {
	
	Scene scene;

	public LoginAdmin(Scene scene) {
		super();
		this.scene = scene;
		
		VBox loginVBox = new VBox(15);
//		loginVBox.setPadding(new Insets(140));
	

		//title
		Label titleLbl = new Label("Accès administrateur");
		titleLbl.setFont(Font.font("Futura", FontWeight.BOLD, 36));
		
		//GridPane for the login components
		GridPane gridLoginBox = new GridPane();
		Label userNameLbl = new Label("Identifiant");
		TextField userNameTextField = new TextField();
		Label passwordLbl = new Label("Mot de passe");
		PasswordField passwordField = new PasswordField();
		//adding the components to the grid
		gridLoginBox.add(userNameLbl,0,0);
		gridLoginBox.add(userNameTextField,1,0);
		gridLoginBox.add(passwordLbl,0,1);
		gridLoginBox.add(passwordField,1,1);
		gridLoginBox.setHgap(15);
		gridLoginBox.setVgap(15);
		gridLoginBox.setAlignment(Pos.CENTER);
		
		//HBox for the button		
		HBox btnAccessBox = new HBox();
		Button btnAccess = new Button("Accéder à l'annuaire");
		btnAccess.setStyle("-fx-background-color: #144d65; -fx-padding: 10 20; -fx-text-fill: white;");
		btnAccessBox.getChildren().add(btnAccess);
		btnAccessBox.setAlignment(Pos.CENTER);
		
		//adding all elements as children
		loginVBox.getChildren().addAll(titleLbl, gridLoginBox, btnAccessBox);
		this.getChildren().add(loginVBox);
		

	}

	
}
