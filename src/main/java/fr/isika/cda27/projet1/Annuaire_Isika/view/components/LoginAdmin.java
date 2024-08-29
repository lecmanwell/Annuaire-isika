package fr.isika.cda27.projet1.Annuaire_Isika.view.components;

import fr.isika.cda27.projet1.Annuaire_Isika.view.AdminDirectoryView;
import fr.isika.cda27.projet1.Annuaire_Isika.view.HomeView;
import fr.isika.cda27.projet1.Annuaire_Isika.view.login.Admin;
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
		
		
		//button
		Button btnAccess = new Button("Accéder à l'annuaire");
		btnAccess.setStyle("-fx-background-color: #144d65; -fx-padding: 10 20; -fx-text-fill: white;");
		btnAccess.setOnAction((e) -> {
			Admin admin = new Admin();
			String usernameInput = userNameTextField.getText();
			String passwordInput = passwordField.getText();
			
//			go to Admin pages
			if (Admin.validateAdmin(usernameInput, passwordInput)) {
				scene.setRoot(new AdminDirectoryView(scene));
			} else {
				//display error or something to know the password username was wrong
				titleLbl.setText("Identifiant ou mot de passe incorrect");
				titleLbl.setFont(Font.font("Futura", FontWeight.BOLD, 28));
			}
			
		});
		
		
		//HBox for the button
		HBox btnAccessBox = new HBox();
		btnAccessBox.getChildren().add(btnAccess);
		btnAccessBox.setAlignment(Pos.CENTER);
		
		//adding all elements as children
		loginVBox.getChildren().addAll(titleLbl, gridLoginBox, btnAccessBox);
		this.getChildren().add(loginVBox);
		

	}

	
}
