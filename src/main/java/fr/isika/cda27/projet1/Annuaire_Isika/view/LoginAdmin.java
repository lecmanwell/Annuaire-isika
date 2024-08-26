package fr.isika.cda27.projet1.Annuaire_Isika.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class LoginAdmin extends GridPane {

	public LoginAdmin() {
		super();
		
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(20));

		Label titleLabel = new Label("Accès administrateur");
		titleLabel.setFont(Font.font("Futura", FontWeight.BOLD, 36));
		Label adminIdentifiant = new Label("Identifiant");
		TextField identifiantTxtField = new TextField();
		Label adminMdp = new Label("Mot de passe");
		PasswordField mdpTxtField = new PasswordField();
		Button btn = new Button("Accéder à l'annuaire");
		btn.setStyle("-fx-background-color: #144d65; -fx-padding: 10 20; -fx-text-fill: white;");
		
		
		
		this.add(titleLabel, 0, 0, 4, 2);
		this.add(adminIdentifiant, 2, 3);
		this.add(identifiantTxtField, 3, 3);
		this.add(adminMdp, 2, 4);
		this.add(mdpTxtField, 3, 4);
		this.add(btn, 2, 5, 2, 1);
	}

	
}
